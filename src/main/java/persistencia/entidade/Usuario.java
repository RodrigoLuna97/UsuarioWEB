package persistencia.entidade;

//model
//domain
public class Usuario {
	
	private Integer id;
	private String login;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", nome=" + nome + ", email=" + email + ", senha=" + senha
				+ ", telefone=" + telefone + "]";
	}

}
