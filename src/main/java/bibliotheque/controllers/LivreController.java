package bibliotheque.controllers;

import bibliotheque.dao.AjoutLivre;
import bibliotheque.entities.Livres;
import bibliotheque.entities.Ouvrages;
import bibliotheque.service.LivreService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/livres")
public class LivreController {
    @Autowired
    private LivreService livreService;
    
    @GetMapping
    public Hashtable getAll(){
        return livreService.getAll();
    }
    @GetMapping("/{id}")
    public Hashtable getOne(@PathVariable int id){
        return livreService.getOne(id);
    }
    @PostMapping
    public Hashtable  store(@RequestBody AjoutLivre livres){
        return livreService.store(livres);
    }
    @PutMapping("/{id}")
    public Hashtable update(@PathVariable int id, @RequestBody AjoutLivre livres){
        return livreService.update(id, livres);
    }
    @DeleteMapping("/{id}")
    public Hashtable delete(@PathVariable int id){
        return livreService.delete(id);
    }
    @GetMapping("/total")
    public Hashtable getTotal(){
        return livreService.getTotalLivre();
    }
    @GetMapping("/total_retourne")
    public Hashtable getLivreRetourner(){
        return livreService.totalLivreRetourne();
    }
    @GetMapping("/last")
    public String lastID(){
        return livreService.setNumeroLivre();
    }
}
