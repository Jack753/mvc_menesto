package it.corso.mvc.universita.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import it.corso.mvc.universita.dao.interfaces.IEsamiDao;



@Repository
public class MasterEsamiDao implements IEsamiDao {
	@PersistenceContext(unitName="corsoroma")
	private EntityManager session;

}
