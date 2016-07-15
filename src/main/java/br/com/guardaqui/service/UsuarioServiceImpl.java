package br.com.guardaqui.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import br.com.guardaqui.dao.UsuarioDao;
import br.com.guardaqui.dto.UsuarioDto;
import br.com.guardaqui.entity.Usuario;
import br.com.guardaqui.exception.BusinessException;
import br.com.guardaqui.util.CryptoUtils;
import br.com.guardaqui.util.StringUtils;

@Singleton
public class UsuarioServiceImpl {
	
	@EJB
	private UsuarioDao usuarioDao;
	
	public List<UsuarioDto> getAll(){
		List<Usuario> listaUsuarios = usuarioDao.getAll();
		List<UsuarioDto> listaUsuariosDto = new ArrayList<UsuarioDto>();
		
		for (Usuario u : listaUsuarios) listaUsuariosDto.add(new UsuarioDto(u));
		return listaUsuariosDto;
	}
	
	public UsuarioDto login(UsuarioDto usuarioDto) throws Exception{
		String email = usuarioDto.getEmail().toUpperCase();
		String senha = usuarioDto.getSenha();
		
		Usuario usuario = usuarioDao.getUsuarioEmail(email);
		if (usuario == null) throw new BusinessException(-1,"Usuário falhou na autenticação: " + email);
		
		String senhaCrip = CryptoUtils.hashSha512(senha, usuario.getSalt());		
		
		if(senhaCrip.equals(usuario.getSenha())) return new UsuarioDto(usuario);
			
		throw new BusinessException(-1,"Usuário falhou na autenticação: " + email);
	}
	
	public void registra(UsuarioDto usuarioDto) throws Exception{
		SecureRandom sr = new SecureRandom();
		Usuario usuario = new Usuario();
		
		usuarioDto.setEmail(usuarioDto.getEmail().toUpperCase());
		
		if(!StringUtils.isEmail(usuarioDto.getEmail()))
			throw new BusinessException(-1,"Email inválido");
		
		if(!StringUtils.validPassword(usuarioDto.getSenha())) 
			throw new BusinessException(-2,"A senha deve conter números e ao menos 8 caracteres");
		
		if(usuarioDao.getUsuarioEmail(usuarioDto.getEmail()) != null)
			throw new BusinessException(-3,"Email já cadastrado");		
		
		usuario = usuarioDto.getUsuarioEntity();
		usuario.setSalt(new BigInteger(130, sr).toString(32));
		
		String senhaCrip = CryptoUtils.hashSha512(usuario.getSenha(), usuario.getSalt());
		usuario.setSenha(senhaCrip);
		usuarioDao.inserirNovoUsuario(usuario);
	}

	public UsuarioDto atualizaUsuario(UsuarioDto usuarioDto) throws Exception{
		Usuario usuario = usuarioDao.getUsuarioEmail(usuarioDto.getEmail());
		
		usuario.setNome(usuarioDto.getNome());
		usuario.setTelefone(usuarioDto.getTelefone());
		
		if(usuarioDto.getSenha() != null){
			String senhaCrip = CryptoUtils.hashSha512(usuarioDto.getSenha(), usuario.getSalt());
			usuarioDto.setSenha(senhaCrip);
			
			if(!usuarioDto.getSenha().equals(usuario.getSenha()))
				throw new BusinessException(-1,"Senhas não coincidem");
			if(!StringUtils.validPassword(usuarioDto.getSenha2()))
				throw new BusinessException(-2,"Senha inválida");
			
			senhaCrip = CryptoUtils.hashSha512(usuarioDto.getSenha2(), usuario.getSalt());
			usuario.setSenha(senhaCrip);
		}
				
		return usuarioDto;
		
	}
	
	
	
	

	
}
