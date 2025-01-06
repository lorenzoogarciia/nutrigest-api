package lgarcia.dev.nutrigest_api.repositories;

import lgarcia.dev.nutrigest_api.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryModel, Long> {
}
