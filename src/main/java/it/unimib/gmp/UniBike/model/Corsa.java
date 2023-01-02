package it.unimib.gmp.UniBike.model;

import java.time.Year;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Corsa")
public class Corsa extends Bici {
	
	public enum Misuratore {
		SPIDER,
		PEDIVELLE,
		PEDALI
	};
	
	private Misuratore misuratore;
	private Integer ruote;
	
	public Corsa() {}
	
	public Corsa(String marca, String modello, Year anno, Misuratore misuratore, Integer ruote) {
		super(marca, modello, anno);
		this.setMisuratore(misuratore);
		this.setRuote(ruote);
	}
	
	public Corsa(String marca, String modello, Integer anno, Misuratore misuratore, Integer ruote) {
		this(marca, modello, Year.parse(anno.toString()), misuratore, ruote);
	}

	public Misuratore getMisuratore() {
		return misuratore;
	}
	
	public void setMisuratore(Misuratore misuratore) {
		this.misuratore = misuratore;
	}
	
	public Integer getRuote() {
		return ruote;
	}
	
	public void setRuote(Integer ruote) {
		this.ruote = ruote;
	}

	@Override
	public String toString() {
		return super.toString() + " tipo: Corsa";
	}
	
}
