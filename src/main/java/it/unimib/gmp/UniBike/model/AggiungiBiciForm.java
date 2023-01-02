package it.unimib.gmp.UniBike.model;

import it.unimib.gmp.UniBike.exception.AggiungiBiciFormException;
import it.unimib.gmp.UniBike.model.Corsa.Misuratore;

public class AggiungiBiciForm {
	
	private String dtype;
	private Integer anno;
	private String marca;
	private String modello;
	private String forcella;
	private String ammortizzatori;
	private Boolean appendici;
	private Boolean borse;
	private String misuratore;
	private Integer ruote;
	
	public AggiungiBiciForm(String dtype, Integer anno, String marca, String modello, String forcella,
			String ammortizzatori, Boolean appendici, Boolean borse, String misuratore, Integer ruote) {
		super();
		this.dtype = dtype;
		this.anno = anno;
		this.marca = marca;
		this.modello = modello;
		this.forcella = forcella;
		this.ammortizzatori = ammortizzatori;
		this.appendici = appendici;
		this.borse = borse;
		this.misuratore = misuratore;
		this.ruote = ruote;
	}
	
	public Bici getBici() throws AggiungiBiciFormException {
		if(anno == null || marca == null || modello == null || marca.isEmpty() || modello.isEmpty())
			throw new AggiungiBiciFormException();
		Bici b = null;
		switch(this.dtype) {
			case "MountainBike":
				b = getMountainBike();
				break;
			case "Gravel":
				b = getGravel();
				break;
			case "Corsa":
				b = getCorsa();
				break;
			default:
				throw new AggiungiBiciFormException();
		}
		return b;
	}
	
	private MountainBike getMountainBike() throws AggiungiBiciFormException {
		if(forcella == null || ammortizzatori == null)
			throw new AggiungiBiciFormException();
		if(forcella.isEmpty() || ammortizzatori.isEmpty())
			throw new AggiungiBiciFormException();
		return new MountainBike(marca, modello, anno, forcella, ammortizzatori);
	}
	
	private Gravel getGravel() throws AggiungiBiciFormException {
		if(appendici == null || borse == null)
			throw new AggiungiBiciFormException();
		return new Gravel(marca, modello, anno, appendici, borse);
	}
	
	private Corsa getCorsa() throws AggiungiBiciFormException {
		if(ruote == null)
			throw new AggiungiBiciFormException();
		return new Corsa(marca, modello, anno, Misuratore.valueOf(misuratore), ruote);
	}

	@Override
	public String toString() {
		return "AggiungiBiciForm [dtype=" + dtype + ", anno=" + anno + ", marca=" + marca + ", modello=" + modello
				+ ", forcella=" + forcella + ", ammortizzatori=" + ammortizzatori + ", appendici=" + appendici
				+ ", borse=" + borse + ", misuratore=" + misuratore + ", ruote=" + ruote + "]";
	}
	
	

}
