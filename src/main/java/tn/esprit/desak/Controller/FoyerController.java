package tn.esprit.desak.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.desak.Entity.Foyer;
import tn.esprit.desak.Entity.TypeC;
import tn.esprit.desak.ServiceInterface.IServiceFoyer;

import java.util.List;

@RestController
@AllArgsConstructor
public class FoyerController {
    IServiceFoyer serviceFoyer;
    @GetMapping("/getFoyers")
    public List<Foyer> retrieveAllFoyers() {
        return serviceFoyer.retrieveAllFoyers();
    }
    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return serviceFoyer.addFoyer(f);
    }
    @PutMapping("/FoyerUpdate")
    public Foyer updateFoyer(@RequestBody Foyer f) {
        return serviceFoyer.updateFoyer(f);
    }
    @GetMapping("/foyerID/{idFoyer}")
    public Foyer retrieveFoyer(@PathVariable long idFoyer) {
        return serviceFoyer.retrieveFoyer(idFoyer);
    }
    @DeleteMapping("/delete/{idFoyer}")
    public void removeFoyer(@PathVariable long idFoyer) {
        serviceFoyer.removeFoyer(idFoyer);
    }

    public Foyer findgettypenombloc(TypeC t, String nom) {
        return serviceFoyer.findgettypenombloc(t, nom);
    }
}
