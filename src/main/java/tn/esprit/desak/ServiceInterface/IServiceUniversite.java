package tn.esprit.desak.ServiceInterface;

import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Universite;

import java.util.List;

public interface IServiceUniversite {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);
    Universite findByFoyerCapaciteFoyerAndFoyerBlocsCapaciteBloc(long capbloc,long capfoyer);
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    public Universite desaffecterFoyerAUniversite (long idUniversite) ;

}
