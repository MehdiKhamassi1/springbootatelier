package tn.esprit.desak.ServiceInterface;

import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.TypeC;

import java.util.List;

public interface IServiceChambre {
    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);
    List<Chambre> getchambreadresseuniv(String nom);
    Chambre findByReservationsEtudiantsCinAndBlocNomBlocLike(long Cin,String nomBloc);
    public List<Chambre> getChambresParBlocEtType (long idBloc, TypeC typeC) ;
    public List<Chambre> getChambresParNomUniversite( String nomUniversite) ;

    public List<Chambre> getChambresParBlocEtTypeV2 (long idBloc, TypeC typeC) ;

    public List<Chambre> getChambresParNomUniversiteV2(String nomUniversite);
}
