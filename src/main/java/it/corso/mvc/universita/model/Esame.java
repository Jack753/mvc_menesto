package it.corso.mvc.universita.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the esami database table.
 * 
 */
@Entity
@Table(name="esami")
@NamedQuery(name="Esame.findAll", query="SELECT e FROM Esame e")
public class Esame implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="esa_id")
	private int esaId;

	@Temporal(TemporalType.DATE)
	@Column(name="esa_data")
	private Date esaData;

	@Column(name="esa_lode")
	private Boolean esaLode;

	@Column(name="esa_voto")
	private Integer esaVoto;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="mat_anno_accademico", referencedColumnName="mat_anno_accademico"),
		@JoinColumn(name="mat_id", referencedColumnName="mat_id")
		})
	private Materia esaMateria;

	//bi-directional many-to-one association to Studente
	@ManyToOne
	@JoinColumn(name="stu_matricola")
	private Studente esaStudente;

	public Esame() {
	}

	public int getEsaId() {
		return this.esaId;
	}

	public void setEsaId(int esaId) {
		this.esaId = esaId;
	}

	public Date getEsaData() {
		return this.esaData;
	}

	public void setEsaData(Date esaData) {
		this.esaData = esaData;
	}

	public Boolean getEsaLode() {
		return this.esaLode;
	}

	public void setEsaLode(Boolean esaLode) {
		this.esaLode = esaLode;
	}

	public Integer getEsaVoto() {
		return this.esaVoto;
	}

	public void setEsaVoto(Integer esaVoto) {
		this.esaVoto = esaVoto;
	}

	public Materia getEsaMateria() {
		return this.esaMateria;
	}

	public void setEsaMateria(Materia esaMateria) {
		this.esaMateria = esaMateria;
	}

	public Studente getEsaStudente() {
		return this.esaStudente;
	}

	public void setEsaStudente(Studente esaStudente) {
		this.esaStudente = esaStudente;
	}

}