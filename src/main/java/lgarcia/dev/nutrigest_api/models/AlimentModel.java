package lgarcia.dev.nutrigest_api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lgarcia.dev.nutrigest_api.Views.Views;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "aliments")
public class AlimentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Basic.class)
    private Long id;

    @Column
    @JsonView(Views.Basic.class)
    private String name;

    @Column
    @JsonView(Views.Basic.class)
    private String description;

    @Column
    @JsonView(Views.Basic.class)
    private float kcals;

    @Column
    @JsonView(Views.Basic.class)
    private float proteins;

    @Column
    @JsonView(Views.Basic.class)
    private float carbs;

    @Column
    @JsonView(Views.Basic.class)
    private float fats;

    @Column
    @JsonView(Views.Basic.class)
    private float fiber;

    @Column
    @JsonView(Views.Basic.class)
    private String photo_url;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonView(Views.Detail.class)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "id_category")
    @JsonView(Views.Detail.class)
    private CategoryModel category;

    @ManyToOne
    @JoinColumn(name = "created_by")
    @JsonBackReference
    private NutritionistModel createdBy;

    @OneToMany(mappedBy = "aliment", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
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
