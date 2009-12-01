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
     * voir {@link Main}
     * ici ce fait la gestion des osberver
     * @param controle le controleur de l application.
     * @see   Controler
     */
    public void initControleur (Controler controle) {

       /* this.controler = controle;
        JPanel jpanel1 = new JPanel();
        // The Layout<V, E> is parameterized by the vertex and edge types
        layout = new SpringLayout<VueNoeud, VueArrete>(controle.getGraph().getGraph());
        layout.setSize(new Dimension(300,300)); // sets the initial size of the space
         // The BasicVisualizationServer<V,E> is parameterized by the edge types
         vv =new BasicVisualizationServer<VueNoeud,VueArrete>(layout);
         vv.setPreferredSize(new Dimension(350,350)); //Sets the viewing area size

         jpanel1.add(vv);

         // TODO Ceci est un bouton bibon pour tester la mise en place du patron Observer
         testPatronObsv = new JButton("(toto) tester pattron observer");
         testPatronObsv.addActionListener(this);
         jpanel1.add(testPatronObsv);
         //TODO : ceci est un essai de vincent pour la réorga spatiale du graphe
         reorganiser = new JButton("réorganiser");
         reorganiser.addActionListener(this);
         jpanel1.add(reorganiser);

         frame.getContentPane().add(jpanel1);
         frame.pack();
         frame.setVisible(true);
*/
    }

   public void initModele(Modele model) {
    //model.addObserver(this); // (2) ajout d'observateur
  }

   
}
