package br.com.fiap.revisao.dao;

import java.util.List;
import br.com.fiap.revisao.bean.Automovel;

public interface AutomovelDao {

	void cadastrar(Automovel automovel);
	
	List<Automovel> buscarPorPlaca(String placa);
	
}