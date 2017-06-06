import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.ParseConversionEvent;

public class UsandoVenda {
	public static void main(String[] args) {
		//variaveis para controle
		//
		Menu menu = new Menu();
		//
		Vendedor vendedor = new Vendedor();
		//
		Produto produto = new Produto();
		//
		Venda venda = new Venda();
		//
		Scanner leitor = new Scanner(System.in);
		//
		Persist persist = new Persist();
		
		
	
		while(menu.getOpcao()!= 4){
			menu.menuPrincipal();
			menu.setOpcaoRetorno(2) ;
			//menu.limpar();
			switch (menu.getOpcao()) {
			case 1:
				//EFETUAR VENDA
				
				while(menu.getOpcaoRetorno()== 2){
					
					venda.registroVenda(venda);
					venda.mostrarVenda(venda);
					persist.salvar(venda, venda.getVendedor().getNome());
					
					//Venda venda2 = new Venda();
					//venda2 = persist.lerObjeto("daniel");
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
				
			case 4:
				
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
				}finally {
					System.exit(0);
				}
			}
		}
	}
}