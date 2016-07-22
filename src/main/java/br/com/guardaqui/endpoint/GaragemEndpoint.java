package br.com.guardaqui.endpoint;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.junit.runners.Parameterized.Parameters;

import br.com.guardaqui.dto.GaragemDto;
import br.com.guardaqui.dto.RetornoDto;
import br.com.guardaqui.exception.BusinessException;
import br.com.guardaqui.service.GaragemServiceImpl;

@Path("/garagem")
@Produces("application/json; charset=UTF-8")
public class GaragemEndpoint {

	@EJB
	private GaragemServiceImpl garagemService;
	private static final Logger log = Logger.getLogger(GaragemEndpoint.class.getName());
	
	
	@GET
	public Object getAllGaragens(){
			List<GaragemDto> lista = garagemService.getAll();
			return lista;
	}
	
	
	@GET
	@Path("{lat}/{lon}/{dist}")
	public Object getGaragemRaio(@PathParam("lat") String lat, @PathParam("lon") String lon, @PathParam("dist")double dist){
		try{
			List<GaragemDto> lista = garagemService.getGaragensRaio(lat, lon, dist);
			return lista;
			
		}catch (BusinessException e){
			log.log(Level.INFO, e.getMessage());
			return new RetornoDto(e.getRetCode(),e.getMessage());
			
		}catch (Exception e){
			log.log(Level.SEVERE, "erro inesperado: ",e);
			return new RetornoDto(500,"Erro inesperado");
		}
	}
	
	@GET
	@Path("/registrar")
	public Object registraGaragem(GaragemDto garagemDto){
   try{
	   	garagemService.registra(garagemDto);
		return new RetornoDto(0,"Garagem inserida com sucesso");
   }catch (BusinessException e){
		log.log(Level.INFO, e.getMessage());
		return new RetornoDto(e.getRetCode(),e.getMessage());
		
	}catch (Exception e){
		log.log(Level.SEVERE, "erro inesperado: ",e);
		return new RetornoDto(500,"Erro inesperado");
	}
	}
}
