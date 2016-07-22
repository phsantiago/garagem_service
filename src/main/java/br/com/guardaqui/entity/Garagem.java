package br.com.guardaqui.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.guardaqui.dto.GaragemDto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the garagem database table.
 * 
 */
@Entity
@Table(name="garagem")
@NamedQuery(name="Garagem.findAll", query="SELECT g FROM Garagem g")
public class Garagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_garagem")
	private int idGaragem;

	private boolean deleted;

	@Lob
	private String descricao;

	@Column(name="dt_delete")
	private Date dtDelete;

	@Column(name="dt_registro")
	private Date dtRegistro;

	@Column(name="id_usuario_dono")
	private int idUsuarioDono;

	private BigDecimal latitude;

	private BigDecimal longitude;

	private String titulo;

	public Garagem() {
	}

	public int getIdGaragem() {
		return this.idGaragem;
	}

	public void setIdGaragem(int idGaragem) {
		this.idGaragem = idGaragem;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtDelete() {
		return this.dtDelete;
	}

	public void setDtDelete(Date dtDelete) {
		this.dtDelete = dtDelete;
	}

	public Date getDtRegistro() {
		return this.dtRegistro;
	}

	public void setDtRegistro(Date dtRegistro) {
		this.dtRegistro = dtRegistro;
	}

	public int getIdUsuarioDono() {
		return this.idUsuarioDono;
	}

	public void setIdUsuarioDono(int idUsuarioDono) {
		this.idUsuarioDono = idUsuarioDono;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	public Garagem(GaragemDto garagemDto){
		this.idGaragem = garagemDto.getId_garagem();
		this.dtRegistro = garagemDto.getDt_registro();
		this.dtDelete = garagemDto.getDt_delete();
		this.deleted = garagemDto.isDeleted();
		this.latitude = garagemDto.getLatitude();
		this.longitude = garagemDto.getLongitude();
		this.titulo = garagemDto.getTitulo();
		this.descricao = garagemDto.getDescricao();
		this.idUsuarioDono = garagemDto.getId_usuario_dono();
		
	}

}