package br.com.fiap.revisao.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteDatas {

	public static void main(String[] args) {
		//Criar um objeto de data com a data atual
		Calendar hoje = Calendar.getInstance(); 
		Calendar carnaval = new GregorianCalendar(2020, Calendar.FEBRUARY, 25);
				
		//Formatador de datas
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		//Exibir as datas
		System.out.println(formatador.format(hoje.getTime()));
		System.out.println(formatador.format(carnaval.getTime()));
	}
	
}



