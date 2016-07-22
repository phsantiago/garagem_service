package br.com.guardaqui.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import br.com.guardaqui.dao.GaragemDao;
import br.com.guardaqui.dto.GaragemDto;
import br.com.guardaqui.entity.Garagem;
import br.com.guardaqui.exception.BusinessException;

@Singleton
public class GaragemServiceImpl {

	@EJB
	private GaragemDao garagemDao;
	
	public List<GaragemDto> getAll(){
		List<Garagem> listaGaragem = garagemDao.getAll();
		List<GaragemDto> listaGaragemDto = new ArrayList<GaragemDto>();
		
		for (Garagem g : listaGaragem) listaGaragemDto.add(new GaragemDto(g));
		return listaGaragemDto;
	}
	
	public List<GaragemDto> getGaragensRaio(String latStr, String lonStr, double dist) throws BusinessException{
		if(dist > 10) throw new BusinessException(-1, "Distância máxima: 10km");
		BigDecimal lat = new BigDecimal(latStr);
		BigDecimal lon = new BigDecimal(lonStr);
		List<Object[]> lista = garagemDao.getGaragemRaio(lat, lon, dist);
		List<GaragemDto> garagem = new ArrayList<GaragemDto>();
		for(Object[] objeto:lista){
			GaragemDto garagemDto = new GaragemDto(objeto);
			garagem.add(garagemDto);
		}
		return garagem;
	}
	
	public void registra(GaragemDto garagemDto) throws Exception{
		Garagem garagem = new Garagem(garagemDto);
		
		
		garagemDao.inserirGaragem(garagem);
	}
}
