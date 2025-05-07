package lgarcia.dev.nutrigest_api.models.DTOs.Nutritionists.GET;

import lgarcia.dev.nutrigest_api.models.UserModel;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public class StatisticsDTO {
    int totalClients;
    int expiredLicenses;
    int newClients;

    public int getTotalClients() {
        return totalClients;
    }

    public int getExpiredLicenses() {
        return expiredLicenses;
    }

    public int getNewClients() {
        return newClients;
    }

    public void setTotalClients(int totalClients) {
        this.totalClients = totalClients;
    }

    public void setExpiredLicenses(int expiredLicenses) {
        this.expiredLicenses = expiredLicenses;
    }

    public void setNewClients(int newClients) {
        this.newClients = newClients;
    }
}
