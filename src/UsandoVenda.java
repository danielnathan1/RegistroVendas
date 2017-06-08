import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
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
		
		
	
		while(menu.getOpcao()!= "5"){
			menu.limpar();
			menu.menuPrincipal();
			menu.setOpcaoRetorno(2) ;
			//menu.limpar();
			switch (menu.getOpcao()) {
			case "1":
				//EFETUAR VENDA
				
				while(menu.getOpcaoRetorno()== 2){
					menu.limpar();
					venda.registroVenda(venda);
					venda.setHoras(gerarhora.gerador());
					venda.mostrarVenda(venda);
					persist.salvarObjeto(venda,(String)"vendas/"+venda.horas);
					menu.menuRetorno();
					
				}
				break;
				
			case "2":
				
				//controle de retorno ou saida
				while(menu.getOpcaoRetorno()==2){
					//
					menu.limpar();
					vendedor.registrarVendedor(vendedor);
					persist.salvarObjeto(vendedor, "vendedores/"+ vendedor.getId());
					vendedor.mostrarVendedor(vendedor);
					menu.menuRetorno();
					
					}
			
				
				break;
	
			/*
			 * Registra, Salva e Mostra um produto
			 */
			case "3":
				//controle para o retorno  de menu
				while(menu.getOpcaoRetorno()==2){
					
					//limpar a tela
					menu.limpar();
					//registrar o produto
					produto.registrarProduto(produto);
					//Salva o produto
					persist.salvarObjeto(produto, "produtos/" + produto.getCodigo());
					//mostra o produto salvo
					produto.mostraProduto(produto);
					//menu de saida ou retorno
					menu.menuRetorno();
				}
				
				break;
			//LISTAGEM
			case "4":
				while(menu.getOpcaoListagem()!="5"){
					menu.menuListagem();
					//switch para controlar oque ira ser exibido
					
					switch (menu.getOpcaoListagem()){
					
					case "1":
						while(menu.getOpcaoListagemRetorno() == 2){
							System.out.println("----------------------------------------------------------------------");
							System.out.println("DIGITE O CODIGO DO PRODUTO:");
							produto = (Produto) persist.lerObjeto("produtos/" + leitor.nextLine());
							//ler o arquivo e printa o dados do produto
							if(produto==null){
								while(produto==null){
									System.out.println("----------------------------------------------------------------------");
									System.out.println("DIGITE O CODIGO DO PRODUTO:");
									produto = (Produto) persist.lerObjeto("produtos/" + leitor.nextLine());
								}
							}
							produto.mostraProduto(produto);
							menu.setOpcaoListagemRetorno(menu.menuRetornoListagem());
						}
						break;
					
					case "2":
						while(menu.getOpcaoListagemRetorno() == 2){
							System.out.println("----------------------------------------------------------------------");
							System.out.println("DIGITE O ID DO VENDEDOR:");
							vendedor = (Vendedor) persist.lerObjeto("vendedores/" + leitor.nextLine());
							//ler o arquivo e printa o dados do vendedor
							if(vendedor==null){
								while(vendedor==null){
									System.out.println("----------------------------------------------------------------------");
									System.out.println("DIGITE O ID DO VENDEDOR:");
									vendedor = (Vendedor) persist.lerObjeto("vendedores/" + leitor.nextLine());
								}
							}
							vendedor.mostrarVendedor(vendedor);
							menu.setOpcaoListagemRetorno(menu.menuRetornoListagem());
						}
						break;
						
					case "3":
						while(menu.getOpcaoListagemRetorno() == 2){
							System.out.println("----------------------------------------------------------------------");
							System.out.println("DIGITE A HORA/MINUTO/SEGUNDO DA VENDA SEM [:]: ");
							venda = (Venda) persist.lerObjeto("vendas/" + leitor.nextLine());
							//ler o arquivo e printa os dados da venda
							if(venda==null){
								while(venda==null){
									System.out.println("----------------------------------------------------------------------");
									System.out.println("DIGITE A HORA/MINUTO/SEGUNDO DA VENDA SEM [:]: ");
									venda = (Venda) persist.lerObjeto("vendas/" + leitor.nextLine());
								}
							}
							venda.mostrarVenda(venda);
							menu.setOpcaoListagemRetorno(menu.menuRetornoListagem());
						}
						break;
					
					case "4":
						
						System.exit(0);
						break;
						
					default:
						System.out.println("VALOR INFORMADO INVALIDO");
						break;
	
					}
				}
					
				
			//SAIR
			case "5":
				System.exit(0);
				
			default:
				System.out.println("DIGITE UM VALOR VALIDO:");
				menu.opcao = leitor.nextLine();
				
					
			}
		}
	}
}