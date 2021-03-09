package br.com.sgpr.teste.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="onibus")
public class Onibus {
	@Id
	@Column(name="num_placa")
	private String placa;
	@Column(name="num_assentos")
	private int assentos;
	@Column(name="tipo")
	private String tipo;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getNum_assentos() {
		return assentos;
	}
	public void setNum_assentos(int assentos) {
		this.assentos = assentos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
