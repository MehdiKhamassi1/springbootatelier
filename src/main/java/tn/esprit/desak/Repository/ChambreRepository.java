package tn.esprit.desak.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.desak.Entity.Chambre;
import tn.esprit.desak.Entity.TypeC;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre,Long> {
    List<Chambre> findByBlocFoyerUniversiteAdresseLike(String adresse);
    Chambre findByReservationsEtudiantsCinAndBlocNomBlocLike(long Cin,String nomBloc);
    List<Chambre> findByNumeroChambreIn(List<Long> numeroChambre);
    List<Chambre> findByBlocIdBlocAndTypeChambre(Long idBloc, TypeC typeChambre);
    List<Chambre> findByBlocFoyerUniversiteNomUniversiteLike( String nomUniversite) ;

    @Query("SELECT  C FROM Chambre C WHERE C.bloc.idBloc =:idBloc and C.typeChambre=:typeChambre")
    List<Chambre> findByBlocIdBlocAndTypeChambrev2(@Param("idBloc") Long idBloc, @Param("typeChambre") TypeC typeChambre);

    @Query("SELECT  C FROM Chambre C WHERE C.bloc.foyer.universite.nomUniversite =:nomUniversite")
    List<Chambre> findByBlocFoyerUniversiteNomUniversiteLikeV2( @Param("nomUniversite")String nomUniversite) ;
}

