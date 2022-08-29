package bibliotheque.repository;

import bibliotheque.entities.Lecteurs;
import bibliotheque.entities.Livres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LivresRepository extends JpaRepository<Livres, Integer>, JpaSpecificationExecutor<Livres> {
    @Transactional
    @Query(value="SELECT livres.*, ouvrages.* FROM livres JOIN ouvrages ON ouvrages.id = livres.ouvrage_id", nativeQuery = true)
    public List<Livres> getAll();
    
    String totalRetourneToday = "SELECT COUNT(*) FROM prets WHERE date_retour = CURRENT_DATE";
    @Query(value = totalRetourneToday, nativeQuery = true)
    public int totalRetourne();

    String lastElement = "SELECT * FROM livres ORDER BY id DESC LIMIT 1";
    @Query(value = lastElement, nativeQuery = true)
    public Livres getLastId();
}