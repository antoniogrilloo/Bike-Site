package it.unimib.gmp.UniBike;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.unimib.gmp.UniBike.model.Ciclista;
import it.unimib.gmp.UniBike.model.Ciclista.Disciplina;
import it.unimib.gmp.UniBike.model.Citta;
import it.unimib.gmp.UniBike.model.Gravel;
import it.unimib.gmp.UniBike.model.Percorso;
import it.unimib.gmp.UniBike.repository.CiclistaRepository;
import it.unimib.gmp.UniBike.repository.CittaRepository;
import it.unimib.gmp.UniBike.repository.GravelRepository;
import it.unimib.gmp.UniBike.repository.PercorsoRepository;

@SpringBootApplication
public class UniBikeApplication {
	
	private static final Logger log = LoggerFactory.getLogger(UniBikeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UniBikeApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CiclistaRepository repository, CittaRepository citrep, PercorsoRepository prep, GravelRepository brep) {
	    return (args) -> {
	    	Ciclista c1 = new Ciclista("Mario", "Rossi", "29/03/2000", Disciplina.STRADISTA);
	    	Ciclista c2 = new Ciclista("Giuseppe", "Verdi", "30/10/1960", Disciplina.RIDER);
	    	Ciclista c3 = new Ciclista("Michele", "Neri", "11/04/2000", Disciplina.VIAGGIATORE);
	    	
	    	Gravel g = new Gravel("3T", "EXPLORO MAX EKAR", "2022", true, true);
		    
		    
		    c1.addBici(g);
	    	
	    	c1.addSfidante(c2);
	    	c2.addSfidante(c3);
	    	
	    	brep.save(g);
	    	repository.save(c1);
		    repository.save(c2);
		    repository.save(c3);
		    
		    Citta t1 = new Citta("Busto Arsizio", "Lombardia");
		    Citta t2 = new Citta("Milano", "Lombardia");
		   
		    citrep.save(t1);
		    citrep.save(t2);
		    
		    Percorso p = new Percorso("25/11/2020", 25D, 2D);
		    
		    p.setArrivo(t2);
		    p.setPartenza(t1);
		    p.setOra_a("12:00");
		    p.setOra_p("08:00");
		    p.setCiclista(c1);
		    
		    prep.save(p);
		    
		    
		    Optional<Ciclista> cic = repository.findById(1L);
	    	Optional<Gravel> b = brep.findById(1L);
	    	if(!cic.isEmpty() && !b.isEmpty()) {
	    		//cic.get().addBici(b.get());
	    	}
		    
		    // fetch all customers
		    log.info("Ciclisti found with findAll():");
		    log.info("-------------------------------");
		    for (Ciclista customer : repository.findAll()) {
		      log.info(customer.toString());
		    }
		    log.info("");
		      // fetch an individual customer by ID
		    Optional<Ciclista> customer = repository.findById(13L);
		    log.info("Customer found with findById(1L):");
		    log.info("--------------------------------");
		    log.info(customer.toString());
		    log.info("");
	
	    };
	  }

}
