package it.corso.mvc.universita.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnTransformer;


/**
 * The persistent class for the utenti database table.
 * 
 */
@Entity
@Table(name="utenti")
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ute_username")
	private String uteUsername;

	@Column(name="ute_password", insertable=true, updatable=false)
	@ColumnTransformer(write="password(?)", read="null")
	private String utePassword;

	@Temporal(TemporalType.DATE)
	@Column(name="ute_scadenza_password")
	private Date uteScadenzaPassword;

	@Column(name="ute_stato")
	private String uteStato;

	//bi-directional one-to-one association to Utente
	@OneToOne(mappedBy="stuUtente")
	private Studente uteStudente;

	public Utente() {
	}

	public String getUteUsername() {
		return this.uteUsername;
	}

	public void setUteUsername(String uteUsername) {
		this.uteUsername = uteUsername;
	}

	public String getUtePassword() {
		return this.utePassword;
	}

	public void setUtePassword(String utePassword) {
		this.utePassword = utePassword;
	}

	public Date getUteScadenzaPassword() {
		return this.uteScadenzaPassword;
	}

	public void setUteScadenzaPassword(Date uteScadenzaPassword) {
		this.uteScadenzaPassword = uteScadenzaPassword;
	}

	public String getUteStato() {
		return this.uteStato;
	}

	public void setUteStato(String uteStato) {
		this.uteStato = uteStato;
	}

	public Studente getUteStudente() {
		return uteStudente;
	}

	public void setUteStudente(Studente uteStudente) {
		if (this.uteStudente != null) {
			this.uteStudente.setStuUtente(null);
		}
		this.uteStudente = uteStudente;
		uteStudente.setStuUtente(this);
	}

}