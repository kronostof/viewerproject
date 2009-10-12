/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.controleur;

import edu.uci.ics.jung.graph.Graph;
import graphviewer.vue.View;
import graphviewer.*;
import graphviewer.model.Modele;

/**
 *
 * @author vincent
 */
//Graph graph = null;
public class Controler {



    private Modele graphmodel;
    private View graphvue;

    /**
     * initialisation du model et de la vue.
     * @param modele
     * @param vue
     */
    public Controler(Modele modele, View vue) {
        graphmodel = new Modele();
        this.graphvue  = new View(this);
        this.graphvue.init(graphmodel);
    }

    public Graph getGraph() {
        return graphmodel.getGraph();
    }

    /** le pattern est en place une simple modification du model par cette methode déclenche
     * une fois la modification terminée une notification de tous les observateur potentiel.
     */
    public void uneModif() {
        System.out.println("Controleur : bon la vue a cafftée , puisque c'est comme ça on demande au controleur de se modifier.");
        this.graphmodel.uneModif();
    }
    
}
