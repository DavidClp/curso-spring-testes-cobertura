package david.api_curso_testes_cobertura.repositories;

import david.api_curso_testes_cobertura.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
