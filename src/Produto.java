import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Produto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String Nome;
	public String codigo;
	public String descricao;
	public float valorVenda;
	public float valorCusto;
	//public int quantidade;
	public Boolean promocao;
	

	
	//registro de produto
	public Produto registrarProduto(Produto pro){
		
		Scanner leitor = new Scanner(System.in);
		System.out.println("------------------------------------------");
		System.out.println("\t\tDADOS DO PRODUTO\n");
		
		System.out.println("\nNOME: ");
		pro.setNome(leitor.nextLine());
		
		System.out.println("\nCODIGO DO PRODUTO: ");
		pro.setCodigo(leitor.nextLine());
		
		System.out.println("\nDESCRICAO DO PRODUTO: ");
		pro.setDescricao(leitor.nextLine());
		try{
		System.out.println("\nVALOR PARA VENDA: ");
		pro.setValorVenda(leitor.nextFloat());
		
		System.out.println("\nVALOR DO CUSTO: ");
		pro.setValorCusto(leitor.nextFloat());
		}catch (InputMismatchException e) {
			System.out.println("Erro: O valor informado � invalido\nO produto terar como valor 0 ate que seja atualizado!");
			pro.setValorVenda(0);
		}finally {
			System.out.println("");
		}
		
	
		System.out.println("\nDESCONTO [1] SE ESTIVER, [QUALQUER TECLA] SE N�O ESTIVER:");
		//x , variavel auxiliar para facilitar no boleean
		try{
		int x = leitor.nextInt();
		if(x == 1)
			pro.setPromocao(true);
		else
			pro.setPromocao(false);
		}catch (InputMismatchException e) {
			pro.setPromocao(false);
		}
			
			
		return pro;
	}
	
	public void mostraProduto(Produto pro){
		System.out.println("----------------------------------------------------------------------");
		System.out.println("\n\t\tDADOS DO PRODUTO REGISTRADO");
		System.out.println("\n\nNOME: "+ pro.getNome() + "\t\tCODIGO: " + pro.getCodigo());
		System.out.println("\nDESCRICAO:" + pro.getDescricao());
		System.out.println("\n\nVALOR PARA VENDA: " + pro.getValorVenda());
		System.out.println("\nVALOR DO CUSTO: " + pro.getValorCusto());
		System.out.println("\nPROMOCAO: ");
		if(pro.getPromocao()== true)
			System.out.println("o protudo esta em promocao");
		else
			System.out.println("O produto nao esta em promocao");
		
		try { Thread.sleep (1000); } catch (InterruptedException ex) {}
		
	}
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(float valorVenda) {
		if(this.valorVenda<0){
			throw new ValorException("O valor da Venda est� invalido!");
		}
		this.valorVenda = valorVenda;
	}

	public float getValorCusto() {

		return valorCusto;
	}

	public void setValorCusto(float valorCusto) {
		if(this.valorCusto<0){
			throw new ValorException("O valor do Custo est� invalido!");
		}
		this.valorCusto = valorCusto;
	}

	public Boolean getPromocao() {
		return promocao;
	}

	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}
	
	
}