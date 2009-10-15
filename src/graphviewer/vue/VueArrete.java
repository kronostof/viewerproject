/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue;

import java.awt.Color;

/**
 *
 * @author chris
 */
class VueArrete {
    private int id = -1;
    private VueNoeud n1=null,
                     n2=null;

    /**
     * Attribue utilisé a des fin de test
     */
    Color couleur = null;


    //TODO Ajouter l'ensemble des attributs de representation : couleur, taille , attribut composée (effet (clignote, texture ,..))
    
    // Couleur alternative

    public VueArrete(VueNoeud n1, VueNoeud n2) {
        this.n1 = n1;
        this.n2 = n2;
        couleur = Color.red;
    }


}
