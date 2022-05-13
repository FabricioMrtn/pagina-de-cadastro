package com.novolar.servlet;

import java.io.IOException;
import javax.servlet.*;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.novolar.conexao.ConectaDB;
import com.novolar.dao.PersisteCliente;
import com.novolar.modelo.Cliente;

/**
 * Servlet implementation class Cadastro
 */
@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String nascimento = request.getParameter("nascimento");
		String tel_celular = request.getParameter("Tel_celular");
		String tel_fixo = request.getParameter("Tel_fixo");
		String email = request.getParameter("email");
		String rua = request.getParameter("rua");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");

		Cliente cc = new Cliente();
		cc.setNome(nome);
		cc.setSobrenome(sobrenome);
		cc.setCpf(cpf);
		cc.setDataNascimento(nascimento);
		cc.setTelefoneCel(tel_celular);
		cc.setTelefoneFixo(tel_fixo);
		cc.setEmail(email);
		cc.setRua(rua);
		cc.setBairro(bairro);
		cc.setCidade(cidade);
		cc.setEstado(estado);

		PrintWriter out = response.getWriter();
		out.println("<html><body> Cliente cadastrado com sucesso ! </body></html>");
		
	}
}
