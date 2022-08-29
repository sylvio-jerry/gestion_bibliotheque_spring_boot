package bibliotheque.service;

import bibliotheque.controllers.BaseController;
import bibliotheque.entities.Lecteurs;
import bibliotheque.repository.LecteursRepository;
import com.sun.jdi.event.ExceptionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LecteurService {
    @Autowired
    private LecteursRepository lecteursRepository;
    private BaseController<Lecteurs> response = new BaseController<>();

    public Hashtable getAllLecteurs() {
        try {
            return response.send("success", "Liste lecteurs", lecteursRepository.findAll());
        } catch (Exception  e){
            return response.send("error", e.getMessage());
        }
    }
    public Hashtable getLecteur(@PathVariable int id) {
        try {
            return response.send("success", "Information sur un lecteur", lecteursRepository.findById(id).get());
        } catch (Exception e){
            return response.send("error", e.getMessage());
        }
    }
    public Hashtable store(@RequestBody Lecteurs req) {
        try {
            Lecteurs lecteur = new Lecteurs();
            lecteur.setNum_lecteur(this.setNumeroLecteur());
            lecteur.setAdresse_lecteur(req.getAdresse_lecteur());
            lecteur.setNom_lecteur(req.getNom_lecteur());
            lecteur.setPrenom_lecteur(req.getPrenom_lecteur());
            lecteur.setTelephone(req.getTelephone());
            
            return response.send("success", "Ajouter avec succès", lecteursRepository.save(lecteur));
        } catch (Exception e){
            return response.send("error", e.getMessage());
        }
    }

    public Hashtable update(@PathVariable int id, @RequestBody Lecteurs lecteur) {
       try {
           Lecteurs updatedlecteur = lecteursRepository.findById(id).get();
           updatedlecteur.setNom_lecteur(lecteur.getNom_lecteur());
           updatedlecteur.setPrenom_lecteur(lecteur.getPrenom_lecteur());
           updatedlecteur.setAdresse_lecteur(lecteur.getAdresse_lecteur());
           updatedlecteur.setTelephone(lecteur.getTelephone());
           return response.send("success", "Modifier avec succès", lecteursRepository.save(updatedlecteur));
       } catch (Exception e){
           return response.send("error", e.getMessage());
       }
    }
    
    public Hashtable delete(int id){
        try {
            lecteursRepository.deleteById(id);
            return response.send("success", "Supprimer avec succès");
        } catch (Exception e){
            return response.send("error", "Erreur de la suppression");
        } 
    }
    
    public Hashtable getByNumero(){
        try {
            Lecteurs lecteurs = lecteursRepository.getLastId();
            int insertID = lecteurs.getId() + 1;
            String insertNum = "LC-" + insertID;
            return response.send("success", "Last Id", insertNum);
        } catch (Exception e){
            return response.send("error", "Erreur");
        }
    }
    
    public String setNumeroLecteur(){
        try {
            Lecteurs lecteurs = lecteursRepository.getLastId();
            int insertID = lecteurs.getId() + 1;
            String insertNum = "LC-" + insertID;
            return insertNum;
        } catch (Exception e){
            return "Erreur";
        }
    }
}

