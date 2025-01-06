package lgarcia.dev.nutrigest_api.services;

import lgarcia.dev.nutrigest_api.repositories.INutritionistLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutritionistLicenseService {

    @Autowired
    private INutritionistLicenseRepository nutritionistLicenseRepository;
}
