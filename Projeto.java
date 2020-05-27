import java.util.ArrayList;

public class Projeto{
	private String titulo, genero, sinopse, texto;
	private int codigo;
	private ArrayList<Editor> recomendacao = new ArrayList<Editor>();
	private ArrayList<Editora> aceitacao = new ArrayList<Editora>();
	private Autor autor = new Autor();
	int in = 0;

	// Construtores
	public Projeto(){
		titulo = null;
		genero = null;
		codigo = 0;
	}
	public Projeto(String titulo, String genero, String sinopse, String texto, int codigo, Autor autor) {
		this.titulo = titulo;
		this.genero = genero;
		this.codigo = codigo;
		this.sinopse = sinopse;
		this.texto = texto;
		this.autor = autor;
	}
	public Projeto(String titulo, String genero) {
		this.titulo = titulo;
		this.genero = genero;
	}

	// Métodos SET
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	public void setGenero(String genero){
		this.genero = genero;
	}
	public void setSinopse(String sinopse){
		this.sinopse = sinopse;
	}
	public void setTexto(String texto){
		this.texto = texto;
	}

	// Métodos GET
	public String getTitulo(){
		return titulo;
	}
	public String getGenero(){
		return genero;
	}
	public String getSinopse(){
		return sinopse;
	}
	public String getTexto(){
		return texto;
	}
	public int getCodigo(){
		return codigo;
	}
	public ArrayList<Editor> getRecomendacoes(){
		return recomendacao;
	}
	public ArrayList<Editora> getAceitacoes(){
		return aceitacao;
	}
	public Autor getAutor(){
		return autor;
	}

	// Demais métodos
	public void editorRecomendou(Editor editor){
		recomendacao.add(editor);
	}
	public void editoraAceitou(Editora editora){
		aceitacao.add(editora);
	}
	public void editorCancelou(Editor editor){
		recomendacao.remove(editor);
	}
	public void editoraCancelou(Editora editora){
		aceitacao.remove(editora);
	}
}