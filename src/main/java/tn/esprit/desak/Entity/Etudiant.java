package tn.esprit.desak.Entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
@ToString
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private  String nomEt ;
    private  String prenomEt ;
    private Long cin ;
    private String ecole ;
    private LocalDate dateNaissance ;
    @ManyToMany(mappedBy = "etudiants")
    private Set<Reservation> reservations;

}
