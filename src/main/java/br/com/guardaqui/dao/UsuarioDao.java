package br.com.guardaqui.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.guardaqui.entity.Usuario;


@Singleton
public class UsuarioDao {
	@PersistenceContext
	EntityManager em;
	
	public List<Usuario> getAll() {
		Query query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		List<Usuario> lista = query.getResultList();
		return lista;
	}

	public Usuario getUsuarioEmailSenha(String email, String hashedPassword){
		String sql = "SELECT u.email, u.senha FROM Usuario u WHERE u.email = ? and u.senha = ?;";
		Query query = em.createQuery(sql,Usuario.class);
		query.setParameter(1, email);
		query.setParameter(2, hashedPassword);
		List<Usuario> usuario = query.getResultList();
		return usuario.isEmpty() ? null : usuario.get(0);
	}
	
	public void insertUsuario(Usuario usuario){
		em.persist(usuario);
	}
	
	public Usuario retornaUsuarioPorId(int idUsuario){
		return em.find(Usuario.class, idUsuario);
	}

	public Usuario getUsuarioEmail(String email){
		String sql = "Select u from Usuario u where u.email = ?1";
		Query query = em.createQuery(sql);
		query.setParameter(1, email);
		List<Usuario> usuario = query.getResultList();
		return usuario.isEmpty() ? null : usuario.get(0);
	}

	public void inserirNovoUsuario(Usuario usuario){
		em.persist(usuario);
	}
}
