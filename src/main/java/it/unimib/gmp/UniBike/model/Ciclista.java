package it.unimib.gmp.UniBike.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	@Column(name = "cic_id")
	private Long id;
	private String nome;
	private String cognome;
	private String nascita;
	private Disciplina disciplina;
	
	@ManyToMany
	private Collection<Ciclista> sfida;
	
	@OneToMany(mappedBy = "ciclista")
	private Collection<Percorso> percorso;
	
	@ManyToMany
	private Collection<Bici> bici;
	
	
	public Ciclista() { }
	
	public Ciclista(String nome, String cognome, String nascita, Disciplina disciplina) {
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
		this.disciplina = disciplina;
	}

	public Long getId() {
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
