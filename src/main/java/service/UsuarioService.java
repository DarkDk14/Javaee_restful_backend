package service;

import DTO.UsuarioDTO;
import repository.UsuarioRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarUsuario() {
      return usuarioRepository.listarUsuarios();
    }

    public UsuarioDTO pergarUsuarioPorID(Long idUsuario) {
        return usuarioRepository.pegarUsuarioPorID(idUsuario);
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        if (Objects.nonNull(usuarioDTO.getUsuarioId())) {
            throw new RuntimeException("Erro ao cadastrar usuario, informe o ID");
        }
        return usuarioRepository.criarUsuario(usuarioDTO);
    }

    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO) {
        if ( Objects.nonNull(usuarioDTO.getUsuarioId())) {
            throw new RuntimeException("Ao alterar mande um ID");
        }

        if (!usuarioDTO.getSenha().isEmpty()) {
            String senha = Base64.getEncoder().encodeToString(usuarioDTO.getSenha().getBytes());
            usuarioDTO.setSenha(senha);
        }

        return usuarioRepository.alterarUsuario(usuarioDTO);
    }

    public void excluirUsuario(Long idUsuario) {
        usuarioRepository.excluirUsuario(idUsuario);
    }

    public List<UsuarioDTO> listarAniversariantes() {
        return usuarioRepository.listarAniversariantes();
    }

    public List<UsuarioDTO> listarPrimeiraLetraDoNome(String inicial) {
        return usuarioRepository.listarPrimeiraLetraDoNome(inicial);
    }
}
