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
@Table(name = "ouvrages")
public class Ouvrages implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "auteur", nullable = false)
    private String auteur;

    @Column(name = "date_edition")
    private Date date_edition;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;
    
}
