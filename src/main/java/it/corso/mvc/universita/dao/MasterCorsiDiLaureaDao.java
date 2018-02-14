package it.corso.mvc.universita.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import it.corso.mvc.universita.dao.interfaces.ICorsiDiLaureaDao;
import it.corso.mvc.universita.model.CorsoDiLaurea;

@Repository
public class MasterCorsiDiLaureaDao implements ICorsiDiLaureaDao {
	private Logger logger = Logger.getLogger(MasterCorsiDiLaureaDao.class);

	@PersistenceContext(unitName="corsoroma")
	private EntityManager session;

	@Override
	public List<CorsoDiLaurea> readCdlAll() {
		List<CorsoDiLaurea> cors = session
			.createQuery("FROM CorsoDiLaurea c", CorsoDiLaurea.class)
			.getResultList();
		logger.info(String.format("readCdlAll: letti %d elementi cdl", cors.size()));
		return cors;
	}
	
	@Override
	public CorsoDiLaurea readCdlById(int id) {
		CorsoDiLaurea cor = session
			.createQuery("FROM CorsoDiLaurea c"
					+ " WHERE c.cdlId = :id", CorsoDiLaurea.class)
			.setParameter("id", id)
			.getSingleResult();
		return cor;
	}
	
	@Override
	@Transactional
	public boolean removeCdl(CorsoDiLaurea cdl) {
		CorsoDiLaurea cor = session
			.createQuery("FROM CorsoDiLaurea c"
					+ " WHERE c.cdlId = :id", CorsoDiLaurea.class)
			.setParameter("id", cdl.getCdlId())
			.getSingleResult();
		session.remove(cor);
		return true;
	}
}
