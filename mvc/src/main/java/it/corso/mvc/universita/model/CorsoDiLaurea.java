package it.corso.mvc.universita.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


/**
 * The persistent class for the corsi_di_laurea database table.
 * 
 */
@Entity
@Table(name="corsi_di_laurea")
@NamedQuery(name="CorsoDiLaurea.findAll", query="SELECT c FROM CorsoDiLaurea c")
public class CorsoDiLaurea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cdl_id")
	@Min(value=100,message="errore")
	@Max(value=1000,message="errore")
	private int cdlId;

	@Column(name="cdl_durata")
	private int cdlDurata;

	@Column(name="cdl_nome")
	private String cdlNome;

	//bi-directional many-to-one association to Studente
	@OneToMany(mappedBy="stuCorsoDiLaurea", fetch = FetchType.EAGER)
	private List<Studente> cdlStudenti;
	
	public CorsoDiLaurea() {
	}

	public int getCdlId() {
		return this.cdlId;
	}

	public void setCdlId(int cdlId) {
		this.cdlId = cdlId;
	}

	public int getCdlDurata() {
		return this.cdlDurata;
	}

	public void setCdlDurata(int cdlDurata) {
		this.cdlDurata = cdlDurata;
	}

	public String getCdlNome() {
		return this.cdlNome;
	}

	public void setCdlNome(String cdlNome) {
		this.cdlNome = cdlNome;
	}

	public List<Studente> getCdlStudenti() {
		return this.cdlStudenti;
	}

	public void setCdlStudenti(List<Studente> cdlStudenti) {
		this.cdlStudenti = cdlStudenti;
	}

	public Studente addCdlStudente(Studente cdlStudente) {
		getCdlStudenti().add(cdlStudente);
		cdlStudente.setStuCorsoDiLaurea(this);

		return cdlStudente;
	}

	public Studente removeCdlStudente(Studente cdlStudente) {
		getCdlStudenti().remove(cdlStudente);
		cdlStudente.setStuCorsoDiLaurea(null);

		return cdlStudente;
	}

}