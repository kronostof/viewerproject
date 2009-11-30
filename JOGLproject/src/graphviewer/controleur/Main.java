/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.controleur;

import graphviewer.vue.View;
import graphviewer.vue.vue3d.Vue;
import graphviewer.model.Modele;
import graphviewer.*;
import graphviewer.vue.vue3d.View3d;

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
        View3d graphview3d = new View3d();
        new Controler(graphmodel, graphview);
        new Controler(graphmodel, graphview3d);
    }
}
