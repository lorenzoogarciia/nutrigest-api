package lgarcia.dev.nutrigest_api.models.DTOs.Auth;

public class AuthResponseDTO {
    private String role;
    private long userId;
    private String accessToken;
    private String refreshToken;

    public AuthResponseDTO(String role, long userId, String accessToken, String refreshToken) {
        this.role = role;
        this.userId = userId;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public AuthResponseDTO(String role, long userId) {
        this.role = role;
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
