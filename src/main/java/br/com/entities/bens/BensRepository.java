package br.com.entities.bens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BensRepository extends JpaRepository<BensEntity, Long>{

}
