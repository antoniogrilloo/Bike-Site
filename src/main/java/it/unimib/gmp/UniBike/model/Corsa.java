package it.unimib.gmp.UniBike.model;

import jakarta.persistence.Entity;

@Entity
public class Corsa {
	
	enum Misuratore {
		SPIDER,
		PEDIVELLE,
		PEDALI
	};
	
	private Misuratore misuratore;
	private Integer ruote;
	
	public Corsa() {}
	
	public Corsa(Misuratore misuratore, Integer ruote) {
		this.misuratore = misuratore;
		this.ruote = ruote;
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
		return "Corsa [misuratore=" + misuratore + ", ruote=" + ruote + "]";
	}
	
}
