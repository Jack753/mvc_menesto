package it.corso.mvc.universita.dao.interfaces;

import java.util.List;

import it.corso.mvc.universita.model.CorsoDiLaurea;

public interface ICorsiDiLaureaDao {
	public List<CorsoDiLaurea> readCdlAll();

	public CorsoDiLaurea readCdlById(int id);
}
