package it.unimib.gmp.UniBike.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.unimib.gmp.UniBike.model.Percorso;

@Repository
public interface PercorsoRepository extends JpaRepository<Percorso, Long> {

	Optional<Percorso> findById(Long id);

	@Query(value = 
			  "SELECT p.* "
			+ "FROM Percorso p INNER JOIN Citta cp "
			+ "ON p.partenza_cit_id = cp.cit_id "
			+ "INNER JOIN Citta ca "
			+ "ON p.arrivo_cit_id = ca.cit_id "
			+ "WHERE p.ciclista_cic_id = ?1 AND (cp.nome = ?2 OR ca.nome = ?2)",
			nativeQuery = true)
	Collection<Percorso> searchByCittaECiclista(Long idCiclista, String nomeCitta);

}
