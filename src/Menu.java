import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	
	//variaveis de controle
	public int opcao;
	public int opcaoRetorno = 2;
	public int opListagem;
	//entrada de dados
	Scanner leitor = new Scanner(System.in);
	
	//funcao de exibicao principal
	public int menuPrincipal(){
		System.out.println("------------------------------------------");
		System.out.println("\tBEM VINDO AO REGISTRO DE VENDA\n\n");
		System.out.println("\n1-EFETUAR VENDA");
		System.out.println("\n2-REGISTRAR VENDEDOR");
		System.out.println("\n3-REGISTRAR PRODUTO");
		System.out.println("\nLSITAGEM DE ");
		System.out.println("\n5-SAIR");
		System.out.println("------------------------------------------");
		
		try{
		setOpcao(leitor.nextInt());
		}catch (InputMismatchException e) {
			System.out.println("ERRO: valor informado incorreto");
		}finally {
			
		}
		return opcao;
	}
	
	public int menuRetorno(){
		System.out.println("------------------------------------------");
		System.out.println("1-VOLTAR AO MENU");
		System.out.println("2-REGRISTAR NOVAMENTE");
		System.out.println("\n4- SAIR");
		
		setOpcaoRetorno(leitor.nextInt());
		
		return opcaoRetorno;
	}
	
	public void menuVenda(){
		
		System.out.println("-------------------------------------------");
		System.out.println("\n\t\tVENDA DE PRODUTOS");
	}
	
	public int menuListagem(){
		//opcao de listagem
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\t\tMENU DE LISTAGEM");
		System.out.println("\n1-MOSTRAR PRODUTO");
		System.out.println("\n2-MOSTRA VENDEDOR");
		System.out.println("\n3-MOSTRA VENDA");
		System.out.println("\n\n4-VOLTAR");
		
		try{
			setOpListagem(leitor.nextInt());
			}catch (InputMismatchException e) {
				System.out.println("ERRO: valor informado incorreto");
			}finally {
				
			}
		
		return opListagem;
		
	}
	
	public void limpar(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}
	
	
	
	public int getOpcao() {
		return opcao;
	}
	

	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	public int getOpcaoRetorno() {
		return opcaoRetorno;
	}

	public void setOpcaoRetorno(int opcaoRetorno) {
		this.opcaoRetorno = opcaoRetorno;
	}

	public int getOpListagem() {
		return opListagem;
	}

	public void setOpListagem(int opListagem) {
		this.opListagem = opListagem;
	}

	
}
