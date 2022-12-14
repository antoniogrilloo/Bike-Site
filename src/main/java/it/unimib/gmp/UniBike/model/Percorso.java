package it.unimib.gmp.UniBike.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="SEQUENZA_PERCORSO", sequenceName="SEQ_PERC")
public class Percorso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENZA_PERCORSO")
	@Column(name = "p_id")
	private Long id;
	private String data;
	private Double km;
	private Double dislivello;
	
	public Percorso() { }
	
	public Percorso(String data, double km, double dislivello) {
		this.data = data;
		this.km = km;
		this.dislivello = dislivello;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public double getDislivello() {
		return dislivello;
	}

	public void setDislivello(double dislivello) {
		this.dislivello = dislivello;
	}

	@Override
	public String toString() {
		return "Percorso [data=" + data + ", km=" + km
				+ ", dislivello=" + dislivello + "]";
	}
	

}
