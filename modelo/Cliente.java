package com.novolar.modelo;

import java.io.Serializable;

public class Cliente implements Serializable{
	static private final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String dataNascimento;
	private double credito;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String telefoneCel;
	private String telefoneFixo;
	private String email;
	
	//Get's
	public String getDataNascimento() {
		return dataNascimento.trim();
	}
	public String getNome() {
		return nome.trim();
	}
	public String getSobrenome() {
		return sobrenome.trim();
	}
	public String getCpf() {
		return cpf.trim();
	}
	public double getCredito() {
		return credito;
	}
	public int getId() {
		return id;
	}	
	public String getRua() {
		return rua.trim();
	}
	public String getBairro() {
		return bairro.trim();
	}
	public String getCidade() {
		return cidade.trim();
	}
	public String getEstado() {
		return estado.trim();
	}
	public String getTelefoneCel() {
		return telefoneCel;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public String getEmail() {
		return email.trim();
	}
	
	//Set's
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
	public void setRua(String rua) {
		this.rua = rua;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setTelefoneCel(String tel_celular) {
		this.telefoneCel = tel_celular;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String imprime() {
		return("\nId: " + this.id + "\nNome: " + this.nome + " " + this.sobrenome + 
				"\nCPF: " + this.cpf  + "\nData Nascimento: " + this.dataNascimento + 
				"\nCredito: " + this.credito + "\nTelefone Celular: " + this.telefoneCel +
				"\nTelefone Fixo: "+ this.telefoneFixo + "\nEmail: " + this.email +
				"\nRua: " + this.rua + "\nBairro: " + this.bairro + "\nCidade: " + this.cidade + 
				"\nEstado: " + this.estado);
	}
}
