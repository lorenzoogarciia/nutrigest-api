package lgarcia.dev.nutrigest_api.repositories;

import lgarcia.dev.nutrigest_api.models.NutritionistModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INutritionistRepository extends JpaRepository<NutritionistModel, Long> {
}
