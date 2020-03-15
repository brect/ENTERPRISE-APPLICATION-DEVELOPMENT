package com.smartcities.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.smartcities.entity.Cliente;

public interface ClienteService extends Remote{

	Cliente buscar(int id) throws RemoteException;
	
}
