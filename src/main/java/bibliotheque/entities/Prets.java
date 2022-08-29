package bibliotheque.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "prets")
public class Prets implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "num_pret")
    private String num_pret;

    @Column(name = "date_pret", nullable = false)
    private Date date_pret;

    @Column(name = "date_retour")
    private Date date_retour;

    @ManyToOne
    @JoinColumn(name = "lecteur_id")
    private Lecteurs lecteurs;

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livres livres;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;
    
}
