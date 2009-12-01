package graphviewer.controleur;

import graphviewer.model.Modele;
import graphviewer.model.visualisation.GraphDeVisualisation;
import graphviewer.vue.abstrVue;

/**
 * Controleur de l'application.
 * @author vincent
 */
public class Controler {

    /**
    * objet conservant le modele
    */
    private Modele partieModel;

    /**
    * objet conservant la vue
    */
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

    /**
     *
     * @return model du graph du programme.
     */
    public GraphDeVisualisation getGraph() {
        return partieModel.getGraph();
    } 

    
    /** le pattern est en place une simple modification du model par cette methode déclenches
     *  une fois la modification terminée une notification de tous les observateur potentiel.
     */
    public void uneModifAjouterNoeud() {
        System.out.println("Controleur : bon la vue a cafftée , puisque c'est comme ça on demande au controleur de se modifier.");
        this.partieModel.uneModif();
    }



    public void organize() {
        this.partieModel.organize();
    }
 
}
