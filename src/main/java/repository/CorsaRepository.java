package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unimib.gmp.UniBike.model.Corsa;

@Repository
public interface CorsaRepository extends JpaRepository<Corsa, Long> {

}
