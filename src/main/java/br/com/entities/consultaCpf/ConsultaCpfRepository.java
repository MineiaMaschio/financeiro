package br.com.entities.consultaCpf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaCpfRepository extends JpaRepository<ConsultaCpfEntity, Long>{

}
