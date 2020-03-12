package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//anotação utilizada somente nas classes e interfaces
@Target(ElementType.TYPE) 
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {

	String nome();
	
}






