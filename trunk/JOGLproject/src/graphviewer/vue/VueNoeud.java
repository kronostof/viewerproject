/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue;

import graphviewer.model.ModeleNoeud;
import java.awt.Color;
import java.util.Random;

/**
 *
 * @author chris
 */
public class VueNoeud {
    private int id = -1;
    private double x,y,z;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    
    // Liste des arretes liées au noeud.
    

    /**
     * Attribue utilisé a des fin de test
     */
    Color couleur = null;


    //TODO Ajouter l'ensemble des attributs de representation : couleur, taille , attribut composée (effet (clignote, texture ,..))
     
    // Couleur alternative.

    public VueNoeud() {

        

    }
    
    
    public VueNoeud(ModeleNoeud newModel) {
        id = newModel.getID();
        // valeur aleatoire pour les coordonnée parce que c est trop cool et trop moche
        x = Math.random()*20-10;
        y = Math.random()*20-10;
        z = -20;//Math.random()*40-40;

    }





    @Override
    public String toString() {
        return " noeud id = " + id +"\t" ;
    }

}
