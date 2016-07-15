package br.com.guardaqui.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.guardaqui.dto.UsuarioDto;

import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String email;
	private int facebookId;
	private String nome;
	private String salt;
	private String senha;
	private String telefone;

	public Usuario() {
	}

	public Usuario(UsuarioDto usuarioDto) {
		this.idUsuario = usuarioDto.getIdUsuario();
		this.email = usuarioDto.getEmail();
		this.nome = usuarioDto.getNome();
		this.senha = usuarioDto.getSenha();
		this.telefone = usuarioDto.getTelefone();
	}

	@Id
	@Column(name="id_usuario")
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="facebook_id")
	public int getFacebookId() {
		return this.facebookId;
	}

	public void setFacebookId(int facebookId) {
		this.facebookId = facebookId;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}


	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}




}