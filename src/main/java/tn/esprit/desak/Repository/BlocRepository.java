package tn.esprit.desak.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.desak.Entity.Bloc;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Foyer;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc,Long> {
    List<Bloc> findByFoyerUniversiteNomUniversiteLike(String nom);

}
