package tn.esprit.desak.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.desak.Entity.Etudiant;
import tn.esprit.desak.ServiceInterface.IServiceEtudiant;

import java.util.List;


@RestController
@AllArgsConstructor
public class EtudiantController {
    IServiceEtudiant serviceEtudiant;
    @GetMapping("/getEtudiants")
    public List<Etudiant> retrieveAllEtudiants() {
        return serviceEtudiant.retrieveAllEtudiants();
    }
    @PostMapping("/addEtudiant")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants) {
        System.out.println(etudiants);
        return serviceEtudiant.addEtudiants(etudiants);
    }
    @PutMapping("/EtudiantUpdate")
    public Etudiant updateEtudiant(Etudiant e) {
        return serviceEtudiant.updateEtudiant(e);
    }
    @GetMapping("/EtudiantID/{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable long idEtudiant) {
        return serviceEtudiant.retrieveEtudiant(idEtudiant);
    }
    @DeleteMapping("/delete/{idEtudiant}")
    public void removeEtudiant(@PathVariable long idEtudiant) {
        serviceEtudiant.removeEtudiant(idEtudiant);
    }
}
