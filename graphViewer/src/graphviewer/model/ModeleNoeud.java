package graphviewer.model;


import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chris
 */
public class ModeleNoeud {
    int id = 0;
    int age,numSecu;
    String nom,prenom;
    Date dateDeNaissance = new Date();

    public ModeleNoeud(int id,int age,int numSecu,String nom,String prenom, Date dateDeNaissance) {

            this.id = id;
            this.age = age;
            this.numSecu=numSecu;
            this.nom=nom;
            this.prenom=prenom;
            this.dateDeNaissance = dateDeNaissance;
    }

    @Override
    public String toString() {
        return "\n noeud id = " + id ;
    }



    
}
