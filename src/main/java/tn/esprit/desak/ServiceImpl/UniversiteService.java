package tn.esprit.desak.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.desak.Entity.Foyer;
import tn.esprit.desak.Entity.Universite;
import tn.esprit.desak.Repository.FoyerRepository;
import tn.esprit.desak.Repository.UniversiteRepository;
import tn.esprit.desak.ServiceInterface.IServiceUniversite;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteService implements IServiceUniversite {
    UniversiteRepository universiterepository;
    FoyerRepository foyerrepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiterepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiterepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiterepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiterepository.findById(idUniversite).orElse(null);
    }
    public Universite findByFoyerCapaciteFoyerAndFoyerBlocsCapaciteBloc(long capbloc,long capfoyer){
        return universiterepository.findByFoyerCapaciteFoyerAndFoyerBlocsCapaciteBloc(capbloc,capfoyer);
    }
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite u = universiterepository.findByNomUniversiteLike(nomUniversite);
        Foyer f = foyerrepository.findById(idFoyer).orElse(null);
        u.setFoyer(f);
        return universiterepository.save(u);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite u = universiterepository.findById(idUniversite).orElse(null);
        u.setFoyer(null);
        return universiterepository.save(u);
    }


}
