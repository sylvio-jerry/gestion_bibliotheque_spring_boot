package bibliotheque.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "consultations")
public class Consultations implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "livre_id", nullable = false)
    private Integer livreId;

    @Column(name = "date_cons", nullable = false)
    private Date dateCons;

    @Column(name = "heure_debut", nullable = false)
    private Time heureDebut;

    @Column(name = "heur_fin")
    private Time heurFin;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLivreId() {
        return livreId;
    }

    public void setLivreId(Integer livreId) {
        this.livreId = livreId;
    }

    public Date getDateCons() {
        return dateCons;
    }

    public void setDateCons(Date dateCons) {
        this.dateCons = dateCons;
    }

    public Time getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Time getHeurFin() {
        return heurFin;
    }

    public void setHeurFin(Time heurFin) {
        this.heurFin = heurFin;
    }
}
