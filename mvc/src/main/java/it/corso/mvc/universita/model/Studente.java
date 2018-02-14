package it.corso.mvc.universita.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The persistent class for the studenti database table.
 * 
 */
@Entity
@Table(name="studenti")
@NamedQuery(name="Studente.findAll", query="SELECT s FROM Studente s")
public class Studente implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name="stu_matricola")
	private int stuMatricola;

	@Column(name="stu_codice_fiscale")
	private String stuCodiceFiscale;
	
	@Size(min=2,max=25,message="{error.corso.cognome}")
	@Column(name="stu_cognome")
	private String stuCognome;

	@Temporal(TemporalType.DATE)
	@Column(name="stu_data_nascita")
	private Date stuDataNascita;
	
	@Embedded
	@AttributeOverride(name="year", column=
	@Column(name="stu_iscrizione"))
	private AnnoAccademico stuIscrizione;

	@Column(name="stu_luogo_nascita")
	private String stuLuogoNascita;

	@Size(min=2,max=25,message="Nome min lunghezza fra 2 e 25")
	@Column(name="stu_nome")
	private String stuNome;

	@NotNull(message="campo obbligatorio")
	@Column(name="stu_sesso")
	private String stuSesso;

	//bi-directional many-to-one association to Esame
	@OneToMany(mappedBy="esaStudente")
	private List<Esame> stuEsami;

	//bi-directional many-to-one association to CorsoDiLaurea
	@ManyToOne
	@JoinColumn(name="cdl_id")
	private CorsoDiLaurea stuCorsoDiLaurea;

	//bi-directional one-to-one association to Utente
	@OneToOne
	@JoinColumn(name="ute_username")
	private Utente stuUtente;

	//bi-directional many-to-many association to Materia
	@ManyToMany
	@JoinTable(
		name="studenti_materie"
		, joinColumns={
			@JoinColumn(name="stu_matricola")
			}
		, inverseJoinColumns={
			@JoinColumn(name="mat_anno_accademico", referencedColumnName="mat_anno_accademico"),
			@JoinColumn(name="mat_id", referencedColumnName="mat_id")
			}
		)
	private List<Materia> stuMaterie;
	
	
	public Studente() {
	}

	public int getStuMatricola() {
		return this.stuMatricola;
	}

	public void setStuMatricola(int stuMatricola) {
		this.stuMatricola = stuMatricola;
	}

	public String getStuCodiceFiscale() {
		return this.stuCodiceFiscale;
	}

	public void setStuCodiceFiscale(String stuCodiceFiscale) {
		this.stuCodiceFiscale = stuCodiceFiscale;
	}

	public String getStuCognome() {
		return this.stuCognome;
	}

	public void setStuCognome(String stuCognome) {
		this.stuCognome = stuCognome;
	}

	public Date getStuDataNascita() {
		return this.stuDataNascita;
	}

	public void setStuDataNascita(Date stuDataNascita) {
		this.stuDataNascita = stuDataNascita;
	}

	public AnnoAccademico getStuIscrizione() {
		return this.stuIscrizione;
	}

	public void setStuIscrizione(AnnoAccademico stuIscrizione) {
		this.stuIscrizione = stuIscrizione;
	}

	public String getStuLuogoNascita() {
		return this.stuLuogoNascita;
	}

	public void setStuLuogoNascita(String stuLuogoNascita) {
		this.stuLuogoNascita = stuLuogoNascita;
	}

	public String getStuNome() {
		return this.stuNome;
	}

	public void setStuNome(String stuNome) {
		this.stuNome = stuNome;
	}

	public String getStuSesso() {
		return this.stuSesso;
	}

	public void setStuSesso(String stuSesso) {
		this.stuSesso = stuSesso;
	}

	public List<Esame> getStuEsami() {
		return this.stuEsami;
	}

	public void setStuEsami(List<Esame> stuEsami) {
		this.stuEsami = stuEsami;
	}

	public Esame addStuEsame(Esame stuEsame) {
		getStuEsami().add(stuEsame);
		stuEsame.setEsaStudente(this);

		return stuEsame;
	}

	public Esame removeStuEsame(Esame stuEsame) {
		getStuEsami().remove(stuEsame);
		stuEsame.setEsaStudente(null);

		return stuEsame;
	}

	public CorsoDiLaurea getStuCorsoDiLaurea() {
		return this.stuCorsoDiLaurea;
	}

	public void setStuCorsoDiLaurea(CorsoDiLaurea stuCorsoDiLaurea) {
		this.stuCorsoDiLaurea = stuCorsoDiLaurea;
	}

	public Utente getStuUtente() {
		return this.stuUtente;
	}

	public void setStuUtente(Utente stuUtente) {
		this.stuUtente = stuUtente;
	}

	public List<Materia> getStuMaterie() {
		return this.stuMaterie;
	}

	public void setStuMaterie(List<Materia> stuMaterie) {
		this.stuMaterie = stuMaterie;
	}

}