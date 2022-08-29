package bibliotheque.repository;

import bibliotheque.entities.Prets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface PretsRepository extends JpaRepository<Prets, Integer>, JpaSpecificationExecutor<Prets> {
    String totalPret = "SELECT COUNT(*) FROM prets WHERE lecteur_id = :lecteur_id AND date_retour IS NULL";
    @Query(value = totalPret, nativeQuery = true)
    public int countPretPourUnLecteur(int lecteur_id);
    
    String checkIfLivreExist = "SELECT COUNT(*) FROM prets WHERE livre_id = ?1 AND date_retour IS NULL";
    @Query(value = checkIfLivreExist, nativeQuery = true)
    public int checkIfLivreExist(int livre_id);
    
    String getLastId = "SELECT id FROM prets ORDER BY id DESC  LIMIT 1";
    @Query(value = getLastId, nativeQuery = true)
    public int getPretLastId();
}