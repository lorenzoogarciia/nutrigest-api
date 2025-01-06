package lgarcia.dev.nutrigest_api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_phone")
public class UserPhoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
