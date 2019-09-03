package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import persistencia.entidade.Usuario;

/**
 * Acessando o banco
 * @author Rodrigo
 */
public class UsuarioDAO {

	
	private Connection con;
	
	public UsuarioDAO() {
		//Obtendo uma conexao com Banco
		con= ConexaoFactory.getConnection();
	}
	
	public void cadastrar(Usuario usuario){
		String sql = "insert into usuarios (login, nome, email, senha, telefone) values (?, ?, ?, ?, ? )";
		
		try (PreparedStatement preparador =  con.prepareStatement(sql)){
			//Criando objeto Statement 
			
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getNome());
			preparador.setString(3, usuario.getEmail());
			preparador.setString(4, usuario.getSenha());
			preparador.setString(5, usuario.getTelefone());
			//Executando no banco
			preparador.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void alterar(Usuario usuario){
		String sql = "update usuarios set login=?, nome=?, email=?, senha=?, telefone=? where id=?";
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setString(1, usuario.getLogin());
			preparador.setString(2, usuario.getNome());
			preparador.setString(3, usuario.getEmail());
			preparador.setString(4, usuario.getSenha());
			preparador.setString(5, usuario.getTelefone());
			preparador.setInt(6, usuario.getId());
			// executando o comando sql
			preparador.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void excluir(Usuario usuario){
		String sql = "delete from usuarios where id=?";
		
		try (PreparedStatement preparador =  con.prepareStatement(sql)){
			//Criando objeto Statement 
			preparador.setInt(1, usuario.getId());
			
			//Executando no banco
			preparador.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Salva com Insert ou Update
	 * Se o usuario tiver id então altera senao insere
	 * @param usuario
	 */
	public void salvar(Usuario usuario){
		if(usuario.getId()==null || usuario.getId()==0){
			cadastrar(usuario);
		}else{
			alterar(usuario);
		}
	}

	public List<Usuario> buscarTodos() {
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql = "Select * from usuarios";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			ResultSet resultado =preparador.executeQuery();
			Usuario usuario;
			while (resultado.next()){
				usuario =  new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setNome(resultado.getString("Nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setTelefone(resultado.getString("telefone"));
				// adicionando usuario na lista
				lista.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Usuario buscarPorId(int id) {
		
		Usuario usuario=null;
		String sql = "Select * from usuarios where id = ?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setInt(1, id);
			ResultSet resultado =preparador.executeQuery();
			if (resultado.next()){
				usuario =  new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setNome(resultado.getString("Nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setTelefone(resultado.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	public Usuario autenticar(Usuario usu) {
		Usuario usuario=null;
		String sql = "Select * from usuarios where login=? and senha=?";
		try (PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, usu.getLogin());
			preparador.setString(2, usu.getSenha());
			
			ResultSet resultado =preparador.executeQuery();
			if (resultado.next()){
				usuario =  new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setNome(resultado.getString("Nome"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setTelefone(resultado.getString("telefone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	
	

}