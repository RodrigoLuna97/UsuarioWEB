package web;

import persistencia.entidade.Usuario;
import persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario =  new Usuario();
		usuario.setLogin("rr");
		usuario.setNome("RO");
		usuario.setEmail("email@123.com");
		usuario.setSenha("abc");
		usuario.setTelefone("1231244");
		usuarioDAO.cadastrar(usuario );
		System.out.println("Salvo com sucesso!");
	}
}
