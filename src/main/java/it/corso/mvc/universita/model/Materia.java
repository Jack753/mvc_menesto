package it.corso.mvc.universita.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the materie database table.
 * 
 */
@Entity
@Table(name = "materie")
@NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MateriaPK id;

	@Column(name = "mat_anno_corso")
	private int matAnnoCorso;

	@Column(name = "mat_crediti")
	private int matCrediti;

	@Column(name = "mat_nome")
	private String matNome;

	// bi-directional many-to-one association to Esame
	@OneToMany(mappedBy = "esaMateria")
	private List<Esame> matEsami;

	// uni-directional many-to-one association to CorsoDiLaurea
	@ManyToOne
	@JoinColumn(name = "cdl_id")
	private CorsoDiLaurea matCorsoDiLaurea;

	// bi-directional many-to-many association to Studente
	@ManyToMany(mappedBy = "stuMaterie")
	private List<Studente> matStudenti;

	public Materia() {
	}

	public MateriaPK getId() {
		return this.id;
	}

	public void setId(MateriaPK id) {
		this.id = id;
	}

	public int getMatAnnoCorso() {
		return this.matAnnoCorso;
	}

	public void setMatAnnoCorso(int matAnnoCorso) {
		this.matAnnoCorso = matAnnoCorso;
	}

	public int getMatCrediti() {
		return this.matCrediti;
	}

	public void setMatCrediti(int matCrediti) {
		this.matCrediti = matCrediti;
	}

	public String getMatNome() {
		return this.matNome;
	}

	public void setMatNome(String matNome) {
		this.matNome = matNome;
	}

	public List<Esame> getMatEsami() {
		return this.matEsami;
	}

	public void setMatEsami(List<Esame> matEsami) {
		this.matEsami = matEsami;
	}

	public Esame addMatEsame(Esame matEsame) {
		getMatEsami().add(matEsame);
		matEsame.setEsaMateria(this);

		return matEsame;
	}

	public Esame removeMatEsame(Esame matEsame) {
		getMatEsami().remove(matEsame);
		matEsame.setEsaMateria(null);

		return matEsame;
	}

	public CorsoDiLaurea getMatCorsoDiLaurea() {
		return this.matCorsoDiLaurea;
	}

	public void setMatCorsoDiLaurea(
			CorsoDiLaurea matCorsoDiLaurea) {
		this.matCorsoDiLaurea = matCorsoDiLaurea;
	}

	public List<Studente> getMatStudenti() {
		return this.matStudenti;
	}

	public void setMatStudenti(List<Studente> matStudenti) {
		this.matStudenti = matStudenti;
	}

	public Studente addMatStudente(Studente matStudente) {
		getMatStudenti().add(matStudente);
		matStudente.getStuMaterie().add(this);

		return matStudente;
	}

	public Studente removeMatStudente(Studente matStudente) {
		getMatStudenti().remove(matStudente);
		matStudente.getStuMaterie().remove(this);

		return matStudente;
	}

}