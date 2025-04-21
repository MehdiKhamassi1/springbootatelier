package tn.esprit.desak.ServiceInterface;

import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Etudiant;

import java.util.List;

public interface IServiceEtudiant {
    List<Etudiant> retrieveAllEtudiants();
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
}
