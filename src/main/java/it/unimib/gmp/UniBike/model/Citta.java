package it.unimib.gmp.UniBike.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Citta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cit_id")
	private Long id;
	private String nome;
	private String regione;
	
	public Citta() { }
	
	public Citta(String nome, String regione) {
		this.setNome(nome);
		this.setRegione(regione);
	}

	public Long getId() {
		return id;
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
		Citta other = (Citta) obj;
		return Objects.equals(id, other.id);
	}
}
