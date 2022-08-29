package bibliotheque.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class AjoutLivre {
    private String num_livre; 
    private Boolean disponible; 
    private String titre; 
    private String auteur; 
    private Date date_edition; 
}
