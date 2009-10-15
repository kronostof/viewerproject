/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.controleur;

import graphviewer.vue.View;
import graphviewer.model.Modele;
import graphviewer.*;

/**
 *
 * @author vincent
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Modele graphmodel = new Modele() ;
        View graphview = new View();
        new Controler(graphmodel, graphview);
    }
}
