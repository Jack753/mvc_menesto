package it.corso.mvc.universita.dao.interfaces;

import java.util.List;

import it.corso.mvc.universita.model.AnnoAccademico;
import it.corso.mvc.universita.model.CorsoDiLaurea;
import it.corso.mvc.universita.model.Studente;

public interface IStudentiDao {
	public Studente updateStu(Studente stu);

	public Studente createStu(String stuCognome, String stuNome,
			String stuSesso, AnnoAccademico stuIscrizione,
			CorsoDiLaurea stuCorsoDiLaurea);

	public Studente createIscrizione(int stuMatricola, int matId,
			AnnoAccademico matAnnoAccademico);

	List<Studente> getStudenti();

	List<Studente> getStudentiCorso(int cdl);
}
