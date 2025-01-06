package lgarcia.dev.nutrigest_api.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import lgarcia.dev.nutrigest_api.models.AlimentModel;
import lgarcia.dev.nutrigest_api.services.AlimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/aliments")
public class AlimentController {

    @Autowired
    private AlimentService alimentService;

    //GET Petitions
    @GetMapping
    public ArrayList<AlimentModel> getAliments() {
        return this.alimentService.getAliments();
    }

    @GetMapping("/{id}")
    public AlimentModel getAlimentById(@PathVariable Long id) {
        return this.alimentService.getAlimentById(id);
    }

    //POST Petitions
    @PostMapping
    public AlimentModel storeAliment(@RequestBody AlimentModel aliment) {
        return this.alimentService.storeAliment(aliment);
    }

    //PUT and DELETE Petitions
    @PutMapping("/{id}")
    public AlimentModel updateAliment(@RequestBody AlimentModel aliment, @PathVariable Long id) {
        return this.alimentService.updateAliment(aliment, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAliment(@PathVariable Long id) {
        this.alimentService.deleteAliment(id);
    }
}
