package tn.esprit.desak.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.desak.Entity.Foyer;
import tn.esprit.desak.Entity.TypeC;
import tn.esprit.desak.Repository.FoyerRepository;
import tn.esprit.desak.ServiceInterface.IServiceFoyer;

import java.util.List;
@Service
@AllArgsConstructor
public class FoyerService implements IServiceFoyer {
    FoyerRepository foyerRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    public Foyer findgettypenombloc(TypeC t , String nom){
        return foyerRepository.findByBlocsNomBlocAndBlocsChambresTypeChambreLike(t,nom);
    }
}
