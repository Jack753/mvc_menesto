package it.corso.mvc.universita.dao.interfaces;

import java.util.List;

import it.corso.mvc.universita.model.AnnoAccademico;
import it.corso.mvc.universita.model.CorsoDiLaurea;
import it.corso.mvc.universita.model.Materia;

public interface IMaterieDao {
	public List<Materia> readMatByCdlIdAndAa(int cdlId,
			AnnoAccademico aa);

	public Materia createMat(CorsoDiLaurea cdl, String matNome,
			int matCrediti, int matAnnoCorso,
			AnnoAccademico matAnnoAccademico);

	public boolean deleteMat(int matId,
			AnnoAccademico matAnnoAccademico);

	public List<Materia> readMatByCdlIdAaAnnoCorso(int cdlId,
			AnnoAccademico aa, int matAnnoCorso);
}
