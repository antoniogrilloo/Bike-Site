package it.unimib.gmp.UniBike.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.DiscriminatorType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Bici")
@SequenceGenerator(name = "SEQUENZA_BICI", sequenceName = "SEQ_BICI")
public class Bici {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENZA_BICI")
	@Column(name = "b_id")
	private Long id;
	private String marca;
	private String modello;
	private String anno;

	public Bici() { }
	
	public Bici(String marca, String modello, String anno) {
		this.marca = marca;
		this.modello = modello;
		this.anno = anno;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	@Override
	public String toString() {
		return "Bici [marca=" + marca + ", modello=" + modello + ", anno=" + anno + "]";
	}
	
}
