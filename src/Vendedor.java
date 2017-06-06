import java.io.Serializable;
import java.util.Scanner;

public class Vendedor implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nome;
	public String id;
	public static float comissao = 10;
	public String endereco;
	
	public Vendedor registrarVendedor(Vendedor vendedor){
		Scanner leitor = new Scanner(System.in);
		System.out.println("------------------------------------------");
		System.out.println("\t\tDADOS DO VENDEDOR\n");
		System.out.println("\nNOME: ");
		vendedor.setNome(leitor.nextLine());
		System.out.println("\nID: ");
		vendedor.setId(leitor.nextLine());
		System.out.println("\nEndereço: ");
		vendedor.setEndereco(leitor.nextLine());
		
		return vendedor;
	}
	
	public void mostrarVendedor(Vendedor vendedor){
		System.out.println("------------------------------------------");
		System.out.println("\n\t\tDADOS DO VENDEDOR REGISTRADO");
		System.out.println("\nNOME: "+ vendedor.getNome());
		System.out.println("\nID: " + vendedor.getId());
		System.out.println("\nENDERECO: " + vendedor.getEndereco());
		try { Thread.sleep (3000); } catch (InterruptedException ex) {}
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getComissao() {
		return comissao;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
}
