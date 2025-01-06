package lgarcia.dev.nutrigest_api.services;

import lgarcia.dev.nutrigest_api.models.AlimentModel;
import lgarcia.dev.nutrigest_api.models.DTOs.Diets.GET.DietDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Diets.GET.FoodInDietDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Diets.POST.DietRequestDTO;
import lgarcia.dev.nutrigest_api.models.DietModel;
import lgarcia.dev.nutrigest_api.models.FoodDietModel;
import lgarcia.dev.nutrigest_api.models.UserModel;
import lgarcia.dev.nutrigest_api.repositories.IAlimentRepository;
import lgarcia.dev.nutrigest_api.repositories.IDietRepository;
import lgarcia.dev.nutrigest_api.repositories.IFoodDietRepository;
import lgarcia.dev.nutrigest_api.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DietService {

    @Autowired
    IDietRepository dietRepository;

    @Autowired
    IAlimentRepository alimentRepository;

    @Autowired
    IFoodDietRepository foodDietRepository;

    @Autowired
    IUserRepository userRepository;

    //Función para obtener todas las dietas
    public List<DietDTO> getDiets() {
        //Recuperamos todas las dietas
        List<DietModel> diets = dietRepository.findAll();

        //Convertimos las dietas a DTO
        List<DietDTO> dietDTOs = diets.stream().map(diet -> {
            DietDTO dto = new DietDTO();
            dto.setId(diet.getId());
            dto.setName(diet.getName());
            dto.setDescription(diet.getDescription());
            dto.setCreatedAt(diet.getCreated_at());

            //Buscamos el usuario asociado a la dieta
            if (diet.getUser() != null) {
                dto.setUserId(diet.getUser().getId());
            }

            //Convertimos los alimentos de la dieta a DTO
            List<FoodInDietDTO> foodsDTOs = diet.getFoodDiet().stream().map(fd -> {
                FoodInDietDTO foodDTO = new FoodInDietDTO();
                foodDTO.setAlimentId(fd.getAliment().getId());
                foodDTO.setAlimentName(fd.getAliment().getName());
                foodDTO.setQuantity(fd.getQuantity());
                foodDTO.setSection(fd.getSection().name());
                return foodDTO;
            }).toList();

            dto.setFoodInDiet(foodsDTOs);
            return dto;
        }).toList();

        return dietDTOs;
    }

    //Función para obtener una dieta por su id
    public DietDTO getDietById(Long id) {
        DietModel diet = dietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dieta no encontrada con ID: " + id));

        DietDTO dietDTO = new DietDTO();
        dietDTO.setId(diet.getId());
        dietDTO.setName(diet.getName());
        dietDTO.setDescription(diet.getDescription());
        dietDTO.setCreatedAt(diet.getCreated_at());

        if(diet.getUser() != null) {
            dietDTO.setUserId(diet.getUser().getId());
        }

        List<FoodInDietDTO> foodsDTO = diet.getFoodDiet().stream().map(fd -> {
            FoodInDietDTO foodDTO = new FoodInDietDTO();
            foodDTO.setAlimentId(fd.getAliment().getId());
            foodDTO.setAlimentName(fd.getAliment().getName());
            foodDTO.setQuantity(fd.getQuantity());
            foodDTO.setSection(fd.getSection().name());
            return foodDTO;
        }).toList();

        dietDTO.setFoodInDiet(foodsDTO);

        return dietDTO;
    }


    //Función para guardar una dieta

    public DietDTO storeDiet(DietRequestDTO dietRequest) {
        //Creamos la dieta
        DietModel diet = new DietModel();
        diet.setName(dietRequest.getName());
        diet.setDescription(dietRequest.getDescription());

        //Buscamos usuario
        if (dietRequest.getUserId() != 0) {
            UserModel user = userRepository.findById(dietRequest.getUserId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + dietRequest.getUserId()));
            diet.setUser(user);
        }

        diet = dietRepository.save(diet);

        //Asignamos alimentos a la dieta
        List<DietRequestDTO.FoodDietsRequestDTO> foodDiets = dietRequest.getFoodDiets();
        for(DietRequestDTO.FoodDietsRequestDTO foodDietRequest : foodDiets) {
            AlimentModel aliment = alimentRepository.findById(foodDietRequest.getFoodId())
                    .orElseThrow(() -> new RuntimeException("Aliment not found: " + foodDietRequest.getFoodId()));

            FoodDietModel foodDiet = new FoodDietModel();
            foodDiet.setDiet(diet);
            foodDiet.setAliment(aliment);
            foodDiet.setQuantity(foodDietRequest.getQuantity());
            foodDiet.setSection(foodDietRequest.getSection());

            foodDietRepository.save(foodDiet);
        }
        DietDTO dietDTO = new DietDTO();
        dietDTO = dietDTO.mapToDietDTO(diet);
        return dietDTO;
    }
}
