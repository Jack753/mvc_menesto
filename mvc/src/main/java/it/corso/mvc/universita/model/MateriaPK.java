package it.corso.mvc.universita.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * The primary key class for the materie database table.
 * 
 */
@Embeddable
public class MateriaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="mat_id")
	private int matId;

	@Embedded
	@AttributeOverride(name="year", column=
	@Column(name="mat_anno_accademico"))
	private AnnoAccademico matAnnoAccademico;

	public MateriaPK() {
	}
	public int getMatId() {
		return this.matId;
	}
	public void setMatId(int matId) {
		this.matId = matId;
	}
	public AnnoAccademico getMatAnnoAccademico() {
		return this.matAnnoAccademico;
	}
	public void setMatAnnoAccademico(AnnoAccademico matAnnoAccademico) {
		this.matAnnoAccademico = matAnnoAccademico;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MateriaPK)) {
			return false;
		}
		MateriaPK castOther = (MateriaPK)other;
		return 
			(this.matId == castOther.matId)
			&& this.matAnnoAccademico.equals(castOther.matAnnoAccademico);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matId;
		hash = hash * prime + this.matAnnoAccademico.hashCode();
		
		return hash;
	}
}