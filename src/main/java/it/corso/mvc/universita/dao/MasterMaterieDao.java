package it.corso.mvc.universita.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.corso.mvc.universita.dao.interfaces.IMaterieDao;
import it.corso.mvc.universita.model.AnnoAccademico;
import it.corso.mvc.universita.model.CorsoDiLaurea;
import it.corso.mvc.universita.model.Materia;
import it.corso.mvc.universita.model.MateriaPK;

@Repository
public class MasterMaterieDao implements IMaterieDao {
	private Logger logger = Logger
			.getLogger(MasterMaterieDao.class);

	@PersistenceContext(unitName = "corsoroma")
	private EntityManager session;

	@Override
	public List<Materia> readMatByCdlIdAndAa(int cdlId,
			AnnoAccademico aa) {
		// controllo formale
		if (aa == null)
			throw new NullPointerException();
		// esecuzione
		List<Materia> mats = session
				.createQuery(
						"SELECT m" + " FROM Materia m"
								+ " WHERE m.matCorsoDiLaurea.cdlId = :id"
								+ " AND m.id.matAnnoAccademico = :aa",
						Materia.class)
				.setParameter("id", cdlId).setParameter("aa", aa)
				.getResultList();
		logger.info(String.format(
				"readMatByCdlIdAndAa(%d, %s): letti %d elementi mat",
				cdlId, aa, mats.size()));
		return mats;
	}

	@Override
	public Materia createMat(CorsoDiLaurea cdl, String matNome,
			int matCrediti, int matAnnoCorso,
			AnnoAccademico matAnnoAccademico) {
		// controllo formale
		// 1) non null
		if (cdl == null || matNome == null || matAnnoAccademico == null)
			throw new NullPointerException();
		// 2) il nome deve avere almeno 6 caratteri non blank
		if (matNome.trim().length() < 6)
			throw new IllegalArgumentException();
		// 3) crediti tra 1 e 15
		if (matCrediti < 1 || matCrediti > 15)
			throw new IllegalArgumentException();
		// 4) anno corso tra 1 e la durata del cdl
		if (matAnnoCorso < 1 || matAnnoCorso > cdl.getCdlDurata())
			throw new IllegalArgumentException();
		// esecuzione
		int maxMatId = session
				.createQuery("SELECT max(m.id.matId)"
						+ " FROM Materia m", Integer.class)
				.getSingleResult();
		int matId = maxMatId + 1;
		Materia mat = new Materia();
		MateriaPK id = new MateriaPK();
		id.setMatId(matId);
		id.setMatAnnoAccademico(matAnnoAccademico);
		mat.setId(id);
		mat.setMatCorsoDiLaurea(cdl);
		mat.setMatNome(matNome);
		mat.setMatCrediti(matCrediti);
		mat.setMatAnnoCorso(matAnnoCorso);
		mat.setMatStudenti(new ArrayList<>());
		session.persist(mat);
		logger.info(String.format(
				"createMat: creata mat con chiave %d %s", matId,
				matAnnoAccademico));
		return mat;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean deleteMat(int matId,
			AnnoAccademico matAnnoAccademico) {
		if (true) {
			// Per far vedere come funziona il metodo find
			MateriaPK id = new MateriaPK();
			id.setMatId(matId);
			id.setMatAnnoAccademico(matAnnoAccademico);
			Materia mat = session.find(Materia.class, id);
			if (mat == null) {
				return false;
			} else {
				// opzionale: controllo di integrità
				// se ho degli studenti devo restituire false
				if (!mat.getMatStudenti().isEmpty()) {
					return false;
				}
				// ora posso procedere
				session.remove(mat);
				logger.info(String.format(
						"Cancellata mat con id %d %s", matId,
						matAnnoAccademico));
				return true;
			}
		} else {
			// in alternativa si può usare JPQL
			Materia mat;
			try {
				mat = session
					.createQuery(
						"SELECT m FROM Materia m"
							+ " WHERE m.id.matId = :id"
							+ " AND m.id.matAnnoAccademico = :aa",
						Materia.class)
					.setParameter("id", matId)
					.setParameter("aa", matAnnoAccademico)
					.getSingleResult();
			} catch (NoResultException e) {
				return false;
			}
			session.remove(mat);
			logger.info(String.format(
					"Cancellata mat con id %d %s", matId,
					matAnnoAccademico));
			return true;
		}
	}

	@Override
	public List<Materia> readMatByCdlIdAaAnnoCorso(int cdlId,
			AnnoAccademico aa, int matAnnoCorso) {
		List<Materia> mats = session
			.createQuery(
				"SELECT m FROM Materia m"
					+ " WHERE m.matCorsoDiLaurea.cdlId = :id"
					+ " AND m.id.matAnnoAccademico = :aa"
					+ " AND m.matAnnoCorso = :ac",
				Materia.class)
			.setParameter("id", cdlId)
			.setParameter("aa", aa)
			.setParameter("ac", matAnnoCorso)
			.getResultList();
		logger.info(String.format(
			"readMatByCdlIdAaAnnoCorso(%d, %s, %d): letti %d elementi mat",
			cdlId, aa, matAnnoCorso, mats.size()));
		return mats;
	}
}
