package lgarcia.dev.nutrigest_api.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String gender;

    @Column
    private double targetWeight;

    @Column
    private String activity;

    @Column
    private String photoUrl;

    @Column
    private Timestamp birthDate;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "id_nutritionist")
    private NutritionistModel nutritionist;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressesModel> address = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserPhoneModel> phone = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MeasuresModel> measures = new ArrayList<>();

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public NutritionistModel getNutritionist() {
        return nutritionist;
    }

    public void setNutritionist(NutritionistModel nutritionist) {
        this.nutritionist = nutritionist;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<AddressesModel> getAddress() {
        return address;
    }

    public void setAddress(List<AddressesModel> address) {
        this.address = address;
    }

    public List<UserPhoneModel> getPhone() {
        return phone;
    }

    public void setPhone(List<UserPhoneModel> phone) {
        this.phone = phone;
    }

    public List<MeasuresModel> getMeasures() {
        return measures;
    }

    public void setMeasures(List<MeasuresModel> measures) {
        this.measures = measures;
    }
}
