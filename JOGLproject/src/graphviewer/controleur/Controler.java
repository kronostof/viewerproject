/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.controleur;


import graphviewer.model.Modele;
import graphviewer.model.visualisation.GraphDeVisualisation;
import graphviewer.vue.abstrVue;

/**
 *
 * @author vincent
 */
//Graph graph = null;
public class Controler {



    private Modele partieModel;
    private abstrVue partieVue;

    /**
     * initialisation du model et de la vue.
     * @param modele
     * @param vue
     */
    public Controler(Modele modele, abstrVue vue) {
        partieModel = modele;
        
        partieVue  = vue;
        
        partieVue.initControleur(this);
        partieVue.initModele(partieModel);
    }

    public GraphDeVisualisation getGraph() {
        return partieModel.getGraph();
    } 

    /** le pattern est en place une simple modification du model par cette methode déclenche
     * une fois la modification terminée une notification de tous les observateur potentiel.
     */
    public void uneModifAjouterNoeud() {
        System.out.println("Controleur : bon la vue a cafftée , puisque c'est comme ça on demande au controleur de se modifier.");
        this.partieModel.uneModif();
    }
    public void organize() {
        this.partieModel.organize();
    }
}
