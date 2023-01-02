package it.unimib.gmp.UniBike.model;

import java.time.Year;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MountainBike")
public class MountainBike extends Bici {

	private String forcella;
	private String ammortizzatore;
	
	public MountainBike() { }
	
	public MountainBike(String marca, String modello, Year anno, String forcella, String ammortizzatore) {
		super(marca, modello, anno);
		this.setForcella(forcella);
		this.setAmmortizzatore(ammortizzatore);
	}
	
	public MountainBike(String marca, String modello, Integer anno, String forcella, String ammortizzatore) {
		this(marca, modello, Year.parse(anno.toString()), forcella, ammortizzatore);
	}

	public String getForcella() {
		return forcella;
	}
	
	public void setForcella(String forcella) {
		this.forcella = forcella;
	}
	
	public String getAmmortizzatore() {
		return ammortizzatore;
	}
	
	public void setAmmortizzatore(String ammortizzatore) {
		this.ammortizzatore = ammortizzatore;
	}
	
	@Override
	public String toString() {
		return super.toString() + " tipo: MountainBike";
	}
	
}
