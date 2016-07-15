package br.com.guardaqui.dto;

import java.math.BigDecimal;
import java.util.Date;

import br.com.guardaqui.entity.Garagem;

public class GaragemDto {
	private int id_garagem;
	private Date dt_registro;
	private Date dt_delete;
	private boolean deleted;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String titulo;
	private String descricao;
	private int id_usuario_dono;
	
	public GaragemDto(){
	}
	public GaragemDto(Garagem garagem){
		this.id_garagem = garagem.getIdGaragem();
		this.dt_registro = garagem.getDtRegistro();
		this.dt_delete = garagem.getDtDelete();
		this.deleted = garagem.getDeleted();
		this.latitude = garagem.getLatitude();
		this.longitude = garagem.getLongitude();
		this.titulo = garagem.getTitulo();
		this.descricao = garagem.getDescricao();
		this.id_usuario_dono = garagem.getIdUsuarioDono();
	}
	
	public int getId_garagem() {
		return id_garagem;
	}
	public void setId_garagem(int id_garagem) {
		this.id_garagem = id_garagem;
	}
	public Date getDt_registro() {
		return dt_registro;
	}
	public void setDt_registro(Date dt_registro) {
		this.dt_registro = dt_registro;
	}
	public Date getDt_delete() {
		return dt_delete;
	}
	public void setDt_delete(Date dt_delete) {
		this.dt_delete = dt_delete;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId_usuario_dono() {
		return id_usuario_dono;
	}
	public void setId_usuario_dono(int id_usuario_dono) {
		this.id_usuario_dono = id_usuario_dono;
	}
	
	
}
