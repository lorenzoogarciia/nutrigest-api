package lgarcia.dev.nutrigest_api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aliments")
public class AlimentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private float kcals;

    @Column
    private float proteins;

    @Column
    private float carbs;

    @Column
    private float fats;

    @Column
    private float fiber;

    @Column
    private String photo_url;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryModel category;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private NutritionistModel createdBy;

    @OneToMany(mappedBy = "aliment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodDietModel> foodDiet = new ArrayList<>();

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

    public float getKcals() {
        return kcals;
    }

    public void setKcals(float kcals) {
        this.kcals = kcals;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public float getCarbs() {
        return carbs;
    }

    public void setCarbs(float carbs) {
        this.carbs = carbs;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getFiber() {
        return fiber;
    }

    public void setFiber(float fiber) {
        this.fiber = fiber;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public NutritionistModel getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(NutritionistModel createdBy) {
        this.createdBy = createdBy;
    }
}
