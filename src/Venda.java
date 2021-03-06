import java.awt.List;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Venda implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	public Produto produto = new Produto();
	public ArrayList<Produto> produtos = new ArrayList<>();
	public Vendedor vendedor;
	public String horas;
	public float desconto;
	public int i =0;
	public int quantidadeItens;
	public int quantidadeItensFinal;
	public float valorComissaoFinal;
	public float valorFinal;
	public float valor;
	public float valorComissao;
	
	
	
	
	public Venda registroVenda(Venda venda){
		Persist persist = new Persist();
		
		Scanner leitor = new Scanner(System.in);
		Scanner teste = new Scanner(System.in);
		Scanner teste3 = new Scanner(System.in);
	
		int x= 0;
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\nDIGITE O ID DO VENDEDOR: ");
		venda.setVendedor((Vendedor) persist.lerObjeto("vendedores/" + leitor.nextLine()));
		while(venda.getVendedor() == null){
			if(venda.getVendedor() == null){
				System.out.println("----------------------------------------------------------------------");
				System.out.println("\nDIGITE O ID DO VENDEDOR: ");
				venda.setVendedor((Vendedor) persist.lerObjeto("vendedores/" + leitor.nextLine()));
			}
		}
		
		
		while(x==0){
			
			//PEGA PRODUTO
			System.out.println("----------------------------------------------------------------------");
			System.out.println("\nDIGITE O CODIGO DO PRODUTO: ");
			venda.produto = ((Produto) persist.lerObjeto("produtos/" + leitor.nextLine()));
			while(venda.produto == null){
				if(venda.produto==null){
					System.out.println("----------------------------------------------------------------------");
					System.out.println("\nDIGITE O CODIGO DO PRODUTO: ");
					venda.produto = ((Produto) persist.lerObjeto("produtos/" + leitor.nextLine()));
				}
			}
			System.out.println("\nDIGITE A QUANTIDADE DE ITENS(no maximo 2147483647):");
			
			try{
			venda.quantidadeItens = teste.nextInt();
			}catch (InputMismatchException e) {
				venda.quantidadeItens = 1;
				System.out.println("ERRO: O valor informado e invalido!");
				System.out.println("Quantidade mudada para padrao, que e 1!");
			}
				
			if(venda.quantidadeItens < 0){
				venda.quantidadeItens *= -1;
			}
			venda.produtos.add(venda.getProduto());
			venda.calcularValor();
			venda.calcularComissao();
			
			venda.valorComissaoFinal+= venda.valorComissao;
			venda.valorFinal += venda.valor;
			venda.quantidadeItensFinal += venda.quantidadeItens;
			
			System.out.println("\n\n\n[0] SE DESEJA ADICIONAR MAIS ALGUM PRODUTO, QUALQUER TECLA PARA SAIR: ");
			try{
			x = teste3.nextInt();
			}catch (InputMismatchException e) {
				System.out.println("ERRO: Valor informado Invalido");
				x= 1;
				
			}
		}
	
		return venda;
	}
	public void efetuarDesconto(float porcentagem){
		
		try{
		desconto = (porcentagem / 100) * this.produto.getValorVenda();
		
		if(desconto<0){
			throw new ValorException("Valor invalido do desconto");
		}
		
		if((produto.getValorVenda() - desconto) < produto.getValorCusto()){
			desconto = 0;
		}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro no Desconto!");
		}finally {
			System.out.println("Finally");
		}
	}
	
	
	
	
	public float calcularValor(){
		
		this.valor = (this.produtos.get(i).getValorCusto() - this.desconto) * this.quantidadeItens;
		if (produto.getValorVenda()<0){
			throw new ValorException("O valor do Produto � Invalido!");
		}
		return valor;
	}
	
	
	public float calcularComissao(){
		
		
		if(this.produto.promocao == true){
			valorComissao = ((this.vendedor.getComissao() / 100) * getValor() / 2);
			
		}else{
			valorComissao = ((this.vendedor.getComissao() / 100) * getValor());
		}
		
		if(valorComissao<0){
			throw new ValorException("Erro, o valor da Comiss�o est� incorreto");
		}
		
		return valorComissao;
		
	}
	
		
	
	

	
	public void mostrarVenda(Venda venda){
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\tDETALHAMENTO DA VENDA");
		i=0;
		try{
		do{
			System.out.println("\nPRODUTO:" + venda.produtos.get(i).getNome() + "  PRECO:RS" + venda.produtos.get(i).getValorCusto());
			i++;
		}while(venda.getProdutos().get(i) != null);
		}catch (IndexOutOfBoundsException e) {
			System.out.println("");
		}finally {
			
		}
		System.out.println("\nVALOR TOTAL: RS" + venda.valorFinal + "\tTOTAL DE ITENS: " + venda.quantidadeItensFinal);
		System.out.println("\n\n\nVENDEDOR:"+ venda.vendedor.getNome() + "\t\tCOMISSAO: RS" + venda.valorComissaoFinal + "\tHORA DA VENDA: " + venda.horas);
		
		
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		
	}
	
	
	//GETS AND SETS

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	public void setQuantidadeItens(int quantidadeItens) {
		if(this.quantidadeItens<0){
			throw new ValorException("A quantidade de itens precisa ser Positiva!");
		}
		this.quantidadeItens = quantidadeItens;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		if(this.valor<0){
			throw new ValorException("Erro, o valor da venda est� incorreto");
		}
		this.valor = valor;
	}
	
	public float getValorComissaoFinal() {
		return valorComissaoFinal;
	}
	public void setValorComissaoFinal(float valorComissaoFinal) {
		this.valorComissaoFinal = valorComissaoFinal;
	}
	public float getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(float valorFinal) {
		this.valorFinal = valorFinal;
	}
	public int getQuantidadeItensFinal() {
		return quantidadeItensFinal;
	}
	public void setQuantidadeItensFinal(int quantidadeItensFinal) {
		this.quantidadeItensFinal = quantidadeItensFinal;
	}
	
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	
}	
	