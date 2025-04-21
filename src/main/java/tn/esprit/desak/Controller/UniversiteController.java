package tn.esprit.desak.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.desak.Entity.Universite;
import tn.esprit.desak.ServiceInterface.IServiceUniversite;

import java.util.List;

@RestController
@AllArgsConstructor
public class UniversiteController {
    IServiceUniversite serviceUniversite;
    @GetMapping("/getUniversites")
    public List<Universite> retrieveAllUniversities() {
        return serviceUniversite.retrieveAllUniversities();
    }
    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u) {
        return serviceUniversite.addUniversite(u);
    }
    @PutMapping("/UniversiteUpdate")
    public Universite updateUniversite(@RequestBody Universite u) {
        return serviceUniversite.updateUniversite(u);
    }
    @GetMapping("/universiteID/{idBloc}")
    public Universite retrieveUniversite(long idUniversite) {
        return serviceUniversite.retrieveUniversite(idUniversite);
    }
    public Universite findByFoyerCapaciteFoyerAndFoyerBlocsCapaciteBloc(long capbloc, long capfoyer) {
        return serviceUniversite.findByFoyerCapaciteFoyerAndFoyerBlocsCapaciteBloc(capbloc, capfoyer);
    }
    @PutMapping("/affecter/{idFoyer}/{nomUniversite}")
    public Universite affecterFoyerAUniversite(@PathVariable long idFoyer, @PathVariable String nomUniversite) {
        return serviceUniversite.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }
    @PutMapping("/desafecter/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return serviceUniversite.desaffecterFoyerAUniversite(idUniversite);
    }
}
