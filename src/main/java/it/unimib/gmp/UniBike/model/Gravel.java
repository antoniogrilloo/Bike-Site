package it.unimib.gmp.UniBike.model;

import java.time.Year;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Gravel")
public class Gravel extends Bici{
	
	private Boolean appendici;
	private Boolean borse;
	
	public Gravel() {
		super();
	}
	
	public Gravel(String marca, String modello, Year anno, Boolean appendici, Boolean borse) {
		super(marca, modello, anno);
		this.setAppendici(appendici);
		this.setBorse(borse);
	}
	
	public Gravel(String marca, String modello, Integer anno, Boolean appendici, Boolean borse) {
		this(marca, modello, Year.parse(anno.toString()), appendici, borse);
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
		return super.toString() + " tipo: Gravel";
	}
	
}
