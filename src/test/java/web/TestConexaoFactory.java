package web;

import persistencia.jdbc.ConexaoFactory;

public class TestConexaoFactory {

	
	public static void main(String[] args) {
		ConexaoFactory.getConnection();
		System.out.println("A conexão está OK");
	}
}
