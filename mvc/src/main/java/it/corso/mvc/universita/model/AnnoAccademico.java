package it.corso.mvc.universita.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Embeddable;

/**
 * Implementazione immutabile di un anno accademico.
 * 
 * @author Achille
 *
 */
@Embeddable
public class AnnoAccademico implements Serializable {
	private static final long serialVersionUID = 5485174155665589986L;

	private int year;
	
	public AnnoAccademico() {
		this.year = new GregorianCalendar().get(Calendar.YEAR);
	}
	
	public AnnoAccademico(int anno) {
		this.year = anno;
	}
	
	public int getAnno() {
		return year;
	}
	
	public AnnoAccademico next() {
		return new AnnoAccademico(getAnno() + 1);
	}
	
	public AnnoAccademico previous() {
		return new AnnoAccademico(getAnno() - 1);
	}

	@Override
	public int hashCode() {
		return getAnno();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj instanceof AnnoAccademico) {
			AnnoAccademico other = (AnnoAccademico) obj;
			return this.getAnno() == other.getAnno();
		}
		return false;
	}

	@Override
	public String toString() {
		int anno = getAnno();
		return (anno - 1) + "/" + anno;
	}
}
