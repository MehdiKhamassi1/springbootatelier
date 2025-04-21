package tn.esprit.desak.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.desak.Entity.Bloc;
import tn.esprit.desak.Entity.Foyer;
import tn.esprit.desak.ServiceInterface.IServiceBloc;

import java.util.List;

@AllArgsConstructor
@RestController
public class BlocController {
    IServiceBloc serviceBloc;
    @GetMapping("/getBlocs")
    public List<Bloc> retrieveBlocs() {
        return serviceBloc.retrieveBlocs();
    }
    @PutMapping("/blocUpdate")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return serviceBloc.updateBloc(bloc);
    }
    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return serviceBloc.addBloc(bloc);
    }
    @GetMapping("/blocID/{idBloc}")
    public Bloc retrieveBloc(@PathVariable long idBloc) {
        return serviceBloc.retrieveBloc(idBloc);
    }
    @DeleteMapping("/delete/{idBloc}")
    public void removeBloc(@PathVariable long idBloc) {
        serviceBloc.removeBloc(idBloc);
    }
    public List<Bloc> getByUnivNom(String Nom) {
        return serviceBloc.getByUnivNom(Nom);
    }
    @PutMapping("/blocup/{idBloc}")
    public Bloc affecterChambresABloc(@RequestBody List<Long> numChambre, @PathVariable long idBloc) {
        return serviceBloc.affecterChambresABloc(numChambre, idBloc);
    }
    @PostMapping("/Foyer/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return serviceBloc.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
