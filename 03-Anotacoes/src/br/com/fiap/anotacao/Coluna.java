package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Mant�m a anota��o at� a execu��o do programa
@Retention(RetentionPolicy.RUNTIME)
//Restringe a utiliza��o da anota��o para os atributos e m�todos
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Coluna {

	String nome();
	
	boolean obrigatorio() default false;
	
}