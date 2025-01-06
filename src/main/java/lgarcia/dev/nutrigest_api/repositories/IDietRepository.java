package lgarcia.dev.nutrigest_api.repositories;

import lgarcia.dev.nutrigest_api.models.DietModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDietRepository extends JpaRepository<DietModel, Long> {
}
