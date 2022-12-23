package it.unimib.gmp.UniBike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniBikeApplication {
	
	//private static final Logger log = LoggerFactory.getLogger(UniBikeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(UniBikeApplication.class, args);
	}
	
	/*@Bean
	public CommandLineRunner demo(CiclistaRepository repository, CittaRepository citrep, PercorsoRepository prep, GravelRepository brep) {
	    return (args) -> {
	    	Ciclista c1 = new Ciclista("Mario", "Rossi", "29/03/2000", Disciplina.STRADISTA); 
	    	Ciclista c2 = new Ciclista("Giuseppe", "Verdi", "30/10/1960", Disciplina.RIDER); 
	    	Ciclista c3 = new Ciclista("Michele", "Neri", "11/04/2000", Disciplina.VIAGGIATORE);
			Gravel g = new Gravel("3T", "EXPLORO MAX EKAR", "2022", true, true);
			  
			  
			//c1.addBici(g);
			  
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
		    
		    // fetch all customers
		    log.info("Ciclisti found with findAll():");
		    log.info("-------------------------------");
		    for (Ciclista customer : repository.findAll()) {
		    	log.info(customer.toString());
		    }
		    log.info("");
		      // fetch an individual customer by ID
		    Optional<Collection<Ciclista>> customer = repository.findSfidaById(2L);
		    log.info("Sfide found with findById(1L):");
		    log.info("--------------------------------");
		    log.info(customer.toString());
		    log.info("");
		    
	    };
	  }*/

}
