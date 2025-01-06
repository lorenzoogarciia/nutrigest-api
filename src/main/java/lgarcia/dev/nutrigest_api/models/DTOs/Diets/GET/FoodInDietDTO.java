package lgarcia.dev.nutrigest_api.models.DTOs.Diets.GET;

public class FoodInDietDTO {
    private Long alimentId;
    private String alimentName;
    private float quantity;
    private String Section;

    // Getters and Setters

    public Long getAlimentId() {
        return alimentId;
    }

    public void setAlimentId(Long alimentId) {
        this.alimentId = alimentId;
    }

    public String getAlimentName() {
        return alimentName;
    }

    public void setAlimentName(String alimentName) {
        this.alimentName = alimentName;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }
}
