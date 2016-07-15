package br.com.guardaqui.service;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import br.com.guardaqui.dao.GaragemDao;
import br.com.guardaqui.dto.GaragemDto;

@Singleton
public class GaragemServiceImpl {

	@EJB
	private GaragemDao garagemDao;
	
	public List<GaragemDto> getAll(){
		BigDecimal lat = new BigDecimal(0.8);
		BigDecimal lon = new BigDecimal(0.8);
		List<GaragemDto> garagem = garagemDao.getGaragemRaio(lat, lon, 2);
		return garagem;
	}
}
