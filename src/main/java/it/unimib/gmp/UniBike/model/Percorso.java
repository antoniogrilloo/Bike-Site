package it.unimib.gmp.UniBike.model;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Percorso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "p_id")
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date data;
	private Double km;
	private Double dislivello;
	
	@ManyToOne
	private Ciclista ciclista;
	
	@ManyToOne
	private Citta partenza;
	@ManyToOne
	private Citta arrivo;

	@Temporal(TemporalType.TIME)
	private Time ora_p;
	
	@Temporal(TemporalType.TIME)
	private Time ora_a;
	
	public Percorso() { }
	
	public Percorso(Date data, Double km, Double dislivello) {
		this.setData(data);
		this.setKm(km);
		this.setDislivello(dislivello);
	}
	
	public boolean checkSelect(Long id1, Long id2) {
		if(id1 == id2) {
			return true;
		}
		return false;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}

	public Double getDislivello() {
		return dislivello;
	}

	public void setDislivello(Double dislivello) {
		this.dislivello = dislivello;
	}

	@Override
	public String toString() {
		return "Percorso [id=" + id + ",data=" + data + ", km=" + km
				+ ", dislivello=" + dislivello + ", partenza=" + partenza
				+ ", arrivo=" + arrivo + ", ora partenza=" + ora_p
				+", ora arrivo=" + ora_a + "]";
	}
	
	public Citta getPartenza() {
		return partenza;
	}

	public void setPartenza(Citta partenza) {
		this.partenza = partenza;
	}

	public Time getOra_p() {
		return ora_p;
	}

	public void setOra_p(Time ora_p) {
		this.ora_p = ora_p;
	}
	
	public Citta getArrivo() {
		return arrivo;
	}

	public void setArrivo(Citta arrivo) {
		this.arrivo = arrivo;
	}

	public Time getOra_a() {
		return ora_a;
	}

	public void setOra_a(Time ora_a) {
		this.ora_a = ora_a;
	}

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
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
		Percorso other = (Percorso) obj;
		return Objects.equals(id, other.id);
	}
}
