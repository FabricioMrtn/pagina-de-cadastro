package com.novolar.teste;

import com.novolar.dao.PersisteCliente;
import com.novolar.modelo.Cliente;

public class Teste {

	public static void main(String[] args) {
		PersisteCliente pc = new PersisteCliente();
		Cliente cc = new Cliente();
		cc.setNome("nome");
		cc.setSobrenome("sobrenome");
		cc.setCpf("12515251525");
		cc.setDataNascimento("02/02/0220");
		cc.setTelefoneCel("nulo");
		cc.setTelefoneFixo("nulo");
		cc.setEmail("email");
		cc.setRua("rua");
		cc.setBairro("bairro");
		cc.setCidade("cidade");
		cc.setEstado("es");
		
		pc.cadastra(cc);
		
		
		
	}

}
