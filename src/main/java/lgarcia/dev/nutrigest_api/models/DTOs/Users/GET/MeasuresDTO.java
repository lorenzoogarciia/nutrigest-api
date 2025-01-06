package lgarcia.dev.nutrigest_api.models.DTOs.Users.GET;

import java.sql.Timestamp;

public class MeasuresDTO {
    private double weight;
    private double height;
    private Timestamp createdAt;

    // Getters and Setters

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
