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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = { "nome", "cognome", "nascita" }) 
	}
)
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
	@JoinTable(
		name = "sfide_ciclisti",
		joinColumns = {
			@JoinColumn(name = "cic1_id")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "cic2_id")
		}
	)
	private Collection<Ciclista> sfida;

	@OneToMany(
			mappedBy = "ciclista",
			cascade = CascadeType.REMOVE
	)
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
		this();
		this.setNome(nome);
		this.setCognome(cognome);
		this.setNascita(nascita);
		this.setDisciplina(disciplina);
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
		if(!sfida.contains(c))
			this.sfida.add(c);
		if(!c.sfida.contains(this)) {
			c.sfida.add(this);
		}
	}
	
	public void deleteSfida(Ciclista c) {
		if(sfida.contains(c))
			this.sfida.remove(c);
		if(c.sfida.contains(this)) {
			c.sfida.remove(this);
		}
	}

	public void deletePercorso(Percorso p) {
		if(percorso.contains(p))
			this.percorso.remove(p);
		if(p.getCiclista().equals(this))
			p.setCiclista(null);
	}

	public void deleteBici(Bici b) {
		if(bici.contains(b))
			this.bici.remove(b);
		if(b.getCiclisti().contains(this))
			b.getCiclisti().remove(this);
	}

	public boolean isSelected(String d) {
		Disciplina disciplina = Disciplina.valueOf(d);
		if(disciplina == this.getDisciplina())
			return true;
		return false;
	}

	public Collection<Percorso> getPercorso() {
		return percorso;
	}

	public void setPercorso(Collection<Percorso> percorso) {
		this.percorso = percorso;
	}

	public void addBici(Bici b) {
		if(!this.bici.contains(b))
			this.bici.add(b);
		if(!b.getCiclisti().contains(this))
			b.getCiclisti().add(this);
	}
	
	public Collection<Ciclista> getSfida() {
		return sfida;
	}

	public Collection<Bici> getBici() {
		return bici;
	}

	public void setBici(Collection<Bici> bici) {
		this.bici = bici;
	}

	@Override
	public String toString() {
		return nome + " " + cognome + " (" + nascita + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, nascita, nome);
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
		return cognome.equals(other.cognome) && nascita.equals(other.nascita)
				&& nome.equals(other.nome);
	}

}
