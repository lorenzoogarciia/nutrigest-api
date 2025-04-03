package lgarcia.dev.nutrigest_api.repositories;

import lgarcia.dev.nutrigest_api.models.AlimentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlimentRepository extends JpaRepository<AlimentModel, Long> {
    List<AlimentModel> findByCreatedBy_Id(Long nutritionistId);
}
