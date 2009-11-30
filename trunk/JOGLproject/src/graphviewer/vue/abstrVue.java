/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue;

import graphviewer.controleur.Controler;
import javax.swing.JPanel;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer; // a ne pas utiliser
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import graphviewer.controleur.Controler;
import graphviewer.model.Modele;
import javax.swing.JPanel;

import java.awt.Dimension;
/**
 *
 * @author chris
 */
public abstract class abstrVue extends JFrame implements Observer,ActionListener{

    Controler controler = null;



    
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
