package br.com.guardaqui.endpoint;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.guardaqui.dto.RetornoDto;
import br.com.guardaqui.dto.UsuarioDto;
import br.com.guardaqui.exception.BusinessException;
import br.com.guardaqui.service.UsuarioServiceImpl;


@Path("/usuario")
@Produces("application/json; charset=UTF-8")
public class UsuarioEndpoint {

	@Context private HttpServletRequest request;
	@Context private HttpServletResponse response;
	
	@EJB
	private UsuarioServiceImpl usuarioService;
	
	private static final Logger log = Logger.getLogger(UsuarioEndpoint.class.getName());
	
	@GET
	public Object getAllUsuarios(){
		List<UsuarioDto> lista = usuarioService.getAll();
		return lista;
	}
	
	@POST
	@Path("/login")
	public Object login(UsuarioDto usuarioDto){
		try{
			UsuarioDto usuarioSessao = usuarioService.login(usuarioDto);
			request.setAttribute("usuario", usuarioSessao);
			return usuarioSessao;
			
		}catch (BusinessException e){
			log.log(Level.INFO, e.getMessage());
			return new RetornoDto(e.getRetCode(),e.getMessage());
			
		}catch (Exception e){
			log.log(Level.SEVERE, "erro inesperado: ",e);
			return new RetornoDto(500,"Erro inesperado");
		}
	}
	
	@POST
	public Object insereUsuario(UsuarioDto usuarioDto){
		try {
			usuarioService.registra(usuarioDto);
			return new RetornoDto(0,"Usuário inserido com sucesso");
			
		}catch (BusinessException e){
			log.log(Level.INFO, usuarioDto.toString(), e.getMessage());
			return new RetornoDto(e.getRetCode(),e.getMessage());
			
		}catch (Exception e){
			log.log(Level.SEVERE, usuarioDto.toString(), e);
			return new RetornoDto(500,"Erro inesperado");
		}
		
	}
	
	@PUT
	public Object alteraUsuario(UsuarioDto usuarioDto){
		try{
			UsuarioDto sessao = (UsuarioDto)request.getSession().getAttribute("usuario");
			usuarioDto.setEmail(sessao.getEmail());
			sessao = usuarioService.atualizaUsuario(usuarioDto);
			request.getSession().setAttribute("usuario", sessao);
			return Response.ok().build();
			
		}catch (BusinessException e){
			log.log(Level.INFO, usuarioDto.toString(), e.getMessage());
			return new RetornoDto(e.getRetCode(),e.getMessage());
			
		}catch (Exception e){
			log.log(Level.SEVERE, usuarioDto.toString(), e);
			return new RetornoDto(500,"Erro inesperado");
		}
	}
	
	@GET
    @Path("/me")
    public Object me(){
        UsuarioDto usuarioDto = (UsuarioDto) request.getSession().getAttribute("usuario");
        if (usuarioDto != null) {
            return usuarioDto;
        }else{
        	return new RetornoDto(500,"Usuário não logado");
        }
    }
	
}
