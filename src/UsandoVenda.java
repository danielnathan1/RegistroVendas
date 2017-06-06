import java.sql.Date;
import java.text.SimpleDateFormat;
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
		
		Scanner teste = new Scanner(System.in);
		//
		Persist persist = new Persist();
		
		
		
		while(menu.getOpcao()!=4 ){
			menu.setOpcaoRetorno(2) ;
			menu.limpar();
			menu.menuPrincipal();
			switch (menu.getOpcao()) {
			case 1:
				//EFETUAR VENDA
				
				while(menu.getOpcaoRetorno()== 2){
	
					venda.registroVenda(venda);
					venda.mostrarVenda(venda);
					persist.salvar(venda, "vendas/"+ venda.getVendedor().getNome());
					menu.menuRetorno();
				
				}
				break;
				
			case 2:
				
				//REGISTRO VENDEDOR
				while(menu.getOpcaoRetorno()==2){
					
					menu.limpar();
					vendedor.registrarVendedor(vendedor);
					persist.salvar(vendedor, "vendedores/"+ vendedor.getId());
					vendedor.mostrarVendedor(vendedor);
					menu.menuRetorno();
				}
			
				
				break;
			case 3:
				
				//REGISTRAR PRODUTO
				while(menu.getOpcaoRetorno()==2){
					produto.registrarProduto(produto);
					persist.salvar(produto, "produtos/" + produto.getCodigo());
					produto.mostraProduto(produto);
					menu.menuRetorno();
					
				}
				
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("DIGITE UM VALOR VALIDO: ");
				
				break;
			}
		}
	}
	
	
	
}