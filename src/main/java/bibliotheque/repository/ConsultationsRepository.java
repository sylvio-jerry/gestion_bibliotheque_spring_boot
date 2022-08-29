package bibliotheque.repository;

import bibliotheque.entities.Consultations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConsultationsRepository extends JpaRepository<Consultations, Integer>, JpaSpecificationExecutor<Consultations> {

}