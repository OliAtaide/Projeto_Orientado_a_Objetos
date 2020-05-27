import java.util.ArrayList;

public class Administrador{
	ArrayList<Autor> autores = new ArrayList<Autor>();
	ArrayList<Editora> editoras = new ArrayList<Editora>();

	public ArrayList<Autor> getAutores(){
		return autores;
	}
	public Autor getAutor(String cpf){
		for(int i = 0; i < autores.size(); i++){
			if(autores.get(i).getCPF().equals(cpf)){
				return autores.get(i);
			}
		}
		return null;
	}
	public ArrayList<Editora> getEditoras(){
		return editoras;
	}

	public Autor logAutor(String acesso, String senha){
		for (int i = 0; i < autores.size(); i++){
			if(autores.get(i) != null){
				if(autores.get(i).getAcesso().equalsIgnoreCase(acesso) && autores.get(i).getSenha().equalsIgnoreCase(senha)){
					return autores.get(i);
				}
			}
		}
		return null;
	}

	public void adAutor(String nome, String cpf, String telefone, String email, String acesso, String senha){
		Autor autor = new Autor(nome, cpf, telefone, email, acesso, senha);
		autores.add(autor);
	}

	public boolean rmAutor(Autor autor){
		if(autores.contains(autor)){
			autores.remove(autor);
			return true;
		}
		return false;
	}

	public Editora logEditora(String acesso, String senha){
		for(int i = 0; i < editoras.size(); i++){
			if(editoras.get(i) != null){
				if(editoras.get(i).getAcesso().equalsIgnoreCase(acesso) && editoras.get(i).getSenha().equalsIgnoreCase(senha)){
					return editoras.get(i);
				}
			}
		}
		return null;
	}
	
	public void adEditora(String nome, String cnpj, String telefone, String email, String endereco, String acesso, String senha){
		Editora editora = new Editora(nome, cnpj, telefone, email, endereco, acesso, senha);	
		editoras.add(editora);
	}

	public boolean rmEditora(Editora editora){
		if(editoras.contains(editora)){
			editoras.remove(editora);
		}
		return false;
	}
	public Editora getEditora(String cnpj){
		for(int i = 0; i < editoras.size(); i++){
			if (editoras.get(i).getCNPJ().equals(cnpj)){
				return editoras.get(i);
			}
		}
		return null;
	}

}