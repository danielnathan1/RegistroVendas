import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Venda implements Serializable{
	
	public Produto produto = new Produto();
	public ArrayList<Produto> produtos = new ArrayList<>();
	public Vendedor vendedor;
	float desconto;
	int i =0;
	int quantidadeItens;
	int quantidadeItensFinal;
	float valorComissaoFinal;
	float valorFinal;
	float valor;
	float valorComissao;
	
	Persist persist = new Persist();
	
	Scanner leitor = new Scanner(System.in);
	Scanner teste = new Scanner(System.in);
	
	
	
	public Venda registroVenda(Venda venda){
		int x=0;
		System.out.println("\nDIGITE O ID DO VENDEDOR: ");
		venda.setVendedor((Vendedor) persist.lerObjeto("vendedores/" + leitor.nextLine()));
		
		
		while(x==0){
			
		//valor final a se pagar
			System.out.println("\nDIGITE O CODIGO DO PRODUTO: ");
			venda.produto = ((Produto) persist.lerObjeto("produtos/" + leitor.nextLine()));
			System.out.println("\nDIGITE A QUANTIDADE DE ITENS:");
			venda.quantidadeItens = teste.nextInt();
			venda.produtos.add(venda.getProduto());
			venda.calcularValor();
			venda.calcularComissao();
			
			venda.valorComissaoFinal+= venda.valorComissao;
			venda.valorFinal += venda.valor;
			venda.quantidadeItensFinal += venda.quantidadeItens;
			
			System.out.println("\n\n\n[0] SE DESEJA ADICIONAR MAIS ALGUM PRODUTO, QUALQUER TECLA PARA SAIR: ");
			x = teste.nextInt();
			
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
			throw new ValorException("O valor do Produto é Invalido!");
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
			throw new ValorException("Erro, o valor da Comissão está incorreto");
		}
		
		return valorComissao;
		
	}
	
		
	
	

	
	public void mostrarVenda(Venda venda){
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\tDETALHAMENTO DA VENDA");
		try{
		do{
			System.out.println("\nPRODUTO:" + produtos.get(i).getNome() + "  PRECO:RS" + produtos.get(i).getValorCusto());
			i++;
		}while(venda.getProdutos().get(i) != null);
		}catch (IndexOutOfBoundsException e) {
			System.out.println("");
		}finally {
			
		}
		System.out.println("\nVALOR TOTAL: RS" + venda.valorFinal + "\tTOTAL DE ITENS: " + venda.quantidadeItensFinal);
		System.out.println("\n\n\nVENDEDOR:"+ venda.vendedor.getNome() + "\t\tCOMISSAO: RS" + venda.valorComissaoFinal);
		
		
		try { Thread.sleep (3000); } catch (InterruptedException ex) {}
		
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
			throw new ValorException("Erro, o valor da venda está incorreto");
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
	
	
}	
	