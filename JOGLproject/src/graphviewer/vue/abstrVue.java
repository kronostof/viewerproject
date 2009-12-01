package graphviewer.vue;


import javax.swing.JFrame;
import graphviewer.controleur.Controler;
import graphviewer.model.Modele;

import java.awt.event.ActionListener;
import java.util.Observer;
/**
 * Classe abstraite utilisée pour implémenter tout les type de vue.<br>
 *
 * Une extension de cette classe peut être gérer par le programme afin de proposer une visualisation d'un graphe
 * 
 * @author chris
 */
public abstract class abstrVue extends JFrame implements Observer,ActionListener{



    protected Controler controler = null;


    /**
     * initialisation de la vue en fonction du controleur<br>
     * L'instance de classe controleur passé en paramètre doit avoir été initialisée <br>
     * ici ce fait la gestion des osberver
     * @param controle le controleur de l application.
     * @see Controler
     */
    public void initControleur (Controler controle) {

    }

    /**
    * initialisation de la vue en fonction du model<br>
    * L'instance de classe model passé en paramètre doit avoir été initialisée <br>
    * voir {@link Modele}
    * ici ce fait la gestion des osberver
    * @param model le model de l application.
    * @see   Controler
    * @see   Modele
    */
   public void initModele(Modele model) {
    //model.addObserver(this); // (2) ajout d'observateur
  }

   
}
