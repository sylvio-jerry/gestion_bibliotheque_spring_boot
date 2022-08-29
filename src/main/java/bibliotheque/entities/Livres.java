package bibliotheque.entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Setter
@Getter
@Entity
@DynamicInsert
@Table(name = "livres")
public class Livres implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "num_livre", nullable = false)
    private String num_livre;
    
    @Column(name = "disponible", nullable = false)
    @ColumnDefault("1")
    private Boolean disponible;
    
    @Column(name = "nb_pret", nullable = true)
    @ColumnDefault("0")
    private Integer nb_pret;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ouvrage_id")
    private Ouvrages ouvrages; 
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;
}
