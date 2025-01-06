package lgarcia.dev.nutrigest_api.services;

import lgarcia.dev.nutrigest_api.models.AlimentModel;
import lgarcia.dev.nutrigest_api.repositories.IAlimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AlimentService {

    @Autowired
    IAlimentRepository alimentRepository;

    //Obtener lista de alimentos
    public ArrayList<AlimentModel> getAliments() {
        return (ArrayList<AlimentModel>) alimentRepository.findAll();
    }

    //Obtener un alimento por su id
    public AlimentModel getAlimentById(Long id) {
        return alimentRepository.findById(id).orElse(null);
    }

    //Crear un alimento
    public AlimentModel storeAliment(AlimentModel aliment) {
        return alimentRepository.save(aliment);
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
