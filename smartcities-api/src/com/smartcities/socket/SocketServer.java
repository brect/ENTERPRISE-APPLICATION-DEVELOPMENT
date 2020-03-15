package com.smartcities.socket;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.smartcities.dao.ClienteDAO;
import com.smartcities.entity.Cliente;

public class SocketServer {

	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(8081);
		System.out.println("Porta 8080 aberta");
		
		Socket socket = serverSocket.accept();
		System.out.println("Nova conexão com o cliente " + socket.getInetAddress().getHostAddress());
		
		PrintWriter saida = new PrintWriter(new PrintStream(socket.getOutputStream()));
		
		saida.println("\n\n\nTecle <Enter> para iniciar");
		saida.flush();
		
		Scanner leitor = new Scanner(socket.getInputStream());
		while (leitor.hasNextLine()) {
			saida.println();
			saida.println("\n\tPesquisa por código de Cliente (0 para sair): ");
			saida.flush();
			
			System.out.println(leitor.nextLine());
			int codigoPesquisa = leitor.nextInt();
			
			if (codigoPesquisa == 0) {
				saida.close();
				socket.close();
			}
			
			saida.print("\n\tRealizando pesquisa, aguarde... ");
			saida.flush();
			
			Cliente cliente = createDAO().buscar(codigoPesquisa);
			
			if (cliente != null) {

				saida.print("\n\tRegistro encontrato " + cliente.getNome());
			} else {
				saida.print("\n\tNenhum registro encontrado");
			}
			saida.flush();
		}
		saida.close();
		leitor.close();
		socket.close();
		serverSocket.close();
		
		
	}
	
	private static ClienteDAO createDAO() {
		EntityManager entityManager = Persistence.createEntityManagerFactory("smartcities").createEntityManager();
		return new ClienteDAO(entityManager);
	}
	
}
