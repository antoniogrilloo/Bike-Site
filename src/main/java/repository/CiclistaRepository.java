package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unimib.gmp.UniBike.model.Ciclista;

@Repository
public interface CiclistaRepository extends JpaRepository<Ciclista, Long> {
	
}
