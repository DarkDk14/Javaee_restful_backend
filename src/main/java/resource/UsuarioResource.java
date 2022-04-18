package resource;

import DTO.UsuarioDTO;
import service.UsuarioService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public Response listarUsuario() {
        List<UsuarioDTO> listarUsuarios = usuarioService.listarUsuario();
        return Response.status(Response.Status.OK).entity(listarUsuarios).build();
    }

    @GET
    @Path("/{idUsuario}")
    public Response pegarUsuarioPorID(@PathParam("idUsuario") Long idUsuario) {
        return  Response.status(Response.Status.OK).entity(usuarioService.pergarUsuarioPorID(idUsuario)).build();
    }

    @POST
    public Response criarUsaurio(UsuarioDTO usuarioDTO) {
        return Response.status(Response.Status.CREATED).entity(usuarioService.criarUsuario(usuarioDTO)).build();
    }

    @PUT
    public Response alterarUsuario(@Valid UsuarioDTO usuarioDTO) {
        return Response.status(Response.Status.OK).entity(usuarioService.alterarUsuario(usuarioDTO)).build();
    }

    @DELETE
    @Path("/{idUsuario}")
    public Response excluirUsuario(@PathParam("idUsuario") Long idUsuario) {
        usuarioService.excluirUsuario(idUsuario);
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @GET
    @Path("/aniversariantes")
    public Response pegarMes() {
        return Response.status(Response.Status.ACCEPTED).entity(usuarioService.listarAniversariantes()).build();
    }

    @GET
    @Path("/inicial/{inicial}")
    public Response listarInicialDoNome(@PathParam("inicial") String inicial) {
        return Response.status(Response.Status.OK).entity(usuarioService.listarPrimeiraLetraDoNome(inicial)).build();
    }
}
