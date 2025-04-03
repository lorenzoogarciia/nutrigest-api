package lgarcia.dev.nutrigest_api.services;

import lgarcia.dev.nutrigest_api.models.AlimentModel;
import lgarcia.dev.nutrigest_api.models.DTOs.Aliments.GET.AlimentDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Nutritionists.GET.NutritionistAlimentDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Nutritionists.GET.NutritionistDTO;
import lgarcia.dev.nutrigest_api.models.NutritionistModel;
import lgarcia.dev.nutrigest_api.repositories.IAlimentRepository;
import lgarcia.dev.nutrigest_api.repositories.INutritionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NutritionistService {

  @Autowired
  INutritionistRepository nutritionistRepository;
  @Autowired
  IAlimentRepository alimentRepository;

    // Función para obtener todos los nutricionistas
  public ArrayList<NutritionistDTO> getNutritionist() {
    List<NutritionistModel> nutritionists = nutritionistRepository.findAll();
    List<NutritionistDTO> nutritionistDTOS = nutritionists.stream().map(nutritionist -> {
      NutritionistDTO nutritionistDTO = new NutritionistDTO();
      nutritionistDTO.setId(nutritionist.getId());
      nutritionistDTO.setName(nutritionist.getName());
      nutritionistDTO.setLastName(nutritionist.getLastName());
      nutritionistDTO.setAddress(nutritionist.getAddress());
      nutritionistDTO.setPhone(nutritionist.getPhone());
      nutritionistDTO.setCif(nutritionist.getCif());
      nutritionistDTO.setEmail(nutritionist.getEmail());
      nutritionistDTO.setCreatedAt(nutritionist.getCreatedAt());

      if(nutritionist.getLicense() != null) {
        nutritionistDTO.setLicense(nutritionist.getLicense());
      } else {
        nutritionistDTO.setLicense(null);
      }

      return nutritionistDTO;
    }).collect(Collectors.toList());

    return (ArrayList<NutritionistDTO>) nutritionistDTOS;
  }

  // Función para obtener un nutricionista por su id
  public NutritionistDTO getNutritionistById(Long id) {
    NutritionistModel nutritionist = nutritionistRepository.findById(id).orElse(null);
    if (nutritionist != null) {
      NutritionistDTO nutritionistDTO = new NutritionistDTO();
        nutritionistDTO.setId(nutritionist.getId());
        nutritionistDTO.setName(nutritionist.getName());
        nutritionistDTO.setLastName(nutritionist.getLastName());
        nutritionistDTO.setAddress(nutritionist.getAddress());
        nutritionistDTO.setPhone(nutritionist.getPhone());
        nutritionistDTO.setCif(nutritionist.getCif());
        nutritionistDTO.setEmail(nutritionist.getEmail());
        nutritionistDTO.setCreatedAt(nutritionist.getCreatedAt());
        return nutritionistDTO;
    } else {
      return null;
    }
  }

  // Obtener alimentos creados por el nutricionista
    public List<NutritionistAlimentDTO> getNutritionistAliments(Long id) {
      List<AlimentModel> aliments = alimentRepository.findByCreatedBy_Id(id);

      return aliments.stream().map(aliment -> {
        NutritionistAlimentDTO alimentDTO = new NutritionistAlimentDTO();
        alimentDTO.setId(aliment.getId());
        alimentDTO.setName(aliment.getName());
        alimentDTO.setCategory(aliment.getCategory());
        alimentDTO.setDescription(aliment.getDescription());
        alimentDTO.setProteins(aliment.getProteins());
        alimentDTO.setCarbs(aliment.getCarbs());
        alimentDTO.setFats(aliment.getFats());
        alimentDTO.setKcals(aliment.getKcals());
        alimentDTO.setPhotoUrl(aliment.getPhoto_url());
        alimentDTO.setCreatedAt(aliment.getCreatedAt());
        alimentDTO.setCreatedBy(aliment.getCreatedBy().getId());
        return alimentDTO;
      }).collect(Collectors.toList());
    }

  // Función para almacenar un nutricionista
  public NutritionistModel storeNutritionist(NutritionistModel nutritionist) {
    return nutritionistRepository.save(nutritionist);
  }

  // Función para actualizar un nutricionista
  public NutritionistModel updateNutritionist(NutritionistModel nutritionist, Long id) {
    NutritionistModel nutritionistToUpdate = nutritionistRepository.findById(id).orElse(null);
    if (nutritionistToUpdate != null) {
      if(nutritionist.getName() != null) {
        nutritionistToUpdate.setName(nutritionist.getName());
      }

      if(nutritionist.getLastName() != null) {
        nutritionistToUpdate.setLastName(nutritionist.getLastName());
      }

      if(nutritionist.getAddress() != null) {
        nutritionistToUpdate.setAddress(nutritionist.getAddress());
      }

      if(nutritionist.getPhone() != null) {
        nutritionistToUpdate.setPhone(nutritionist.getPhone());
      }

      if(nutritionist.getCif() != null) {
        nutritionistToUpdate.setCif(nutritionist.getCif());
      }

      if(nutritionist.getEmail() != null) {
        nutritionistToUpdate.setEmail(nutritionist.getEmail());
      }
      return nutritionistRepository.save(nutritionistToUpdate);
    }
    return null;
  }

  // Función para eliminar un nutricionista
  public void deleteNutritionist(Long id) {
    nutritionistRepository.deleteById(id);
  }
}
