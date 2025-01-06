package lgarcia.dev.nutrigest_api.repositories;

import lgarcia.dev.nutrigest_api.models.FoodDietModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodDietRepository extends JpaRepository<FoodDietModel, Long> {
}
