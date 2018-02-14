package it.corso.mvc.universita.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import it.corso.mvc.universita.dao.interfaces.IUtentiDao;



@Repository
public class MasterUtentiDao implements IUtentiDao {
	@PersistenceContext(unitName="corsoroma")
	private EntityManager session;

}
