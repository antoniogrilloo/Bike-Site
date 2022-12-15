package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.unimib.gmp.UniBike.model.MountainBike;

@Repository
public interface MountainBikeRepository extends JpaRepository<MountainBike, Long> {

}
