package br.com.fiap.teste;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import br.com.fiap.bean.Cliente;

public class Deserializacao {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fileInputStream = new FileInputStream("xurupita.txt");
		
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		
		Cliente cliente = (Cliente) objectInputStream.readObject();
		System.out.println(cliente.getId());
		System.out.println(cliente.getNome());
		
		objectInputStream.close();
	}
	
}
