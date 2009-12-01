/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue.vue3d;

import graphviewer.vue.vue2d.VueArrete;
import graphviewer.vue.vue2d.VueNoeud;
import graphviewer.vue.*;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.SpringLayout;
import edu.uci.ics.jung.visualization.BasicVisualizationServer; // a ne pas utiliser

import graphviewer.controleur.Controler;
import graphviewer.model.Modele;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import com.sun.opengl.util.Animator;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLJPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;


/**
 *
 * @author vincent
 */
public class View3d extends abstrVue implements Observer,ActionListener{

    private Animator animator;
    Controler controler = null;


    Layout<VueNoeud,VueArrete> layout = null;
    BasicVisualizationServer<VueNoeud,VueArrete> vv = null;

    private JFrame frame;
    /** bouton bidon pour tester le patern observer en modifiant le model (equivalent a une modif a la souris)
     * le model notifie qu'il est modifier, l'interface en écoutant se réaffiche (normalement !)
     */
    JButton testPatronObsv = null;
    JButton reorganiser = null;

    GraphDeVisualisation3D graph;
    private JPanel commandejpanel = new JPanel();;



    public View3d () {

        super();
        frame = new JFrame("Simple Graph View");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void initControleur (final Controler controle) {

        this.controler = controle;
        graph = new GraphDeVisualisation3D(controle.getGraph());
        graph.addObserver(this);

        frame.setLayout(new BorderLayout());
        panel = new GLJPanel(createGLCapabilites());
        panel.addGLEventListener(new GLRenderer(graph));
        panel.setPreferredSize(new Dimension(600, 600));
        animator = new Animator(panel);
        frame.add(panel, BorderLayout.CENTER);


        // TODO Ceci est un bouton bibon pour tester la mise en place du patron Observer
         testPatronObsv = new JButton("(toto) tester pattron observer");
         testPatronObsv.addActionListener(this);
         commandejpanel.add(testPatronObsv);
         //TODO : ceci est un essai de vincent pour la réorga spatiale du graphe
         reorganiser = new JButton("réorganiser");
         reorganiser.addActionListener(this);
         commandejpanel.add(reorganiser);
         frame.add(commandejpanel, BorderLayout.SOUTH);

        
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();

        frame.setVisible(true);
        
    }

    @Override
   public void initModele(Modele model) {
    model.addObserver(this); // (2) ajout d'observateur
  }


    public void update(Observable arg0, Object arg1) {

        System.out.println("Vue: mamamia je dois me réafficher !");
        frame.repaint();
     }


    void procTestPatronObsv(){
        System.out.println("Vue: ya ya to to qui qui se sent pressé !");
        System.out.println("Vue: On va tout rapporter au controleur, niark niark niark !!!");
        controler.uneModifAjouterNoeud();
    }

    void procReorganiser() {
        //demande au graph de changer la position de ses noeuds

        graph.organize();
    }



    public void actionPerformed(ActionEvent arg0) {

        if(arg0.getSource() == testPatronObsv) {
            procTestPatronObsv();
        } else if(arg0.getSource() == reorganiser) {
            procReorganiser();
        }
    }

    /*
    private void initpaneauCommande() {
        commandePanel.setLayout(new FlowLayout());
        JLabel commandeLabel = new JLabel();
        commandeLabel.setText("panneau de comande");

        commandePanel.add(commandeLabel);

        commandeLabel.setText("Below you see a GLJPanel");


         testPatronObsv = new JButton("(toto) tester pattron observer");
        // testPatronObsv.addActionListener(this);
         commandePanel.add(testPatronObsv);
         //TODO : ceci est un essai de vincent pour la réorga spatiale du graphe
         reorganiser = new JButton("réorganiser");
         //reorganiser.addActionListener(this);
         commandePanel.add(reorganiser);
    }
*/



    

    @Override
    public void setVisible(boolean show){
        if(!show)
            animator.stop();
        super.setVisible(show);
        if(!show)
            animator.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {


        JPanel commandePanel = new JPanel();
        commandePanel.setLayout(new FlowLayout());
        JLabel commandeLabel = new JLabel();


        commandePanel.add(commandeLabel);



        panel = new GLJPanel(createGLCapabilites());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        commandeLabel.setText("Below you see a GLJPanel");

        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);

        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );

        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(commandePanel))
                .addContainerGap())

        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commandePanel)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())

        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Called from within initComponents().
     * hint: to customize the generated code choose 'Customize Code' in the contextmenu
     * of the selected UI Component you wish to cutomize in design mode.
     * @return Returns customized GLCapabilities.
     */
    private GLCapabilities createGLCapabilites() {

        GLCapabilities capabilities = new GLCapabilities();
        capabilities.setHardwareAccelerated(true);

        // try to enable 2x anti aliasing - should be supported on most hardware
        capabilities.setNumSamples(2);
        capabilities.setSampleBuffers(true);

        return capabilities;
    }




// Variables declaration - do not modify//GEN-BEGIN:variables
    private GLJPanel panel;
    // End of variables declaration//GEN-END:variables
}
