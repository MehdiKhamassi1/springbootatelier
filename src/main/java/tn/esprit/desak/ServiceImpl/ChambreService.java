package tn.esprit.desak.ServiceImpl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.TypeC;
import tn.esprit.desak.Repository.ChambreRepository;
import tn.esprit.desak.ServiceInterface.IServiceChambre;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreService implements IServiceChambre {
    ChambreRepository ChambreRepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return ChambreRepository.findAll() ;
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return ChambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return ChambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return ChambreRepository.findById(idChambre).orElse(null);
    }

    public List<Chambre> getchambreadresseuniv(String nom){
        return ChambreRepository.findByBlocFoyerUniversiteAdresseLike(nom);
    }
    public Chambre findByReservationsEtudiantsCinAndBlocNomBlocLike(long Cin,String nomBloc){
        return ChambreRepository.findByReservationsEtudiantsCinAndBlocNomBlocLike(Cin,nomBloc);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeC typeC) {
        return ChambreRepository.findByBlocIdBlocAndTypeChambre(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return ChambreRepository.findByBlocFoyerUniversiteNomUniversiteLike(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtTypeV2(long idBloc, TypeC typeC) {
        return ChambreRepository.findByBlocIdBlocAndTypeChambrev2(idBloc,typeC);
    }

    @Override
    public List<Chambre> getChambresParNomUniversiteV2(String nomUniversite) {
        return ChambreRepository.findByBlocFoyerUniversiteNomUniversiteLikeV2(nomUniversite);
    }


}
