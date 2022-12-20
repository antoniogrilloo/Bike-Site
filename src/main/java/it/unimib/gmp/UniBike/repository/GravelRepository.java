package it.unimib.gmp.UniBike.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.unimib.gmp.UniBike.model.Gravel;

@Repository
public interface GravelRepository extends JpaRepository<Gravel, Long> {
	Optional<Gravel> findById(Long id);
}
