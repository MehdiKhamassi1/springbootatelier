package tn.esprit.desak.ServiceInterface;

import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Foyer;
import tn.esprit.desak.Entity.TypeC;

import java.util.List;

public interface IServiceFoyer {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    void removeFoyer (long idFoyer);
    Foyer findgettypenombloc(TypeC t ,String nom);
}
