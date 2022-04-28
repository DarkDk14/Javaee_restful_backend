package entity;

import DTO.UsuarioDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table ( name = "tb_usuario" )
public class UsuarioEntity {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long usuarioId;

    @Column ( nullable = false)
    private String nome;

    @Column ( nullable = false, unique = true )
    private String login;

    @Column ( nullable = false )
    private String email;

    @Column ( nullable = false )
    private String senha;

    @Column ( name = "data_de_nascimento" )
    private LocalDate dataNascimento;

    public UsuarioEntity () {}

    public UsuarioEntity (UsuarioDTO usuarioDTO) {
        this.usuarioId = usuarioDTO.getUsuarioId();
        this.nome = usuarioDTO.getNome();
        this.login = usuarioDTO.getLogin();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.dataNascimento = LocalDate.from(usuarioDTO.getDataNascimento());
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
