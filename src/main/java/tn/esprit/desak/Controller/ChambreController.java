package tn.esprit.desak.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.TypeC;
import tn.esprit.desak.ServiceInterface.IServiceChambre;

import java.util.List;

@AllArgsConstructor
@RestController
@Tag(name="Gestion chanmbres")
public class ChambreController {
    IServiceChambre serviceChamber;
    @Operation(description = "list all chambres")
    @GetMapping("/getChambres")
    public List<Chambre> retrieveAllChambres() {
        return serviceChamber.retrieveAllChambres();
    }
    @PostMapping("/addChambre")
    public Chambre addChambre(@RequestBody  Chambre c) {
        return serviceChamber.addChambre(c);
    }
    @PutMapping("/chambreUpdate")
    public Chambre updateChambre(@RequestBody  Chambre c) {
        return serviceChamber.updateChambre(c);
    }
    @GetMapping("/chambreID/{idChambre}")
    public Chambre retrieveChambre(@PathVariable long idChambre) {
        return serviceChamber.retrieveChambre(idChambre);
    }
    @GetMapping("/chambres/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable long idBloc, @PathVariable TypeC typeC) {
        return serviceChamber.getChambresParBlocEtType(idBloc, typeC);
    }
    @GetMapping("/chambres/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return serviceChamber.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("/chambres2/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtTypeV2(@PathVariable long idBloc, @PathVariable TypeC typeC) {
        return serviceChamber.getChambresParBlocEtType(idBloc, typeC);
    }

    @GetMapping("/chambres2/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversiteV2(@PathVariable String nomUniversite) {
        return serviceChamber.getChambresParNomUniversiteV2(nomUniversite);
    }
}
