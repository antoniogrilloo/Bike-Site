package it.unimib.gmp.UniBike.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MountainBike")
public class MountainBike extends Bici {

	private String forcella;
	private String ammortizzatore;
	
	public MountainBike() { }
	
	public MountainBike(String forcella, String ammortizzatore) {
		this.setForcella(forcella);
		this.setAmmortizzatore(ammortizzatore);
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
		return "[" + super.toString() + " MountainBike [forcella=" + forcella + ", ammortizzatore=" + ammortizzatore + "]";
	}
	
}
