package it.unimib.gmp.UniBike.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unimib.gmp.UniBike.model.Percorso;

@Repository
public interface PercorsoRepository extends JpaRepository<Percorso, Long> {
	
	Optional<Percorso> findById(Long id);

}
