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
public class Reservation {
    @Id

    private String idReservation;
    private LocalDate anneeUniversitaire ;
    private Boolean estValide ;
    @ManyToMany
    private Set<Etudiant> etudiants;

}
