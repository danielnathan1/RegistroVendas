import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class UsandoVenda {
	public static void main(String[] args) {
		//menu contem a parte de interface de interacao com o usuaria
		Menu menu = new Menu();
		//objeto para vendedor
		Vendedor vendedor = new Vendedor();
		//objeto para produto
		Produto produto = new Produto();
		//objeto para venda
		Venda venda = new Venda();
		//objeto para gerar horas
		GerarHora gerarhora = new GerarHora();
		//leitor de entrada de dados
		Scanner leitor = new Scanner(System.in);
		//objeto para controle de persistencia
		Persist persist = new Persist();
		
		
	
		while(menu.getOpcao()!= 4){
			menu.limpar();
			menu.menuPrincipal();
			menu.setOpcaoRetorno(2) ;
			//menu.limpar();
			switch (menu.getOpcao()) {
			case 1:
				//EFETUAR VENDA
				
				while(menu.getOpcaoRetorno()== 2){
					menu.limpar();
					venda.registroVenda(venda);
					venda.setHoras(gerarhora.gerador());
					venda.mostrarVenda(venda);
					persist.salvar(venda,(String)"vendas/"+venda.horas);
					menu.menuRetorno();
				
				}
				break;
				
			case 2:
				
				//controle de retorno ou saida
				while(menu.getOpcaoRetorno()==2){
					//
					menu.limpar();
					vendedor.registrarVendedor(vendedor);
					persist.salvar(vendedor, "vendedores/"+ vendedor.getId());
					vendedor.mostrarVendedor(vendedor);
					menu.menuRetorno();
				}
			
				
				break;
			/*
			 * Registra, Salva e Mostra um produto
			 */
			case 3:
				//controle para o retorno  de menu
				while(menu.getOpcaoRetorno()==2){
					
					//limpar a tela
					menu.limpar();
					//registrar o produto
					produto.registrarProduto(produto);
					//Salva o produto
					persist.salvar(produto, "produtos/" + produto.getCodigo());
					//mostra o produto salvo
					produto.mostraProduto(produto);
					//menu de saida ou retorno
					menu.menuRetorno();
					
				}
				
				break;
			//LISTAGEM
			case 4:
				while(menu.getOpcaoRetorno()==2){
					menu.menuListagem();
					//switch para controlar oque ira ser exibido
					
					switch (menu.getOpcaoListagem()){
					
					case 1:
						//ler o arquivo e printa o dados do produto
						System.out.println("DIGITE O CODIGO DO PRODUTO:");
						produto.mostraProduto((Produto)persist.lerObjeto("produtos/" + leitor.nextLine()));
						
						break;
					
					case 2:
						
						//ler o arquivo e printa o dados do vendedor
						System.out.println("DIGITE O ID DO VENDEDOR:");
						vendedor.mostrarVendedor((Vendedor)persist.lerObjeto("vendedores/" + leitor.nextLine()));
						break;
						
					case 3:
						
						//ler o arquivo e printa os dados da venda
						System.out.println("DIGITE A HORA/MINUTO/SEGUNDO DA VENDA SEM [:]: ");
						venda.mostrarVenda((Venda)persist.lerObjeto("vendas/" + leitor.nextLine()));
						break;
					
					case 4:
						
						System.exit(0);
						break;
						
					default:
						//tratamento para entrada de dados invalidas
						try{
						System.out.println("VALOR INFORMADO INVALIDO\nDIGITE UM VALOR VALIDO:");
						menu.setOpcaoListagem(leitor.nextInt());
						}catch (InputMismatchException e) {
							System.out.println("\nERRO: Valor Informado invalido\nO PROGRAMA SERA ENCERRADO");
						}finally {
							System.exit(0);
						}
					}
					menu.menuRetornoListagem();
					
				}
				break;
				
			//SAIR
			case 5:
				System.exit(0);
				
			default:
				menu.setOpcao(0);
				try{
				System.out.println("DIGITE UM VALOR VALIDO:");
				menu.opcao = leitor.nextInt();
				}catch (InputMismatchException e) {
					System.out.println("ERRO: Valor Informado Invalido");
					System.out.println("O PROGRAMA SERA FINALIZADO");
					System.exit(0);
				}
			}
		}
	}
}