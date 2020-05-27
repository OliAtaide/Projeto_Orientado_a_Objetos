import java.util.ArrayList;

public class Editora{
	private String nome, cnpj, telefone, email, endereco, acesso, senha;
	ArrayList<Editor> editores = new ArrayList<Editor>();
	ArrayList<Projeto> aceitos = new ArrayList<Projeto>();

	// Construtores
	public Editora(){
		nome = null;
		cnpj = null;
		telefone = null;
		email = null;
		endereco = null;
		acesso = null;
		senha = null;
	}
	public Editora(String nome, String cnpj, String telefone, String email, String endereco, String acesso, String senha) {
		//if(cnpj.length() != 14){
		//	throw new FormatoInvalidoException("CNPJ deve ter 14 digitos");
		//}
		//if(telefone.length() != 11 || telefone.length() != 10){
		//	throw new FormatoInvalidoException("CNPJ deve ter 10 digitos, incluindo DDD. Celular deve ter 11.");
		//}
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.acesso = acesso;
		this.senha = senha;
	}

	// Métodos SET
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setCNPJ(String cnpj){
		this.cnpj = cnpj;
	}
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setEndereco(String endereco){
		this.endereco = endereco;
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
	public String getCNPJ(){
		return cnpj;
	}
	public String getTelefone(){
		return telefone;
	}
	public String getEmail(){
		return email;
	}
	public String getEndereco(){
		return endereco;
	}
	public String getAcesso(){
		return acesso;
	}
	public String getSenha(){
		return senha;
	}
	public ArrayList<Editor> getEditores(){
		return editores;
	}
	public ArrayList<Projeto> getAceitos(){
		return aceitos;
	}

	// Demais métodos
	public Editor logEditor(String acesso, String senha){
		for (int i = 0; i < editores.size(); i++){
			if(editores.get(i) != null){
				if(editores.get(i).getAcesso().equalsIgnoreCase(acesso) && editores.get(i).getSenha().equalsIgnoreCase(senha)){
					return editores.get(i);
				}
			}
		}
		return null;
	}
	public void adEditor(String nome, String cpf, String telefone, String email, String acesso, String senha){
		Editor editor = new Editor(nome, cpf, telefone, email, acesso, senha);
		editores.add(editor);
	}
	public boolean rmEditor(Editor editor){
		for (int i = 0; i < this.editores.size(); i++){
			if(this.editores.get(i) != null){
				editores.remove(editor);
			}
		}
		return false;
	}
	public boolean avaliarRecomendado(int cod, char opt){
		for(int i = 0; i < editores.size(); i++){
			for(int j = 0; j < editores.get(i).getRecomendados().size(); j++){
				Projeto recomendado = editores.get(i).getRecomendados().get(i);
				if(recomendado.getCodigo() == cod){
					if(Character.toLowerCase(opt) == 'y'){
						aceitos.add(recomendado);
					}
					editores.get(i).getRecomendados().remove(recomendado);
					return true;
				}
			}
		}
		return false;
	}
	public Editor getEditor(String cpf){
		for(int i = 0; i < editores.size(); i++){
			if(editores.get(i).getCPF().equals(cpf)){
				return editores.get(i);
			}
		}
		return null;
	}

}