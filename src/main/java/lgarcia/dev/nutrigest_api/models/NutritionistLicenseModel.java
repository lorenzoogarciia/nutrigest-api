package lgarcia.dev.nutrigest_api.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "nutritionist_licenses")
public class NutritionistLicenseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "nutritionist_id", nullable = false, unique = true)
    private NutritionistModel nutritionist;

    @Column
    private boolean isActive;

    @Column
    private Timestamp activeDate;

    @Column
    private long price;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    // Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NutritionistModel getNutritionist() {
        return nutritionist;
    }

    public void setNutritionist(NutritionistModel nutritionist) {
        this.nutritionist = nutritionist;
    }

    public Timestamp getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Timestamp activeDate) {
        this.activeDate = activeDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
