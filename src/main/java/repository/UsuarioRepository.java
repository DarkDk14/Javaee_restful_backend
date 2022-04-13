package repository;

import DAO.GenericDAO;
import DTO.UsuarioDTO;
import entity.UsuarioEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<UsuarioEntity, Long> {

    public List<UsuarioDTO> listarUsuarios()  {
        List<UsuarioEntity> usuarios = this.listAll();
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public UsuarioDTO pegarUsuarioPorID(Long id) {
            return new UsuarioDTO(this.findById(id));
    }

    @Transactional
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.save(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
        this.update(usuarioEntity);
        return new UsuarioDTO(usuarioEntity);
    }

    @Transactional
    public void excluirUsuario(Long idUsuario) {
        this.delete(idUsuario);
    }

    public List<UsuarioDTO> listarAniversariantes () {
        Query nativeQuery = this.createNativeQuery("SELECT * FROM tab_usuarios WHERE month (data_de_nascimento) = ?");
        nativeQuery.setParameter(1, LocalDate.now().getMonthValue());
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public List<UsuarioDTO> listarPrimeiraLetraDoNome(String inicial) {
        Query nativeQuery = this.createNativeQuery("SELECT * FROM tab_usuarios WHERE nome LIKE ?");
        nativeQuery.setParameter(1, inicial + "%");
        List<UsuarioEntity> resultList = nativeQuery.getResultList();
        return resultList.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

}
