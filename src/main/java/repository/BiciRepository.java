package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unimib.gmp.UniBike.model.Bici;

@Repository
public interface BiciRepository extends JpaRepository<Bici, Long> {

}
