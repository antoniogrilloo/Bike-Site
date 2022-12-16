package it.unimib.gmp.UniBike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unimib.gmp.UniBike.model.Gravel;

@Repository
public interface GravelRepository extends JpaRepository<Gravel, Long> {

}
