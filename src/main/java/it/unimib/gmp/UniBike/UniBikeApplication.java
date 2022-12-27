package it.unimib.gmp.UniBike;

import java.sql.Date;
import java.sql.Time;
import java.time.Year;


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
	    	Ciclista c1 = new Ciclista("Mario", "Rossi", Date.valueOf("2000-04-09"), Disciplina.STRADISTA); 
	    	Ciclista c2 = new Ciclista("Giuseppe", "Verdi", Date.valueOf("1999-08-09"), Disciplina.RIDER); 
	    	Ciclista c3 = new Ciclista("Michele", "Neri", Date.valueOf("2000-04-09"), Disciplina.VIAGGIATORE);
			Gravel g = new Gravel("3T", "EXPLORO MAX EKAR", Year.parse("2017"), true, true);
			  
			  
			//c1.addBici(g);
			  
			c1.addSfidante(c2);
			c1.addSfidante(c3);
			c2.addSfidante(c3);
			  
			brep.save(g); 
			repository.save(c1);
			repository.save(c2); 
			repository.save(c3);
			  
			Citta t1 = new Citta("Busto Arsizio", "Lombardia"); 
			Citta t2 = new Citta("Milano", "Lombardia");
			  
			citrep.save(t1); 
			citrep.save(t2);
			  
			Percorso p = new Percorso(Date.valueOf("2022-12-23"), 25D, 2D);
			
			p.setArrivo(t2); 
			p.setPartenza(t1); 
			p.setOra_a(Time.valueOf("12:00:00")); 
			p.setOra_p(Time.valueOf("08:00:00"));
			p.setCiclista(c1);
			  
			prep.save(p);
		    
		    // fetch all customers
		    log.info("Ciclisti found with findAll():");
		    log.info("-------------------------------");
		    for (Ciclista customer : repository.findAll()) {
		    	log.info(customer.toString());
		    }
		    log.info("");
		      // fetch an individual customer by ID
			/*
			 * Optional<Collection<Ciclista>> customer = repository.findSfidaById(2L);
			 * log.info("Sfide found with findById(1L):");
			 * log.info("--------------------------------"); log.info(customer.toString());
			 * log.info("");
			 */
		    
	    };
	  }

}
