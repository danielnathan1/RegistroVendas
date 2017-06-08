import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	//variaveis de controle
	public String opcao;
	public String opcaoRetorno = "2";
	public String opcaoListagem;
	public String opcaoListagemRetorno = "2";
	//entrada de dados
	Scanner leitor = new Scanner(System.in);
	
	//funcao de exibicao principal
	public String menuPrincipal(){
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\tBEM VINDO AO REGISTRO DE VENDA\n\n");
		System.out.println("\n[1]-EFETUAR VENDA");
		System.out.println("\n[2]-REGISTRAR VENDEDOR");
		System.out.println("\n[3]-REGISTRAR PRODUTO");
		System.out.println("\n[4]-LISTAGEM");
		System.out.println("\n[5]-SAIR");
		System.out.println("----------------------------------------------------------------------");
		
		try{
		setOpcao(leitor.nextLine());
		}catch (InputMismatchException e) {
			System.out.println("ERRO: valor informado incorreto");
		}
		return opcao;
	}
	
	public String menuRetorno(){
		System.out.println("----------------------------------------------------------------------");
		System.out.println("[1]-VOLTAR AO MENU");
		System.out.println("[2]-REGRISTAR NOVAMENTE");
		System.out.println("\n4- SAIR");
		
		setOpcaoRetorno(leitor.nextLine());
		
		if(getOpcaoRetorno() == "4")
			System.exit(0);
		return opcaoRetorno;
	}
	
	public void menuVenda(){
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\n\t\tVENDA DE PRODUTOS");
	}
	
	public String menuListagem(){
		//variaveis para exibicao incluindo objetos
		
		
		//opcao de listagem
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t\tMENU DE LISTAGEM");
		System.out.println("\n[1]-MOSTRAR PRODUTO");
		System.out.println("\n[2]-MOSTRA VENDEDOR");
		System.out.println("\n[3]-MOSTRA VENDA");
		System.out.println("\n\n[4]-SAIR");
		
		try{
			setOpcaoListagem(leitor.nextLine());
			}catch (InputMismatchException e) {
				System.out.println("ERRO: valor informado incorreto");
			}finally {
				
			}
		
		
		//switch para controlar oque ira ser exibido
		
		return opcaoListagem;
		
	}
	public String menuRetornoListagem(){
		System.out.println("----------------------------------------------------------------------");
		System.out.println("[1]-VOLTAR AO MENU");
		System.out.println("[2}-LISTAR NOVAMENTE");
		System.out.println("\n[4]- SAIR");
		
		setOpcaoListagemRetorno(leitor.nextLine());
		
		
		if(getOpcaoListagemRetorno() == "4")
			System.exit(0);
		return opcaoListagemRetorno;
	}
	public void limpar(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public String getOpcaoRetorno() {
		return opcaoRetorno;
	}

	public void setOpcaoRetorno(String opcaoRetorno) {
		this.opcaoRetorno = opcaoRetorno;
	}

	public String getOpcaoListagem() {
		return opcaoListagem;
	}

	public void setOpcaoListagem(String opcaoListagem) {
		this.opcaoListagem = opcaoListagem;
	}

	public String getOpcaoListagemRetorno() {
		return opcaoListagemRetorno;
	}

	public void setOpcaoListagemRetorno(String opcaoListagemRetorno) {
		this.opcaoListagemRetorno = opcaoListagemRetorno;
	}
	
	
	

}
