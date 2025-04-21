package tn.esprit.desak.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Foyer;
import tn.esprit.desak.Entity.TypeC;

import java.lang.reflect.Type;

public interface FoyerRepository extends JpaRepository<Foyer,Long> {
    Foyer findByBlocsNomBlocAndBlocsChambresTypeChambreLike(TypeC t,String nom);
}
