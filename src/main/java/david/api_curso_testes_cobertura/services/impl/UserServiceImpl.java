package david.api_curso_testes_cobertura.services.impl;

import david.api_curso_testes_cobertura.domain.User;
import david.api_curso_testes_cobertura.domain.dto.UserDTO;
import david.api_curso_testes_cobertura.repositories.UserRepository;
import david.api_curso_testes_cobertura.services.UserService;
import david.api_curso_testes_cobertura.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public User findById(Integer id) {
        Optional<User> userBean = repository.findById(id);

        return userBean.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);

        return repository.save(user);
    }
}
