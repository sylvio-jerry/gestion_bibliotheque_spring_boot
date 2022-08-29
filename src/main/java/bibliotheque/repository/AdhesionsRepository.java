package bibliotheque.repository;

import bibliotheque.entities.Adhesions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdhesionsRepository extends JpaRepository<Adhesions, Integer>, JpaSpecificationExecutor<Adhesions> {

}