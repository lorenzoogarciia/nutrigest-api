package lgarcia.dev.nutrigest_api.models.DTOs.Diets.POST;

import lgarcia.dev.nutrigest_api.models.FoodDietModel;

import java.util.List;

public class DietRequestDTO {
    private String name;
    private String description;
    private long userId;
    private List<FoodDietsRequestDTO> foodDiets;

    // Getters and Setters

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

    public long getUserId() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public List<FoodDietsRequestDTO> getFoodDiets() {
        return foodDiets;
    }

    public void setFoodDiets(List<FoodDietsRequestDTO> foodDiets) {
        this.foodDiets = foodDiets;
    }

    public static class FoodDietsRequestDTO {
        private Long foodId;
        private float quantity;
        private FoodDietModel.Section section;

        // Getters and Setters

        public Long getFoodId() {
            return foodId;
        }

        public void setFoodId(Long foodId) {
            this.foodId = foodId;
        }

        public float getQuantity() {
            return quantity;
        }

        public void setQuantity(float quantity) {
            this.quantity = quantity;
        }

        public FoodDietModel.Section getSection() {
            return section;
        }

        public void setSection(FoodDietModel.Section section) {
            this.section = section;
        }
    }
}
