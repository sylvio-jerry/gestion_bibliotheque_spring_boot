package bibliotheque.service;

import bibliotheque.controllers.BaseController;
import bibliotheque.dao.AjoutPret;
import bibliotheque.entities.Lecteurs;
import bibliotheque.entities.Livres;
import bibliotheque.entities.Prets;
import bibliotheque.repository.LecteursRepository;
import bibliotheque.repository.LivresRepository;
import bibliotheque.repository.PretsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class PretService {
    @Autowired
    private PretsRepository pretsRepository;
    @Autowired
    private LecteursRepository lecteursRepository; 
    @Autowired
    private LivresRepository livresRepository;
    private BaseController<Prets> response = new BaseController<>(); 
    
    public Hashtable  getAll(){
        try {
            return response.send("success", "Lise Prêts", pretsRepository.findAll());
        } catch (Exception e){
            return response.send("error", "Liste prêts introuvable");
        }
    }
    public Hashtable getById(int id){
        try {
            return response.send("success", "Info sur un Pret", pretsRepository.findById(id).get());
        } catch (Exception e){
            return response.send("error", "Prêt introuvable");
        }
    }
    public Hashtable store(AjoutPret req){
        try {
            // total prets pour un lecteur
            int totalPret = pretsRepository.countPretPourUnLecteur(req.getLecteur_id());
            if(totalPret >= 3) return response.send("Erreur", "Nombre maximum de prêt par lecteur est égale 3");
            
            // verifier si le livre existe déjà
            int totalLivre  = pretsRepository.checkIfLivreExist(req.getLivre_id());
            if(totalLivre > 0) return response.send("Erreur", "Ce livre n'est pas disponible");
            
            // Set num pret
            String numPret = "PRET-" + Integer.toString(pretsRepository.getPretLastId());
            
            Prets pret = new Prets();
            pret.setNum_pret(numPret);
            pret.setDate_pret(req.getDate_pret());
            
            Lecteurs lecteurs = lecteursRepository.findById(req.getLecteur_id()).get();
            pret.setLecteurs(lecteurs);

            Livres livres = livresRepository.findById(req.getLivre_id()).get();
            pret.setLivres(livres);
            
            // change disponible = false and nb_pret  +=  1
            livres.setDisponible(false);
            livres.setNb_pret(livres.getNb_pret() + 1);
            livresRepository.save(livres);
            
            return response.send("success", "Ajout avec success", pretsRepository.save(pret));
        } catch (Exception e){
            return response.send("error", "Erreur de l'ajout");
        }
    }
    public Hashtable update(int id, AjoutPret req){
        try {
            Prets updatedPret = pretsRepository.findById(id).get();
            updatedPret.setDate_retour(req.getDate_retour());
            
            Livres livres = livresRepository.findById(updatedPret.getLivres().getId()).get();
            livres.setDisponible(true);
            livresRepository.save(livres);
            updatedPret.setLivres(livres);
                    
            return response.send("success", "Modification avec succès", pretsRepository.save(updatedPret));
        } catch (Exception e){
            return response.send("error", "Erreur de la modification");
        }
    }
    public Hashtable delete(int id){
        try {
            pretsRepository.deleteById(id);
            return response.send("success", "Suppression avec succès");
        }  catch (Exception e){
            return response.send("error", "Erreur de la suppression");
        }
    }
    
    public Hashtable totalPret(){
        try {
            return response.send("success", "Total de prets", pretsRepository.count());
        } catch (Exception e){
            return response.send("error", "Erreur de recuperration");  
        }
    }
}

