package lgarcia.dev.nutrigest_api.controllers;

import lgarcia.dev.nutrigest_api.models.AlimentModel;
import lgarcia.dev.nutrigest_api.models.DTOs.Nutritionists.GET.NutritionistDTO;
import lgarcia.dev.nutrigest_api.models.NutritionistModel;
import lgarcia.dev.nutrigest_api.services.NutritionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/nutritionist")
public class NutritionistController {
    @Autowired
    private NutritionistService nutritionistService;

    // GET Petitions
    @GetMapping
    public ArrayList<NutritionistDTO> getNutritionistDTO() {
        return this.nutritionistService.getNutritionist();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutritionistDTO> getNutritionistByIdDTO(@PathVariable Long id) {
        NutritionistDTO nutritionistDTO = this.nutritionistService.getNutritionistById(id);
        return ResponseEntity.ok(nutritionistDTO);
    }

    @GetMapping("/{id}/aliments")
    public List<AlimentModel> getAlimentsByNutritionistId(@PathVariable Long id) {
        return this.nutritionistService.getNutritionistAliments(id);
    }

    // POST Petitions
    @PostMapping
    public NutritionistModel storeNutritionist(@RequestBody NutritionistModel nutritionist) {
        return this.nutritionistService.storeNutritionist(nutritionist);
    }

    // PUT and DELETE Petitions
    @PutMapping("/{id}")
    public NutritionistModel updateNutritionist(@RequestBody NutritionistModel nutritionist, @PathVariable Long id) {
        return this.nutritionistService.updateNutritionist(nutritionist, id);
    }

    @DeleteMapping("/{id}")
    public void deleteNutritionist(@PathVariable Long id) {
        this.nutritionistService.deleteNutritionist(id);
    }
}
