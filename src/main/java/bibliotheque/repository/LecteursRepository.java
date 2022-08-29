package bibliotheque.repository;

import bibliotheque.entities.Lecteurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface LecteursRepository extends JpaRepository<Lecteurs, Integer>, JpaSpecificationExecutor<Lecteurs> {
     String lastElement = "SELECT * FROM lecteurs ORDER BY id DESC LIMIT 1";
     @Query(value = lastElement, nativeQuery = true)
     public Lecteurs getLastId();
}