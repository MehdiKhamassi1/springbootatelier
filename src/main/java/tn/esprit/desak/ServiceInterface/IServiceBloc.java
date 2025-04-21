package tn.esprit.desak.ServiceInterface;

import tn.esprit.desak.Entity.Bloc;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Foyer;

import java.util.List;

public interface IServiceBloc {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc bloc);
    Bloc addBloc (Bloc bloc);
    Bloc retrieveBloc (long idBloc);
    void removeBloc (long idBloc);
    List<Bloc> getByUnivNom(String Nom);
    public Bloc affecterChambresABloc( List<Long> numChambre, long idBloc) ;
    public Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
