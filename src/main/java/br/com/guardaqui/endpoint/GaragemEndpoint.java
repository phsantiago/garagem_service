package br.com.guardaqui.endpoint;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.guardaqui.dto.GaragemDto;
import br.com.guardaqui.service.GaragemServiceImpl;

@Path("/garagem")
@Produces("application/json; charset=UTF-8")
public class GaragemEndpoint {

	@EJB
	private GaragemServiceImpl garagemService;
	
	@GET
	public Object getGaragemRaio(){
		List<GaragemDto> lista = garagemService.getAll();
		return lista;
	}
	
}
