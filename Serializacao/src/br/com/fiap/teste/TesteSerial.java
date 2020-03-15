package br.com.fiap.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import br.com.fiap.bean.Cliente;

public class TesteSerial {

	
	public static void main(String[] args) throws Exception {
		
		Cliente cliente = new Cliente(1, "Xurupita");
		FileOutputStream outputStream = new FileOutputStream("xurupita.txt");
		
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		
		objectOutputStream.writeObject(cliente);
		objectOutputStream.close();
	}
}
