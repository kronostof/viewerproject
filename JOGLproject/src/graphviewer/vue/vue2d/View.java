package graphviewer.vue.vue2d;


import graphviewer.vue.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;


import graphviewer.controleur.Controler;
import javax.swing.JPanel;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout2;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import graphviewer.model.Modele;


import java.awt.Dimension;




/**
 * Classe proposant un affichage en 2 dimention d'un graphe.
 *<p>
 * Dans la version actuelle de notre programme:
 * Cette classe se repose sur l'utilisation de la librairie JUNG.<br>
 * Son implémentation a permit le développement du programme en proposant une visualisation des avancée fait a chaque étape.
 * @author vincent
 */
public class View extends abstrVue implements Observer,ActionListener{


    
    Layout<VueNoeud,VueArrete> layout = null;
    BasicVisualizationServer<VueNoeud,VueArrete> vv = null;
    JButton testPatronObsv = null;
    JButton reorganiser = null;
    JPanel jpanel1 = new JPanel();


    
    protected JFrame frame;
    
    /** bouton bidon pour tester le patern observer en modifiant le model (equivalent a une modif a la souris)
     * le model notifie qu'il est modifier, l'interface en écoutant se réaffiche (normalement !)
     */
   

    public View () {

        super();
        frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    

    public void update(Observable arg0, Object arg1) {

        System.out.println("Vue: mamamia le model m'ordonne de me réafficher !");
        // TODO rescanner le graph
        frame.repaint();
        jpanel1.repaint();
        repaint();
     }


    void procTestPatronObsv(){
        System.out.println("Vue: ya ya to to qui qui se sent pressé !");
        System.out.println("Vue: On va tout rapporter au controleur, niark niark niark !!!");
        controler.uneModifAjouterNoeud();
    }

    void procReorganiser() {
        //demande au controleur de dire au modele de se reorga en fonction de ce que je lui demande
        controler.organize();
    }



    public void actionPerformed(ActionEvent arg0) {
        
        if(arg0.getSource() == testPatronObsv) {
            procTestPatronObsv();
        } else if(arg0.getSource() == reorganiser) {
            procReorganiser();
        }
    }





    @Override
    public void initControleur (Controler controle) {

        this.controler = controle;
        
        // The Layout<V, E> is parameterized by the vertex and edge types
        layout = new SpringLayout2<VueNoeud, VueArrete>(controle.getGraph().getGraph());
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

    }

   public void initModele(Modele model) {
    model.addObserver(this); // (2) ajout d'observateur
  }
}
