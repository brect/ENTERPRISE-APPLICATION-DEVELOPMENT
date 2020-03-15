package com.smartcities.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.smartcities.entity.Cliente;
import com.smartcities.service.ClienteService;

public class RMIClient {

	
	public static void main(String[] args) throws Exception {
		final String ip = "192.168.15.98";
		final int port = 8080;
		
		Registry registry = LocateRegistry.getRegistry(ip, port);
		ClienteService clienteService = (ClienteService) registry.lookup("cliente");
		
		
		Cliente cliente = clienteService.buscar(1);
		
		System.out.println("id: " + cliente.getId() + " nome: " + cliente.getNome());
	}
}
