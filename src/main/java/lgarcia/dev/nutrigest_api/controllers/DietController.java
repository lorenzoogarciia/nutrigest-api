package lgarcia.dev.nutrigest_api.controllers;

import lgarcia.dev.nutrigest_api.models.DTOs.Diets.GET.DietDTO;
import lgarcia.dev.nutrigest_api.models.DTOs.Diets.POST.DietRequestDTO;
import lgarcia.dev.nutrigest_api.services.DietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diets")
public class DietController {

    @Autowired
    DietService dietService;

    @GetMapping
    public List<DietDTO> getDiets() {
        return dietService.getDiets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DietDTO> getDietById(@PathVariable Long id) {
        DietDTO diet = dietService.getDietById(id);
        return ResponseEntity.ok(diet);
    }

    @PostMapping
    public ResponseEntity<DietDTO> storeDiet(@RequestBody DietRequestDTO diet) {
        DietDTO createdDiet = dietService.storeDiet(diet);
        return ResponseEntity.status(201).body(createdDiet);
    }
}
