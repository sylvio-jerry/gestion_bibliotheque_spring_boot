package bibliotheque.entities;

import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Getter
@Setter
@Entity
@Table(name = "lecteurs")
public class Lecteurs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "num_lecteur", nullable = false)
    private String num_lecteur;

    @Column(name = "nom_lecteur", nullable = false)
    private String nom_lecteur;

    @Column(name = "prenom_lecteur")
    private String prenom_lecteur;

    @Column(name = "adresse_lecteur", nullable = false)
    private String adresse_lecteur;

    @Column(name = "telephone")
    private String telephone;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;
}
