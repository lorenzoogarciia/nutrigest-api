package lgarcia.dev.nutrigest_api.models.DTOs.Diets.GET;

import lgarcia.dev.nutrigest_api.models.DietModel;

import java.sql.Timestamp;
import java.util.List;

public class DietDTO {
    private Long id;
    private String name;
    private String description;
    private Timestamp createdAt;
    private Long userId;
    private List<FoodInDietDTO> foodInDiet;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<FoodInDietDTO> getFoodInDiet() {
        return foodInDiet;
    }

    public void setFoodInDiet(List<FoodInDietDTO> foodInDiet) {
        this.foodInDiet = foodInDiet;
    }

    // Funciones

    public DietDTO mapToDietDTO(DietModel diet) {
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
}
