import java.util.ArrayList;

public class Editor{
	private String nome, cpf, telefone, email, acesso, senha;
	private boolean ativa;
	ArrayList<Projeto> recomendados = new ArrayList<Projeto>();

	// Construtores
	public Editor(){
		nome = null;
		cpf = null;
		telefone = null;
		email = null;
		acesso = null;
		senha = null;
		ativa = false;
	}
	public Editor(String nome, String cpf, String telefone, String email, String acesso, String senha){
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
	public void setAtiva(boolean ativa){
		this.ativa = ativa;
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
	public boolean getAtiva(){
		return ativa;
	}
	public ArrayList<Projeto> getRecomendados(){
		return recomendados;
	}
	public Projeto getRecomendado(int cod){
		for(int i = 0; i < recomendados.size(); i++){
			if(recomendados.get(i).getCodigo() == cod){
				return recomendados.get(i);
			}
		}
		return null;
	}

	// Demais métodos
	public void adRecomendado(Projeto projeto){
		recomendados.add(projeto);
	}
	public boolean rmRecomendado(int codigo){
		for(int i = 0; i < recomendados.size(); i++){
			if(recomendados.get(i) == null){
				if(codigo == recomendados.get(i).getCodigo()){
					recomendados.remove(i);
					return true;
				}
			}
		}
		return false;
	}
}