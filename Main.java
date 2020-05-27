import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
import java.lang.NullPointerException;

public class Main {
  public static Administrador adm = new Administrador();
	public static Scanner sc = new Scanner(System.in);
	public static Random r = new Random();
  public static int n = 10, opcao, cod;
  public static String nome, cpf, cnpj, email, telefone, acesso, senha, endereco, titulo, genero, sinopse, texto;
  public static char av;
  public static Editora loginEditora, check;
  public static Editor loginEditor;
  public static Autor loginAutor;
  public static void EditoraView(){
    int n11 = 0;
		while (n11 != 6) {
      System.out.println("[1] - Avaliar recomendação");
      System.out.println("[2] - Listar recomendações");
      System.out.println("[3] - Liberar editor");
      System.out.println("[4] - Bloquear editor");
      System.out.println("[5] - Remover editor");
      System.out.println("[6] - Alterar informações");
      System.out.println("[7] - Sair");
      n11 = sc.nextInt();
      switch (n11) {
        case 1:
          System.out.print("Código do livro: ");
          cod = sc.nextInt();
          System.out.print("Y - Aceitar/nN - Recusar: ");
          av = sc.next().charAt(0);
          if (loginEditora.avaliarRecomendado(cod, av)) {
            System.out.println("Feito.");
          } else {
            System.out.print("Erro.");
          }
        case 2:
          for (int i = 0; i < loginEditora.getEditores().size(); i++) {
            if (loginEditora.getEditores().get(i) != null) {
              Editor forEditor = loginEditora.getEditores().get(i);
              for (int j = 0; j < forEditor.getRecomendados().size(); j++) {
                if (forEditor.getRecomendados().get(j) != null) {
                  System.out.println("---------------------------------");
                  Projeto forRecomendado = forEditor.getRecomendados().get(i);
                  System.out.println("Título: " + forRecomendado.getTitulo());
                  System.out.println("Autor: " + forRecomendado.getAutor().getNome());
                  System.out.println("Gênero: " + forRecomendado.getGenero());
                  System.out.println("Código: " + forRecomendado.getCodigo());
                  System.out.println("Sinópse: " + forRecomendado.getSinopse());
                  System.out.println(" ");
                }
              }
            }
          }
          System.out.println("---------------------------------");
          break;
        case 3:
          System.out.print("CPF do editor: ");
          cpf = sc.next();
          Editor liberando = loginEditora.getEditor(cpf);
          if (liberando != null) {
            System.out.println("Tem certeza que deseja liberar essa conta?");
            System.out.println("[1] - Sim [2] - Não");
            opcao = sc.nextInt();
            if (opcao == 1) {
              liberando.setAtiva(true);
              System.out.println("Conta liberada com sucesso. O editor agora pode acessá-la.");
            }
            else {
              System.out.println("Operação cancelada.");
            }
          }
          break;
        case 4:
          System.out.print("CPF do editor: ");
          cpf = sc.next();
          Editor bloqueando = loginEditora.getEditor(cpf);
          if (bloqueando != null) {
            System.out.println("Tem certeza que deseja bloquear essa conta?");
            System.out.println("[1] - Sim [2] - Não");
            opcao = sc.nextInt();
            if (opcao == 1) {
              bloqueando.setAtiva(false);
              System.out.println("Conta bloqueada com sucesso. O editor não poderá mais acessá-la.");
            }
            else {
              System.out.println("Operação cancelada.");
            }
          }
        case 5:
          System.out.print("CPF do editor: ");
          cpf = sc.next();
          Editor excluindo = loginEditora.getEditor(cpf);
          if (excluindo != null) {
            System.out.println("Tem certeza que quer excluir essa conta?");
            System.out.println("[1] - Sim [2] - Não");
            opcao = sc.nextInt();
            if (opcao == 1) {
              loginEditora.rmEditor(excluindo);
              System.out.println("Excluído com sucesso.");
            }
            else {
              System.out.println("Operação cancelada.");
            }
          }
          else {
          System.out.println("Não foi possível encontrar essa conta. Escolha um código válido.");
          break;
        }
        case 6:
          System.out.println("[1] - set nome");
          System.out.println("[2] - set CNPJ");
          System.out.println("[3] - set telefone");
          System.out.println("[4] - set email");
          System.out.println("[5] - set endereço");
          System.out.println("[6] - set acesso");
          System.out.println("[7] - set senha");
          int n115 = sc.nextInt();
          switch (n115) {
            case 1:
              System.out.println("Novo nome: ");
              String nome = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              int opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditora.setNome(nome);
                System.out.println("Alteração feita com sucesso.");
              }
              else {
                System.out.println("Operação cancelada.");
              }
              break;
            case 2:
              System.out.println("Novo CNPJ: ");
              String cnpj = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditora.setCNPJ(cnpj);
                System.out.println("Alteração feita com sucesso.");
              }
              else {
                System.out.println("Operação cancelada.");
              }
              break;
            case 3:
              System.out.println("Novo telefone: ");
              String telefone = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditora.setTelefone(telefone);
                System.out.println("Alteração feita com sucesso.");
              }
              else {
                System.out.println("Operação cancelada.");
              }
              break;
            case 4:
              System.out.println("Novo e-mail: ");
              String email = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditora.setEmail(email);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
            case 5:
              System.out.println("Novo endereço: ");
              String endereco = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditora.setEndereco(endereco);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
            case 6:
              System.out.println("Novo acesso: ");
              acesso = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditora.setAcesso(acesso);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
            case 7:
              System.out.println("Novo senha: ");
              senha = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditora.setSenha(senha);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
          }
        case 7:
          return;
      }
    }
  }
  public static void EditorView(){
    int n21 = 0;
			while (n21 != 6) {
      System.out.println("[1] - Lista de obras");
      System.out.println("[2] - Recomendar obra");
      System.out.println("[3] - Lista de recomendações");
      System.out.println("[4] - Excluir recomendação");
      System.out.println("[5] - Alterar dados");
      System.out.println("[6] - Sair");
      n21 = sc.nextInt();
      switch (n21) {
        case 1:
          for (int i = 0; i < adm.getAutores().size(); i++) {
            if (adm.getAutores().get(i) != null) {
              Autor forAutor = adm.getAutores().get(i);
              for (int j = 0; j < forAutor.getProjetos().size(); j++) {
                if (forAutor.getProjetos().get(j) != null) {
                  System.out.println("---------------------------------");
                  Projeto forProjeto = forAutor.getProjetos().get(j);
                  System.out.println("Título: " + forProjeto.getTitulo());
                  System.out.println("Autor: " + forProjeto.getAutor().getNome());
                  System.out.println("Gênero: " + forProjeto.getGenero());
                  System.out.println("Código: " + forProjeto.getCodigo());
                  System.out.println("Sinópse: " + forProjeto.getSinopse());
                  System.out.println(" ");
                }
              }
            }
          }
          System.out.println("---------------------------------");
          break;
        case 2:
          System.out.print("CPF do autor: ");
          cpf = sc.next();
          Autor buscarAutor = adm.getAutor(cpf);
          if (buscarAutor != null) {
            System.out.print("Código do projeto [apenas números]: ");
            int codigo = sc.nextInt();
            Projeto buscarProjeto = buscarAutor.getProjeto(codigo);
            if (buscarProjeto != null) {
              System.out.println("Tem certeza que deseja recomendar essa história?");
              System.out.println("[1] - Sim [2] - Não");
              int opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditor.adRecomendado(buscarProjeto);
                buscarProjeto.editorRecomendou(loginEditor);
                System.out.println("Recomendado com sucesso.");
              } else {
                System.out.println("Operação cancelada.");
              }
            }
          }
          break;
        case 3:
          for (int i = 0;i < loginEditor.getRecomendados().size(); i++) {
            Projeto recomendado = loginEditor.getRecomendados().get(i);
            System.out.println("Título: " + recomendado.getTitulo());
            System.out.println("Autor: " + recomendado.getAutor().getNome());
            System.out.println("Gênero: " + recomendado.getGenero());
            System.out.println("Código: " + recomendado.getCodigo());
            System.out.println(" ");
          }
          break;
        case 4:
          System.out.println("Código da obra [números apenas]:");
          int codigo = sc.nextInt();
          Projeto apagando = loginEditor.getRecomendado(codigo);
          if (apagando != null) {
            System.out.println("Tem certeza que deseja excluir essa recomendação?");
            System.out.println("[1] - Sim [2] - Não");
            int opcao = sc.nextInt();
            if (opcao == 1) {
              loginEditor.rmRecomendado(codigo);
              apagando.editorCancelou(loginEditor);
              System.out.println("Recomendação excluída com sucesso.");
            }
            else {
              System.out.println("Operação cancelada.");
            }
          }
          break;
        case 5:
          System.out.println("[1] - set nome");
          System.out.println("[2] - set CPF");
          System.out.println("[3] - set telefone");
          System.out.println("[4] - set email");
          System.out.println("[5] - set acesso");
          System.out.println("[6] - set senha");
          int n115 = sc.nextInt();
          switch (n115) {
            case 1:
              System.out.println("Novo nome: ");
              String nome = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              int opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditor.setNome(nome);
                System.out.println("Alteração feita com sucesso.");
              }
              else {
                System.out.println("Operação cancelada.");
              }
              break;
            case 2:
              System.out.println("Novo CPF: ");
              String cpf = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditor.setCPF(cpf);
                System.out.println("Alteração feita com sucesso.");
              }
              else {
                System.out.println("Operação cancelada.");
              }
              break;
            case 3:
              System.out.println("Novo telefone: ");
              String telefone = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditor.setTelefone(telefone);
                System.out.println("Alteração feita com sucesso.");
              }
              else {
                System.out.println("Operação cancelada.");
              }
            case 4:
              System.out.println("Novo e-mail: ");
              String email = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditor.setEmail(email);
                System.out.println("Alteração feita com sucesso.");
              }
              else {
                System.out.println("Operação cancelada.");
              }
              break;
            case 5:
              System.out.println("Novo acesso: ");
              acesso = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditor.setAcesso(acesso);
                System.out.println("Alteração feita com sucesso.");
              }
              else {
                System.out.println("Operação cancelada.");
              }
              break;
            case 6:
              System.out.println("Novo senha: ");
              senha = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginEditor.setSenha(senha);
                System.out.println("Alteração feita com sucesso.");
              }
              else {
                System.out.println("Operação cancelada.");
              }
              break;
          }
        case 6:
          return;
      }
    }
  }
  public static void AutorView(){
    int n31 = 0;
		while (n31 != 6) {
      System.out.println("[1] - Adicionar história");
      System.out.println("[2] - Listar histórias");
      System.out.println("[3] - Alterar história");
      System.out.println("[4] - Excluir história");
      System.out.println("[5] - Alterar dados");
      System.out.println("[6] - Sair");
      n31 = sc.nextInt();
      switch (n31) {
        case 1:
          System.out.print("Título: ");
          titulo = sc.next();
          System.out.print("Gênero: ");
          genero = sc.next();
          System.out.print("Sinópse: ");
          sinopse = sc.next();
          System.out.println("Conteúdo do livro: ");
          texto = sc.next();
          System.out.println("Tem certeza que deseja enviar essa história?");
          System.out.println("[1] - Sim [2] - Não");
          int opcao = sc.nextInt();
          if (opcao == 1) {
            int codigo = r.nextInt(9999);
            Projeto projeto = new Projeto(titulo, genero, sinopse, texto, codigo, loginAutor);
            loginAutor.adProjeto(projeto);
            System.out.println("História adicionada com sucesso.");
            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + loginAutor.getNome());
            System.out.println("Gênero: " + genero);
            System.out.println("Código: " + codigo);
            System.out.println("Sinópse: " + sinopse);
            break;
          } else {
            System.out.println("Operação cancelada.");
          }
        case 2:
          System.out.println("Autor: " + loginAutor.getNome());
          System.out.println(" ");
          for (int i = 0; i < loginAutor.getProjetos().size(); i++) {
            if (loginAutor.getProjetos().get(i) != null) {
              Projeto forProjeto = loginAutor.getProjetos().get(i);
              System.out.println("---------------------------------");
              System.out.println("Título: " + forProjeto.getTitulo());
              System.out.println("Gênero: " + forProjeto.getGenero());
              System.out.println("Código: " + forProjeto.getCodigo());
              System.out.println("Sinópse: " + forProjeto.getSinopse());
              System.out.println("Recomendado por: ");
              for (int j = 0; j < forProjeto.getRecomendacoes().size(); j++) {
                if (forProjeto.getRecomendacoes().get(j) != null) {
                  Editor forRecomendou = forProjeto.getRecomendacoes().get(j);
                  System.out.println(forRecomendou.getNome() + " (Código: " + forRecomendou.getAcesso() + ")");
                }
              }
              System.out.println("Aceito por: ");
              for (int k = 0; k < forProjeto.getAceitacoes().size(); k++) {
                if (forProjeto.getAceitacoes().get(k) != null) {
                  Editora forAceitou = forProjeto.getAceitacoes().get(k);
                  System.out.println(forAceitou.getNome() + " (Código: " + forAceitou.getAcesso() + ")");
                }
              }
            }
          }
          System.out.println("---------------------------------");
          break;
        case 3:
          int codigo = sc.nextInt();
          Projeto alterando = loginAutor.getProjeto(codigo);
          if (alterando != null) {
            System.out.println("[1] - Alterar título");
            System.out.println("[2] - Alterar gênero");
            System.out.println("[3] - Alterar sinópse");
            System.out.println("[4] - Alterar texto");
            int n313 = sc.nextInt();
            switch (n313) {
              case 1:
                System.out.print("Novo título: ");
                titulo = sc.next();
                System.out.println(
                    "Tem certeza que deseja alterar o título de " + alterando.getTitulo() + " para " + titulo + "?");
                System.out.println("[1] - Sim [2] - Não");
                opcao = sc.nextInt();
                if (opcao == 1) {
                  alterando.setTitulo(titulo);
                  System.out.println("Alteração feita com sucesso.");
                } else {
                  System.out.print("Operação cancelada.");
                }
              case 2:
                System.out.print("Novo gênero: ");
                genero = sc.next();
                System.out.println(
                    "Tem certeza que deseja alterar o gênero de " + alterando.getGenero() + " para " + genero + "?");
                System.out.println("[1] - Sim [2] - Não");
                opcao = sc.nextInt();
                if (opcao == 1) {
                  alterando.setGenero(genero);
                  System.out.println("Alteração feita com sucesso.");
                } else {
                  System.out.print("Operação cancelada.");
                }
              case 3:
                System.out.print("Nova sinópse: ");
                sinopse = sc.next();
                System.out.println(
                    "Tem certeza que deseja alterar a sinópse de " + alterando.getTitulo() + " para " + sinopse + "?");
                System.out.println("[1] - Sim [2] - Não");
                opcao = sc.nextInt();
                if (opcao == 1) {
                  alterando.setSinopse(sinopse);
                  System.out.println("Alteração feita com sucesso.");
                } else {
                  System.out.print("Operação cancelada.");
                }
              case 4:
                System.out.print("Novo texto: ");
                texto = sc.next();
                System.out.println(
                    "Tem certeza que deseja alterar o texto de " + alterando.getTitulo() + " para " + texto + "?");
                System.out.println("[1] - Sim [2] - Não");
                opcao = sc.nextInt();
                if (opcao == 1) {
                  alterando.setTexto(texto);
                  System.out.println("Alteração feita com sucesso.");
                } else {
                  System.out.print("Operação cancelada.");
                }
            }
          } else {
            System.out.println("Não encontrado.");
          }
          break;
        case 4:
          System.out.println("Código: ");
          codigo = sc.nextInt();
          Projeto excluindo = loginAutor.getProjeto(codigo);
          if (excluindo != null) {
            System.out.println("Tem certeza que deseja apagar?");
            System.out.println("[1] - Sim [2] - Não");
            opcao = sc.nextInt();
            if (opcao == 1) {
              loginAutor.rmProjeto(codigo);
              System.out.println("Excluído com sucesso.");
            } else {
              System.out.println("Operação cancelada.");
            }
          } else {
            System.out.println("Não encontrado.");
          }
          break;
        case 5:
          System.out.println("[1] - set nome");
          System.out.println("[2] - set CNPJ");
          System.out.println("[3] - set telefone");
          System.out.println("[4] - set email");
          System.out.println("[5] - set acesso");
          System.out.println("[6] - set senha");
          int n115 = sc.nextInt();
          switch (n115) {
            case 1:
              System.out.println("Novo nome: ");
              String nome = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginAutor.setNome(nome);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
            case 2:
              System.out.println("Novo CNPJ: ");
              String cpf = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginAutor.setCPF(cpf);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
            case 3:
              System.out.println("Novo telefone: ");
              String telefone = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginAutor.setTelefone(telefone);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
            case 4:
              System.out.println("Novo e-mail: ");
              String email = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginAutor.setEmail(email);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
            case 5:
              System.out.println("Novo acesso: ");
              acesso = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginAutor.setAcesso(acesso);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
            case 6:
              System.out.println("Novo senha: ");
              senha = sc.next();
              System.out.println("Tem certeza que deseja alterar?");
              System.out.println("[1] - Sim [2] - Não");
              opcao = sc.nextInt();
              if (opcao == 1) {
                loginAutor.setSenha(senha);
                System.out.println("Alteração feita com sucesso.");
                break;
              } else {
                System.out.println("Operação cancelada.");
                break;
              }
          }
        case 6:
          return;
      }
    }
  }
  public static void main(String[] args){
		System.out.println("Bem-vindo! :)");
		while(n != 0){
			try{
				System.out.println("[1] - Editora");
				System.out.println("[2] - Editor");
				System.out.println("[3] - Autor");
				System.out.println("[0] - Sair");
				n = sc.nextInt();
				switch(n){
					case 0:
						sc.close();
						System.out.print("Goodbye...");
						System.exit(0);
					case 1:
						System.out.println("[1] - Login");
						System.out.println("[2] - Registro");
						System.out.println("[3] - Voltar");
						int n1 = sc.nextInt();
						switch(n1){
							case 1:
								System.out.print("Acesso: ");
								acesso = sc.next();
								System.out.print("Senha: ");
								senha = sc.next();
								loginEditora = adm.logEditora(acesso, senha);
								if(loginEditora != null){
                  EditoraView();
                }
								else{
										System.out.println("Acesso e/ou senha incorretos.");
								}
								break;
							case 2:
								System.out.print("Nome: ");
								nome = sc.next();
								System.out.print("CNPJ: ");
								cnpj = sc.next();
								System.out.print("Telefone: ");
								telefone = sc.next();
								System.out.print("Email: ");
								email = sc.next();
								System.out.print("Endereço: ");
								endereco = sc.next();
								System.out.println("Tem certeza que deseja criar essa história?");
								System.out.println("[1] - Sim [2] - Não");
								opcao = sc.nextInt();
								if(opcao == 1){
									int a = r.nextInt(99999);
									acesso = Integer.toString(a);
									int s = r.nextInt(99999999);
									senha = Integer.toString(s);
									adm.adEditora(nome, cnpj, telefone, email, endereco, acesso, senha);
									System.out.println("Conta criada com sucesso.");
									System.out.println("Acesso: " + acesso);
									System.out.println("Senha: " + senha);
								}
								else{
									System.out.println("Operação cancelada.");
								}
								break;
							case 3:
								break;
						}
						break;
					case 2:
						System.out.println("[1] - Login");
						System.out.println("[2] - Registro");
						System.out.println("[3] - Voltar");
						int n2 = sc.nextInt();
						switch(n2){
							case 1:
								System.out.print("CNPJ da editora: ");
								cnpj = sc.next();
                check = adm.getEditora(cnpj);
								System.out.print("Acesso: ");
								acesso = sc.next();
								System.out.print("Senha: ");
								senha = sc.next();
								loginEditor = check.logEditor(acesso, senha);
								if(loginEditor != null){
									if(loginEditor.getAtiva()){
                    EditorView();
                  }
									else{
										System.out.println("Conta ainda não liberada. Por favor entre em contato com sua Editora.");
									}
								}
								else{
									System.out.println("Acesso e/ou senha não encontrados.");
								}
								break;
							case 2:
								System.out.print("CNPJ da editora: ");
                cnpj = sc.next();
                check = adm.getEditora(cnpj);
								if (check != null){
									System.out.print("Nome: ");
									String nome = sc.next();
									System.out.print("CPF: ");
									String cpf = sc.next();
									System.out.print("Telefone: ");
									String telefone = sc.next();
									System.out.print("Email: ");
									String email = sc.next();
									System.out.println("Tem certeza que deseja criar essa conta?");
									System.out.println("[1] - Sim [2] - Não");
									int opcao = sc.nextInt();
									if(opcao == 1){
										int a = r.nextInt(99999);
										String acesso = Integer.toString(a);
										int s = r.nextInt(99999999);
										String senha = Integer.toString(s);
										check.adEditor(nome, cpf, telefone, email, acesso, senha);
										System.out.println("Conta criada com sucesso.");
										System.out.println("Acesso: " + acesso);
										System.out.println("Senha: " + senha);
									}
									else{
										System.out.println("Operação cancelada.");
									}
                }
							  else{
								  System.out.println("Editora não encontrada.");
							  }
							  break;
							case 3:
								break;
						}
						break;
					case 3:
						System.out.println("[1] - Login");
						System.out.println("[2] - Registro");
						System.out.println("[3] - Voltar");
						int n3 = sc.nextInt();
						switch(n3){
							case 1:
								System.out.print("Acesso: ");
								acesso = sc.next();
								System.out.print("Senha: ");
								senha = sc.next();
								loginAutor = adm.logAutor(acesso, senha);
								if(loginAutor != null){
									AutorView();
								}
								else{
									System.out.println("Acesso e senha não encontrados.");
									break;
								}
								break;
							case 2:
								System.out.print("Nome: ");
								nome = sc.next();
								System.out.print("CPF: ");
								cpf = sc.next();
								System.out.print("Telefone: ");
								telefone = sc.next();
								System.out.print("Email: ");
								email = sc.next();
								System.out.println("Tem certeza que deseja criar essa conta?");
								System.out.println("[1] - Sim [2] - Não");
								int opcao = sc.nextInt();
								if(opcao == 1){
									int a = r.nextInt(99999);
									acesso = Integer.toString(a);
									int s = r.nextInt(99999999);
									senha = Integer.toString(s);
									adm.adAutor(nome, cpf, telefone, email, acesso, senha);
									System.out.println("Acesso: " + acesso);
									System.out.println("Senha: " + senha);
								}
								else{
									System.out.println("Operação cancelada.");
								}
								break;
							case 3:
								break;
						}
					break;
				}
			}
			catch(InputMismatchException mismatch) {
				System.out.println("-----------------------");
				System.out.println("Digite um valor válido.");
				System.out.println("-----------------------");
		//		sc.next();
			}
			catch(NullPointerException nullpoint){
				System.out.println("-----");
				System.out.println("Nulo.");
				System.out.println("-----");
		//		sc.next();
			}
		}
	}
}