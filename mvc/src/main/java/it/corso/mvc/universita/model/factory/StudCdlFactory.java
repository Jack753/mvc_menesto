package it.corso.mvc.universita.model.factory;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import it.corso.mvc.universita.model.CorsoDiLaurea;
import it.corso.mvc.universita.model.Studente;

@Component
public class StudCdlFactory {

	@Valid
	private Studente stu;
	
	private List<CorsoDiLaurea> cdl ;
	private String id;
	
	public Studente getStu() {
		return stu;
	}
	public void setStu(Studente stu) {
		this.stu = stu;
	}
	public List<CorsoDiLaurea> getCdl() {
		return cdl;
	}
	public void setCdl(List<CorsoDiLaurea> cdl) {
		this.cdl = cdl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
