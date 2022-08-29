package bibliotheque.controllers;

import bibliotheque.dao.AjoutPret;
import bibliotheque.entities.Prets;
import bibliotheque.service.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/prets")
public class PretController {
    @Autowired
    private PretService pretService; 
    
    @GetMapping
    public Hashtable getAll(){
        return pretService.getAll();
    }
    
    @GetMapping("/{id}")
    public Hashtable getOne(@PathVariable int id){
        return pretService.getById(id);
    }
    
    @PostMapping
    public Hashtable store(@RequestBody AjoutPret req){
        return pretService.store(req);
    }
    
    @PutMapping("/{id}")
    public Hashtable update(@PathVariable int id, @RequestBody AjoutPret pret){
        return pretService.update(id, pret);
    }
    
    @DeleteMapping("/{id}")
    public Hashtable delete(@PathVariable int id){
        return pretService.delete(id);
    }
    
    @GetMapping("/total")
    public Hashtable totalPret(){
        return pretService.totalPret();
    }
}
