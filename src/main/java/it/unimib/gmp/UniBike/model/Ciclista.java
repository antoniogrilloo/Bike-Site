package it.unimib.gmp.UniBike.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Ciclista {
	
	public enum Disciplina {
		RIDER,
		STRADISTA,
		VIAGGIATORE
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cic_id")
	private Long id;
	private String nome;
	private String cognome;
	@Temporal(TemporalType.DATE)
	private Date nascita;
	private Disciplina disciplina;
	
	@ManyToMany(
		cascade = {
				CascadeType.PERSIST, 
				CascadeType.MERGE
		}
	)
	private Collection<Ciclista> sfida;
	
	@OneToMany(mappedBy = "ciclista")
	private Collection<Percorso> percorso;
	
	@ManyToMany(
		cascade = {
			CascadeType.MERGE
		}
	)
	private Collection<Bici> bici;
	
	public Ciclista() {
		this.bici = new ArrayList<>();
		this.percorso = new ArrayList<>();
		this.sfida = new ArrayList<>();
	}
	
	public Ciclista(String nome, String cognome, Date nascita, Disciplina disciplina) {
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
		this.disciplina = disciplina;
		this.bici = new ArrayList<>();
		this.percorso = new ArrayList<>();
		this.sfida = new ArrayList<>();
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

	public Date getNascita() {
		return nascita;
	}

	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	public void addSfidante(Ciclista c) {
		this.sfida.add(c);
		if(!c.sfida.contains(this)) {
			c.sfida.add(this);
		}
	}

	public void addBici(Bici b) {
		this.bici.add(b);
		if(!b.getCiclisti().contains(this)) {
			b.getCiclisti().add(this);
		}
	}
	
	@Override
	public String toString() {
		return "Ciclista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", nascita=" + nascita
				+ ", disciplina=" + disciplina + "]";
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
		Ciclista other = (Ciclista) obj;
		return Objects.equals(id, other.id);
	}

}
