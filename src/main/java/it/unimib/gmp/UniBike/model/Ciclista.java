package it.unimib.gmp.UniBike.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQUENZA_CICLISTA", sequenceName = "SEQ_CICL")
public class Ciclista {
	
	enum Disciplina {
		RIDER,
		STRADISTA,
		VIAGGIATORE
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENZA_CICLISTA")
	@Column(name = "c_id")
	private long id;
	private String nome;
	private String cognome;
	private String nascita;
	private Disciplina disciplina;
	
	public Ciclista() { }
	
	public Ciclista(String nome, String cognome, String nascita, Disciplina disciplina) {
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
		this.disciplina = disciplina;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNascita() {
		return nascita;
	}

	public void setNascita(String nascita) {
		this.nascita = nascita;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "Ciclista [nome=" + nome + ", cognome=" + cognome + ", nascita=" + nascita
				+ ", disciplina=" + disciplina + "]";
	}
	
	

}