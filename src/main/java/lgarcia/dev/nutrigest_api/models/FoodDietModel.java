package lgarcia.dev.nutrigest_api.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "food_diet")
public class FoodDietModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="diet_id", nullable=false)
    @JsonBackReference
    private DietModel diet;

    @ManyToOne
    @JoinColumn(name="food_id", nullable=false)
    @JsonManagedReference
    private AlimentModel aliment;

    @Column(nullable = false)
    private float quantity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Section section;

    public enum Section {
        DESAYUNO, ALMUERZO, MERIENDA, CENA, PICOTEO
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DietModel getDiet() {
        return diet;
    }

    public void setDiet(DietModel diet) {
        this.diet = diet;
    }

    public AlimentModel getAliment() {
        return aliment;
    }

    public void setAliment(AlimentModel aliment) {
        this.aliment = aliment;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
