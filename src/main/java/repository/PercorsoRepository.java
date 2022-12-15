package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unimib.gmp.UniBike.model.Percorso;

@Repository
public interface PercorsoRepository extends JpaRepository<Percorso, Long> {

}
