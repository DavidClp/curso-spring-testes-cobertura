package david.api_curso_testes_cobertura.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;
    @Column
    private String email;
    @Column
    private String password;

    public User(Integer id) {
        this.id = id;
    }
}
