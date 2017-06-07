import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Persist {
	
	
	public void salvar(Serializable serializable,String nome){
		
		
		try {
			
			FileOutputStream fos = new FileOutputStream(nome);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			
			System.out.println("ERRO: Arquivo nao encontrado!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NullPointerException e) {
			System.out.println("ERRO: Objeto nao pode ser salvo NULO");
		}
	}
	
	
	public Object lerObjeto(String i){
		
		
		try {
			
			FileInputStream fis = new FileInputStream(i);
			ObjectInputStream oos = new ObjectInputStream(fis);
			Object objeto = oos.readObject();
			oos.close();
			fis.close();
			return objeto;
			
			
		} catch (FileNotFoundException e) {
			System.out.println("ERRO: O Arquivo Nao foi Encontrado");
			System.out.println("O PROGRAMA SERA ENCERRADO");
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		return null;
	}
	public void salvarVenda(Serializable serializable,String nome){
		
		
		try {
			
			FileOutputStream fos = new FileOutputStream(nome);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serializable);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}