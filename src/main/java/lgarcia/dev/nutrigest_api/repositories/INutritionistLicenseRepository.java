package lgarcia.dev.nutrigest_api.repositories;

import lgarcia.dev.nutrigest_api.models.NutritionistLicenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INutritionistLicenseRepository extends JpaRepository<NutritionistLicenseModel, Long> {
}
