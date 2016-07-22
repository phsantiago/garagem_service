package br.com.guardaqui.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.guardaqui.dto.GaragemDto;
import br.com.guardaqui.entity.Garagem;

@Singleton
public class GaragemDao {
	@PersistenceContext
	EntityManager em;
	
	public List<Garagem> getAll(){
	Query query = em.createQuery("SELECT g FROM Garagem g", Garagem.class);
	List<Garagem> lista = query.getResultList();
	return lista;
	}
	
	public List<Object[]> getGaragemRaio(BigDecimal lat, BigDecimal lon, double dist){
		String sql = "SELECT *, 111.1111 * SQRT(POW(latitude - ?,2) + POW(longitude - ?,2)) AS distancia"
				+ " FROM garagem WHERE (111.1111 * SQRT(POW(latitude - ?,2) + POW"
				+ " (longitude - ?,2))) < ?"
				+ " ORDER BY distancia;";
		
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, lat);
		query.setParameter(2, lon);
		query.setParameter(3, lat);
		query.setParameter(4, lon);
		query.setParameter(5, dist);
		
		List<Object[]> lista = query.getResultList();
		return lista;
				
	}
	 public void inserirGaragem(Garagem garagem){
		 em.persist(garagem);
	 }

}
