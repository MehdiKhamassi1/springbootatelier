package tn.esprit.desak.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.desak.Entity.Bloc;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Foyer;
import tn.esprit.desak.Entity.Universite;
import tn.esprit.desak.Repository.BlocRepository;
import tn.esprit.desak.Repository.ChambreRepository;
import tn.esprit.desak.Repository.FoyerRepository;
import tn.esprit.desak.Repository.UniversiteRepository;
import tn.esprit.desak.ServiceInterface.IServiceBloc;
import tn.esprit.desak.ServiceInterface.IServiceChambre;

import java.util.List;
@Service
@AllArgsConstructor
public class BlocService implements IServiceBloc {
    private final UniversiteRepository universiteRepository;
    BlocRepository blocRepository;
    ChambreRepository chambreRepository;
    FoyerRepository foyerRepository;
    UniversiteService universiteService;
    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll() ;
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);
    }
    public List<Bloc> getByUnivNom(String Nom){
        return blocRepository.findByFoyerUniversiteNomUniversiteLike(Nom);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        List<Chambre> imed = chambreRepository.findByNumeroChambreIn(numChambre);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        for (Chambre chambre : imed) {
            chambre.setBloc(bloc);
            chambreRepository.save(chambre);
        }
        return bloc;
    }
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
      Foyer f = foyerRepository.save(foyer);
       for (Bloc bloc : f.getBlocs()) {
           bloc.setFoyer(foyer);
           blocRepository.save(bloc);
       }
       Universite u = universiteRepository.findById(idUniversite).orElse(null);
        assert u != null;
        u.setFoyer(f);
       universiteRepository.save(u);
       return f;
    }
}
