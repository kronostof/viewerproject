/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author vincent
 */
public class View extends abstrVue implements Observer,ActionListener{


    

    
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
        frame.repaint();
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


}
