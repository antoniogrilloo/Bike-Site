package it.unimib.gmp.UniBike.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.DiscriminatorType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Bici")
public class Bici {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "b_id")
	private Long id;
	private String marca;
	private String modello;
	private String anno;
	
	@ManyToMany(
		cascade = {
			CascadeType.PERSIST, 
			CascadeType.MERGE
		}
	)
	private Collection<Ciclista> ciclisti;

	public Bici() {
		this.ciclisti = new ArrayList<>();
	}
	
	public Bici(String marca, String modello, String anno) {
		this();
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
	
	public Collection<Ciclista> getCiclisti() {
		return ciclisti;
	}

	public void setCiclisti(Collection<Ciclista> ciclisti) {
		this.ciclisti = ciclisti;
	}

	@Override
	public String toString() {
		return "Bici [marca=" + marca + ", modello=" + modello + ", anno=" + anno + " classe=" + this.getClass() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bici other = (Bici) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
