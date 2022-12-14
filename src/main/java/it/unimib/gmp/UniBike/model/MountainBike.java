package it.unimib.gmp.UniBike.model;

import jakarta.persistence.Entity;

@Entity
public class MountainBike {

	private String forcella;
	private String ammortizzatore;
	
	public MountainBike() { }
	
	public MountainBike(String forcella, String ammortizzatore) {
		this.forcella = forcella;
		this.ammortizzatore = ammortizzatore;
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
		return "MountainBike [forcella=" + forcella + ", ammortizzatore=" + ammortizzatore + "]";
	}
	
}
