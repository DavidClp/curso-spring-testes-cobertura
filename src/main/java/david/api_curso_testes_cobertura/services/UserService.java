package david.api_curso_testes_cobertura.services;

import david.api_curso_testes_cobertura.domain.User;
import david.api_curso_testes_cobertura.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO user);
}


