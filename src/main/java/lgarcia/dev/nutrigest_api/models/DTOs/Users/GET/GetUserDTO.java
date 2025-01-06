package lgarcia.dev.nutrigest_api.models.DTOs.Users.GET;

import java.sql.Timestamp;
import java.util.List;

public class GetUserDTO {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private String gender;
    private Timestamp birthDate;
    private double targetWeight;
    private String activity;
    private String photoUrl;
    private Timestamp createdAt;
    private long nutritionistId;
    private List<String> phone;
    private List<String> address;
    private List<MeasuresDTO> measures;

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public double getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(double targetWeight) {
        this.targetWeight = targetWeight;
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

    public long getNutritionistId() {
        return nutritionistId;
    }

    public void setNutritionistId(long nutritionistId) {
        this.nutritionistId = nutritionistId;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public List<MeasuresDTO> getMeasures() {
        return measures;
    }

    public void setMeasures(List<MeasuresDTO> measures) {
        this.measures = measures;
    }
}
