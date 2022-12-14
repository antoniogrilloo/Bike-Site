package it.unimib.gmp.UniBike.model;

import jakarta.persistence.Entity;

@Entity
public class Gravel {
	
	private Boolean appendici;
	private Boolean borse;
	
	public Gravel() {}
	
	public Gravel(Boolean appendici, Boolean borse) {
		this.appendici = appendici;
		this.borse = borse;
	}
	
	public Boolean getAppendici() {
		return appendici;
	}
	
	public void setAppendici(Boolean appendici) {
		this.appendici = appendici;
	}
	
	public Boolean getBorse() {
		return borse;
	}
	
	public void setBorse(Boolean borse) {
		this.borse = borse;
	}
	
	@Override
	public String toString() {
		return "Gravel [appendici=" + appendici + ", borse=" + borse + "]";
	}
	
}
