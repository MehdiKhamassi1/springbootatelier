package tn.esprit.desak.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findByFoyerCapaciteFoyerAndFoyerBlocsCapaciteBloc(long capbloc,long capfoyer);
    Universite findByNomUniversiteLike(String name);




}
