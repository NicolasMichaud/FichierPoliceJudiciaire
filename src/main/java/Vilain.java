import java.util.ArrayList;

/**
 * Created by Nicolas on 06/06/2015.
 */
public class Vilain {
    //private String id;
    private String nom;
    private String prenom;
    private String delit;
    private ArrayList<String> liste = new ArrayList<String>();

    //constructeur de Vilain
    Vilain(String nom, String prenom, String delit){
        this.nom = nom;
        this.prenom = prenom;
        this.delit = delit;
        ajoutMotCle();
    }


    //permet d'ajouter chaque mot de delit dans la liste ainsi que le nom et le prenom du vilain
    public void ajoutMotCle(){
        //si nom n'est pas une chaine vide:
        if(!this.nom.equals("")){
            this.liste.add(this.nom);
        }

        //si prenom n'est pas une chaine vide:
        if(!this.prenom.equals("")){
            this.liste.add(this.prenom);
        }

        //si delit n'est pas une chaine vide:
        if (!this.delit.equals("")) {
            //split("\\s") permet de splitter selon un espace
            String[] result = delit.split("\\s");
            for (int i = 0; i < result.length; i++) {
                this.liste.add(result[i]);
            }
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDelit(String delit) {
        this.delit = delit;
    }
}
