package DTO;

import entity.UsuarioEntity;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class UsuarioDTO {

    private Long usuarioId;

    @NotNull
    @Max ( 50 )
    private String nome;

    @NotNull
    @Size ( min = 5, max = 20 )
    private String login;

    @NotNull
    @Min ( 10 )
    @Email
    private String email;

    @NotNull
    @Size ( min = 4, max = 10 )
    private String senha;

    private LocalDate dataNascimento;

    public UsuarioDTO ( UsuarioEntity usuarioEntity ) {
        this.usuarioId = usuarioEntity.getUsuarioId();
        this.nome = usuarioEntity.getNome();
        this.login = usuarioEntity.getLogin();
        this.email = usuarioEntity.getEmail();
        this.senha = usuarioEntity.getSenha();
        this.dataNascimento = usuarioEntity.getDataNascimento();
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
