package bibliotheque.service;

import bibliotheque.controllers.BaseController;
import bibliotheque.dao.AjoutLivre;
import bibliotheque.entities.Lecteurs;
import bibliotheque.entities.Livres;
import bibliotheque.entities.Ouvrages;
import bibliotheque.entities.Prets;
import bibliotheque.repository.LecteursRepository;
import bibliotheque.repository.LivresRepository;
import bibliotheque.repository.OuvragesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.NoSuchElementException;

@Service
public class LivreService {
    @Autowired
    private LivresRepository livresRepository;
    @Autowired
    private OuvragesRepository ouvragesRepository;
    private BaseController<Livres> response = new BaseController<>();
    
    public Hashtable getAll(){
        try {
            return response.send("success", "Liste des livres", livresRepository.findAll());
        }  catch (Exception e){
            return response.send("error", e.getMessage());
        }
    }
    
    public Hashtable getOne(int id){
        try {
            return response.send("success", "Info sur un livre", livresRepository.findById(id).get());
        } catch (Exception e){
            return response.send("error", e.getMessage());
        }
    }
    public Hashtable store(AjoutLivre req){
        try {
            Ouvrages ouvrages = new Ouvrages(); 
            ouvrages.setTitre(req.getTitre());
            ouvrages.setAuteur(req.getAuteur());
            ouvrages.setDate_edition(req.getDate_edition());
            
            Livres livres = new Livres(); 
            livres.setNum_livre(this.setNumeroLivre());
            livres.setDisponible(req.getDisponible());
            livres.setOuvrages(ouvrages);
            
            return response.send("success", "ajout avec succes", livresRepository.save(livres));
        } catch (Exception e){
            return response.send("error", e.getMessage());
        }
    }
    public Hashtable update(int id, AjoutLivre req){
        try {
            Livres updatedLivres = livresRepository.findById(id).get();

            Ouvrages ouvrages = ouvragesRepository.findById(updatedLivres.getOuvrages().getId()).get();
            ouvrages.setTitre(req.getTitre());
            ouvrages.setAuteur(req.getAuteur());
            ouvrages.setDate_edition(req.getDate_edition());
            
            updatedLivres.setNum_livre(this.setNumeroLivre());
            updatedLivres.setDisponible(req.getDisponible());
            updatedLivres.setOuvrages(ouvrages); 
            
            return response.send("success", "Modification avec success", livresRepository.save(updatedLivres));
        } catch (Exception e){
            return response.send("error", e.getMessage());
        }
    } 
    public Hashtable delete(int id){
        try {
            livresRepository.deleteById(id);
            return response.send("success", "Suppression avec succès");
        } catch (Exception e){
            return response.send("error", e.getMessage()); 
        }
    }
    public Hashtable getTotalLivre(){
        try {
            return response.send("success", "Nombre total des livre", livresRepository.count());
        } catch (Exception e){
            return response.send("Error", "Erreur de la recuperation de données");
        }
    }
    public Hashtable totalLivreRetourne(){
        try {
            return response.send("success", "Total livres retournées", livresRepository.totalRetourne());
        } catch (Exception e){
            return response.send("error", "Erreur de la récuperation de données");
        }
    }
    public String setNumeroLivre(){
        try {
            Livres livre = livresRepository.getLastId();
            int insertID = livre.getId() + 1;
            String insertNum = "LIV-" + insertID;
            return insertNum;
        } catch (Exception e){
            return "Erreur";
        }
    }
}
