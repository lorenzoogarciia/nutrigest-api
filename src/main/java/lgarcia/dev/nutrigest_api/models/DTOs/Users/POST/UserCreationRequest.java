package lgarcia.dev.nutrigest_api.models.DTOs.Users.POST;

import lgarcia.dev.nutrigest_api.models.UserModel;

public class UserCreationRequest {
    private UserModel user;
    private String password;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
