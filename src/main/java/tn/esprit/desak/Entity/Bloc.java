package tn.esprit.desak.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Builder
@ToString
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idBloc;
    private String nomBloc ;
    private Long capaciteBloc ;
    @JsonIgnore
    @ManyToOne
    private  Foyer foyer;
    @JsonIgnore
    @OneToMany(mappedBy = "bloc")
    private Set<Chambre> chambres;
}
