package lgarcia.dev.nutrigest_api.services;

import lgarcia.dev.nutrigest_api.models.AlimentModel;
import lgarcia.dev.nutrigest_api.models.DTOs.Aliments.GET.AlimentDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Aliments.POST.AddAlimentDTO;
import lgarcia.dev.nutrigest_api.repositories.IAlimentRepository;
import lgarcia.dev.nutrigest_api.repositories.ICategoryRepository;
import lgarcia.dev.nutrigest_api.repositories.INutritionistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlimentService {

    @Autowired
    IAlimentRepository alimentRepository;
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    INutritionistRepository nutritionistRepository;
    @Autowired
    private NutritionistService nutritionistService;

    //Obtener lista de alimentos
    public ArrayList<AlimentDTO> getAliments() {
        List<AlimentModel> aliments = alimentRepository.findAll();
        List<AlimentDTO> alimentDTOS = aliments.stream().map(aliment -> {
            AlimentDTO alimentDTO = new AlimentDTO();
            alimentDTO.setId(aliment.getId());
            alimentDTO.setName(aliment.getName());
            alimentDTO.setDescription(aliment.getDescription());
            alimentDTO.setProteins(aliment.getProteins());
            alimentDTO.setCarbs(aliment.getCarbs());
            alimentDTO.setFats(aliment.getFats());
            alimentDTO.setKcals(aliment.getKcals());
            alimentDTO.setFiber(aliment.getFiber());
            alimentDTO.setPhotoUrl(aliment.getPhoto_url());

            if(aliment.getCategory() != null) {
                alimentDTO.setCategory(aliment.getCategory());
            }

            if (aliment.getCreatedBy() != null) {
                alimentDTO.setCreatedBy(aliment.getCreatedBy().getId());
            }

            return alimentDTO;
        }).collect(Collectors.toList());

        return (ArrayList<AlimentDTO>) alimentDTOS;

    }

    //Obtener un alimento por su id
    public AlimentModel getAlimentById(Long id) {
        return alimentRepository.findById(id).orElse(null);
    }

    //Crear un alimento
    public AddAlimentDTO storeAliment(AddAlimentDTO alimentToAdd) {
        AlimentModel alimentModel = new AlimentModel();
        alimentModel.setName(alimentToAdd.getName());
        alimentModel.setDescription(alimentToAdd.getDescription());
        alimentModel.setProteins(alimentToAdd.getProteins());
        alimentModel.setCarbs(alimentToAdd.getCarbs());
        alimentModel.setFats(alimentToAdd.getFats());
        alimentModel.setKcals(alimentToAdd.getKcals());
        alimentModel.setFiber(alimentToAdd.getFiber());
        alimentModel.setPhoto_url(alimentToAdd.getPhotoUrl());
        alimentModel.setCategory(categoryRepository.findById(alimentToAdd.getCategory()).orElse(null));
        alimentModel.setCreatedBy(nutritionistRepository.findById(alimentToAdd.getCreatedBy()).orElse(null));
        try {
            alimentRepository.save(alimentModel);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el alimento");
        }
        return alimentToAdd;
    }

    //Actualizar un alimento
    public AlimentModel updateAliment(AlimentModel aliment, Long id) {
        AlimentModel alimentToUpdate = alimentRepository.findById(id).orElse(null);

        if (alimentToUpdate != null) {
            if (aliment.getName() != null) {
                alimentToUpdate.setName(aliment.getName());
            }

            if (aliment.getDescription() != null) {
                alimentToUpdate.setDescription(aliment.getDescription());
            }

            if (aliment.getProteins() != 0) {
                alimentToUpdate.setProteins(aliment.getProteins());
            }

            if (aliment.getCarbs() != 0) {
                alimentToUpdate.setCarbs(aliment.getCarbs());
            }

            if (aliment.getFats() != 0) {
                alimentToUpdate.setFats(aliment.getFats());
            }

            if (aliment.getKcals() != 0) {
                alimentToUpdate.setKcals(aliment.getKcals());
            }

            if (aliment.getFiber() != 0) {
                alimentToUpdate.setFiber(aliment.getFiber());
            }

            if (aliment.getPhoto_url() != null) {
                alimentToUpdate.setPhoto_url(aliment.getPhoto_url());
            }

            if (aliment.getCategory() != null) {
                alimentToUpdate.setCategory(aliment.getCategory());
            }

            return alimentRepository.save(alimentToUpdate);
        } else {
            throw new RuntimeException("Aliment not found");
        }
    }

    //Eliminar un alimento
    public void deleteAliment(Long id) {
        alimentRepository.deleteById(id);
    }
}
