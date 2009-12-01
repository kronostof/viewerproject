/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue.vue2d;

import graphviewer.model.ModeleNoeud;
import java.awt.Color;

/**
 * Representation d'un noeud pour une visualisation en 2 dimension.
 *
 * @author chris
 */
public class VueNoeud {
    private int id = -1;
    private double x,y,z;

    /**
     * retourne la valeur de l'identifiant de l'instance.
     * @return identifiant de l'instance.
     */
    public int getId() {
        return id;
    }


    /**
     * modifie la valeur de l'identifiant de noeud.
     * @param id    nouvelle valeur de l'identifiant.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * retourne la valeur de la position en x
     * @return x.
     */
    public double getX() {
        return x;
    }
    /**
     * modifie la valeur de la position en x
     * @param x    nouvelle valeur de x.
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * retourne la valeur de la position en y
     * @return y.
     */
    public double getY() {
        return y;
    }
    /**
     * modifie la valeur de la position en y.
     * @param y    nouvelle valeur de y.
     */
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * retourne la valeur de la position en z.
     * @return z.
     */
    public double getZ() {
        return z;
    }
    /**
     * modifie la valeur de la position en z.
     * @param z    nouvelle valeur de z.
     */
    public void setZ(double z) {
        this.z = z;
    }
    
    /**
     * Attribue utilisé a des fin de test
     */
    Color couleur = null;


      public VueNoeud() {
    }
    
    /**
     * Construit un noeud a partir d'un objet {@link ModeleNoeud}
     * @param newModel {@link ModeleNoeud} utilisée pour la construction.
     */
    public VueNoeud(ModeleNoeud newModel) {
        id = newModel.getID();
        // valeur aleatoire pour les coordonnée parce que c est trop cool et trop moche
        x = Math.random()*20-10;
        y = Math.random()*20-10;
        z = -20;//Math.random()*40-40;

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
