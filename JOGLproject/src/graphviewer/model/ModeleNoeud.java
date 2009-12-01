package graphviewer.model;


import java.util.Date;

/**
 * Cette classe est utilisée mour la représentation d'un noeud du graph.
 * 
 * @author chris
 */
public class ModeleNoeud {
    
    /**
     * identifiant unique pour une instance.
     */
    int id = 0;
    int age,numSecu;
    String nom,prenom;
    Date dateDeNaissance = new Date();


    /**
     * Construit un noeud ayant pour valeur ceux passe en paramètre.
     * @param id    valeur de l'identifiant de l'instance créée.
     * @param age   age
     * @param numSecu   numSecu
     * @param nom   nom
     * @param prenom    prenom
     * @param dateDeNaissance   dateDeNaissance
     */
    public ModeleNoeud(int id,int age,int numSecu,String nom,String prenom, Date dateDeNaissance) {

            this.id = id;
            this.age = age;
            this.numSecu=numSecu;
            this.nom=nom;
            this.prenom=prenom;
            this.dateDeNaissance = dateDeNaissance;
    }

    /**
     * retourne la valeur de l'identifiant de l'instance.
     * @return identifiant de l'instance.
     */
    public int getID() {
        return id;
    }


    /**
     * Représentation de l'instance sous forme de chaine de caractère.
     * @return arrete id = identifiant
     */
    @Override
    public String toString() {
        return " noeud id = " + id +"\t" ;
    }



    
}
