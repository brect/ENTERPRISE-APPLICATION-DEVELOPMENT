package com.smartcities.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.smartcities.service.ClienteService;
import com.smartcities.service.ClienteServiceImpl;

public class RMIServer {

	
	public static void main(String[] args) throws Exception {
		ClienteService clienteService = new ClienteServiceImpl();
		
		ClienteService skeleton = 
		(ClienteService) UnicastRemoteObject.exportObject(clienteService, 0);
		
		Registry registry = LocateRegistry.createRegistry(8080);
		
		registry.bind("cliente", skeleton);
		
		System.out.println("Objeto remoto no ar");
	}
}
