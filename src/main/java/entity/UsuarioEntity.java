package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table ( name = "tb_usuario" )
public class UsuarioEntity {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long usuarioId;

    @Column ( nullable = false, length = 50 )
    private String nome;

    @Column ( nullable = false, unique = true )
    private String login;

    @Column ( nullable = false )
    private String email;

    @Column ( nullable = false )
    private String senha;

    @Column ( name = "data_de_nascimento" )
    private LocalDate dataNascimento;

    public void UsuarioEntity () {

    }
}
