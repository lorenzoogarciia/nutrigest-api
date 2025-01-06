package lgarcia.dev.nutrigest_api.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nutritionists")
public class NutritionistModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String cif;

    @Column
    private String phone;

    @Column
    private String address;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<AlimentModel> aliments = new ArrayList<>();

    @OneToOne(mappedBy = "nutritionist", orphanRemoval = false)
    @Nullable
    private NutritionistLicenseModel license;


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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<AlimentModel> getAliments() {
        return aliments;
    }

    public void setAliments(List<AlimentModel> aliments) {
        this.aliments = aliments;
    }

    public NutritionistLicenseModel getLicense() {
        return license;
    }

    public void setLicense(NutritionistLicenseModel license) {
        this.license = license;
    }
}
