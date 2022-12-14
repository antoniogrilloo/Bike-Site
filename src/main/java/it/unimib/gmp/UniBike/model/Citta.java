package it.unimib.gmp.UniBike.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQUENZA_CITTA", sequenceName = "SEQ_CITT")
public class Citta {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENZA_CITTA")
	@Column(name = "cit_id")
	private Long id;
	private String nome;
	private String regione;
	
	public Citta() { }
	
	public Citta(String nome, String regione) {
		this.nome = nome;
		this.regione = regione;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	@Override
	public String toString() {
		return "Citta [nome=" + nome + ", regione=" + regione + "]";
	}
	
	
}
