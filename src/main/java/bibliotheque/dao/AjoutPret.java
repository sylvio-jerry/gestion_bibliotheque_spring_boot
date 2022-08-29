package bibliotheque.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class AjoutPret {
    private Date date_pret;
    private int lecteur_id; 
    private int livre_id; 
    private Date date_retour;
}
