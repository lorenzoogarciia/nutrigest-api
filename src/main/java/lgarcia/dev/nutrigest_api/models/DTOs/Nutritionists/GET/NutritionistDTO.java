package lgarcia.dev.nutrigest_api.models.DTOs.Nutritionists.GET;

import lgarcia.dev.nutrigest_api.models.NutritionistLicenseModel;

import java.sql.Timestamp;

public class NutritionistDTO {
    public long id;
    public String name;
    public String lastName;
    public String email;
    public String phone;
    public String address;
    public String cif;
    public Timestamp createdAt;
    public NutritionistLicenseModel license;

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public NutritionistLicenseModel getLicense() {
        return license;
    }

    public void setLicense(NutritionistLicenseModel license) {
        this.license = license;
    }
}
