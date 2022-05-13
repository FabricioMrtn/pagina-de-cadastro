package com.novolar.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.novolar.conexao.ConectaDB;
import com.novolar.modelo.Cliente;

public class PersisteCliente {
	public void cadastra(Cliente cliente) {
		String sql = "INSERT INTO clientes(NOME, SOBRENOME, CPF, DATA_NASCIMENTO, TEL_CELULAR, TEL_FIXO, EMAIL, RUA, BAIRRO, CIDADE, ESTADO) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		JdbcPreparedStatement jps = null;

		try {
			conn = ConectaDB.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			jps.setString(1, cliente.getNome());
			jps.setString(2, cliente.getSobrenome());
			jps.setString(3, cliente.getCpf());
			jps.setString(4, cliente.getDataNascimento());
			jps.setString(5, cliente.getTelefoneCel());
			jps.setString(6, cliente.getTelefoneFixo());
			jps.setString(7, cliente.getEmail());
			jps.setString(8, cliente.getRua());
			jps.setString(9, cliente.getBairro());
			jps.setString(10, cliente.getCidade());
			jps.setString(11, cliente.getEstado());

			jps.execute();
			System.out.println("Cliente cadastrado !");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (jps != null) {
					jps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void deleta(Cliente cliente) {
		String sql = "DELETE FROM clientes WHERE ID = ?";

		Connection conn = null;
		JdbcPreparedStatement jps = null;

		try {
			conn = ConectaDB.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			jps.setInt(1, cliente.getId());
			jps.execute();
			System.out.println("Cliente deletado !");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (jps != null) {
					jps.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void atualiza(Cliente cliente) {
		String sql = "UPDATE clientes SET NOME = ?, SOBRENOME = ?, CPF = ?, DATA_NASCIMENTO = ?, CREDITO = ?,"
				+ " TEL_CELULAR = ?, TEL_FIXO = ?, EMAIL = ?, RUA = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ? WHERE ID = ?";

		Connection conn = null;
		JdbcPreparedStatement jps = null;

		try {
			conn = ConectaDB.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			jps.setString(1, cliente.getNome());
			jps.setString(2, cliente.getSobrenome());
			jps.setString(3, cliente.getCpf());
			jps.setString(4, cliente.getDataNascimento());
			jps.setDouble(5, cliente.getCredito());
			jps.setString(6, cliente.getTelefoneCel());
			jps.setString(7, cliente.getTelefoneFixo());
			jps.setString(8,cliente.getEmail());
			jps.setString(9, cliente.getRua());
			jps.setString(10, cliente.getBairro());
			jps.setString(11, cliente.getCidade());
			jps.setString(12, cliente.getEstado());
			jps.setInt(13, cliente.getId());
			jps.execute();
			
			System.out.println("Cadastro atualizado");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (jps != null) {
					jps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public List<Cliente> busca(){
		String sql = "SELECT * FROM clientes";
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection conn = null;
		JdbcPreparedStatement jps = null;
		ResultSet rs = null;
		
		try {
			conn = ConectaDB.createConnectionToMySQL();
			jps = (JdbcPreparedStatement) conn.prepareStatement(sql);
			rs = jps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setDataNascimento(rs.getString("data_nascimento"));
				cliente.setCredito(rs.getDouble("credito"));
				cliente.setTelefoneCel(rs.getString("tel_celular"));
				cliente.setTelefoneFixo(rs.getString("tel_fixo"));
				cliente.setEmail(rs.getString("email"));
				cliente.setRua(rs.getString("rua"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setCidade(rs.getString("cidade"));
				cliente.setEstado(rs.getString("estado"));
				
				clientes.add(cliente);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
					if (rs != null) {
						rs.close();
					}
					if (jps != null) {
						jps.close();
					}
					if (conn != null) {
						conn.close();
					}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return clientes;
	}
}
