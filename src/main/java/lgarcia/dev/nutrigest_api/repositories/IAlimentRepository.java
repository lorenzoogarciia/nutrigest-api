package lgarcia.dev.nutrigest_api.repositories;

import lgarcia.dev.nutrigest_api.models.AlimentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlimentRepository extends JpaRepository<AlimentModel, Long> {
}
