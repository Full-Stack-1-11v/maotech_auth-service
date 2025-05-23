package cl.mao_tech.auth_service.repository;

import cl.mao_tech.auth_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByMail(String mail);
}
