package bibliotheque.controllers;

import bibliotheque.entities.Lecteurs;
import bibliotheque.repository.LecteursRepository;
import bibliotheque.service.LecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/lecteurs")
public class LecteurController {
    
    @Autowired
    private LecteurService lecteurService;
    @GetMapping
    public Hashtable getAllLecteurs(){
        return lecteurService.getAllLecteurs();
    }
    
    @GetMapping("/{id}")
    public Hashtable getLecteur(@PathVariable int id){
        return lecteurService.getLecteur(id);
    }

    @PostMapping
    public Hashtable store(@RequestBody Lecteurs lecteurs){
        return lecteurService.store(lecteurs);
    }

    @PutMapping("/{id}")
    public Hashtable update(@PathVariable int id, @RequestBody Lecteurs lecteur){
        return lecteurService.update(id, lecteur);
    }
    
    @DeleteMapping("/{id}")
    public Hashtable delete(@PathVariable int id){
        return lecteurService.delete(id);
    }
    
    @GetMapping("/getnumero")
    public Hashtable getByNumero() {
        return lecteurService.getByNumero();
    }
}
