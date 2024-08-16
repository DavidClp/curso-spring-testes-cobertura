package david.api_curso_testes_cobertura.resource;

import david.api_curso_testes_cobertura.domain.User;
import david.api_curso_testes_cobertura.domain.dto.UserDTO;
import david.api_curso_testes_cobertura.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        User userBean = service.findById(id);

        return ResponseEntity.ok().body(mapper.map(userBean, UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> userList = service.findAll();

        List<UserDTO> userDTOList = userList.stream().map(userBean -> mapper.map(userBean, UserDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(userDTOList);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO){
        User newUser = service.create(userDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
