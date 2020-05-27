import java.util.ArrayList;

public class Autor{
	private String nome, cpf, telefone, email, acesso, senha;
	ArrayList<Projeto> projetos = new ArrayList<Projeto>();
	int in = 0;
	
	// Construtores
	public Autor(){
		nome = null;
		cpf = null;
		telefone = null;
		email = null;
		acesso = null;
		senha = null;
	}
	public Autor(String nome, String cpf, String telefone, String email, String acesso, String senha){
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.acesso = acesso;
		this.senha = senha;
	}

	// Métodos SET
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setCPF(String cpf){
		this.cpf = cpf;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setAcesso(String acesso){
		this.acesso = acesso;
	}
	public void setSenha(String senha){
		this.senha = senha;
	}

	// Métodos GET
	public String getNome(){
		return nome;
	}
	public String getCPF(){
		return cpf;
	}
	public String getTelefone(){
		return telefone;
	}
	public String getEmail(){
		return email;
	}
	public String getAcesso(){
		return acesso;
	}
	public String getSenha(){
		return senha;
	}
	public ArrayList<Projeto> getProjetos(){
		return projetos;
	}
	public Projeto getProjeto(int codigo){
		for(int i = 0; i < projetos.size(); i++){
			if(projetos.get(i).getCodigo() == codigo){
				return projetos.get(i);
			}
		}
		return null;
	}

	// Demais métodos
	public void adProjeto(Projeto projeto){
		projetos.add(projeto);
	}
	public void rmProjeto(int cod){
		for(int i = 0; i < projetos.size(); i++){
			if(projetos.get(i).getCodigo() == cod){
				projetos.remove(i);
			}
		}
	}

}