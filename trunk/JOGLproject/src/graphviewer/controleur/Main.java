/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.controleur;

import graphviewer.model.Modele;

import graphviewer.vue.View;
import graphviewer.vue.vue3d.View3d;

/**
 * classe principale du programme
 *
 * @author vincent
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * objet conservant le model
         */
        Modele graphmodel = new Modele() ;


        /**
         * objet conservant la vue 2D
         */
        View graphview = new View();

        /**
         * objet conservant la vue 3D
         */
        View3d graphview3d = new View3d();

        new Controler(graphmodel, graphview);
        new Controler(graphmodel, graphview3d);
    }
}
