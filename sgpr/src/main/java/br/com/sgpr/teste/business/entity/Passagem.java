package br.com.sgpr.teste.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passagem")
public class Passagem {
	@Id
	@Column(name="cod_validacao")
	private String codigo;
	@Column(name="viagem")
	private int viagem;
	@Column(name="data_validade")
	private String data;
	@Column(name="num_assento")
	private int assento;
	@Column(name="cpf_dono")
	private String passageiro;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getViagem() {
		return viagem;
	}
	public void setViagem(int viagem) {
		this.viagem = viagem;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getAssento() {
		return assento;
	}
	public void setAssento(int assento) {
		this.assento = assento;
	}
	public String getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(String passageiro) {
		this.passageiro = passageiro;
	}
	
}
