package lgarcia.dev.nutrigest_api.repositories;

import lgarcia.dev.nutrigest_api.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByEmail(String email);
}
