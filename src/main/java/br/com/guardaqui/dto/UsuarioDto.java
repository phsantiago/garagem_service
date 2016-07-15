package br.com.guardaqui.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.guardaqui.entity.Garagem;
import br.com.guardaqui.entity.Usuario;

public class UsuarioDto extends RetornoDto {
	private int idUsuario;
	private String email;
	private String nome;
	private int facebookId;
	private String salt;
	private String senha;
	private String senha2;
	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	private String telefone;
	private List<Garagem> garagems;
	
	public UsuarioDto(){
	}
	
	public UsuarioDto(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.email = usuario.getEmail();
		this.nome = usuario.getNome();
		this.senha = "";
		this.telefone = usuario.getTelefone();
		//this.garagems = usuario.getGaragems();
	}
	
	@JsonIgnore
	public Usuario getUsuarioEntity(){
		Usuario usuario = new Usuario();
		usuario.setEmail(this.email);
		usuario.setFacebookId(this.facebookId);
		usuario.setIdUsuario(this.idUsuario);
		usuario.setNome(this.nome);
		usuario.setSalt(this.salt);
		usuario.setSenha(this.senha);
		usuario.setTelefone(this.telefone);
		return usuario;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public List<Garagem> getGaragems() {
		return garagems;
	}
	public void setGaragems(List<Garagem> garagems) {
		this.garagems = garagems;
	}

	public int getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(int facebookId) {
		this.facebookId = facebookId;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "UsuarioDto [idUsuario=" + idUsuario + ", email=" + email + ", nome=" + nome + ", facebookId="
				+ facebookId + ", telefone=" + telefone + ", garagems=" + garagems + "]";
	}
	
	
}
