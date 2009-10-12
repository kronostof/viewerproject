/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer;

/**
 *
 * @author vincent
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Model graphmodel = null ;
        View graphview = null ;

        Controler graphcontrol = new Controler(graphmodel, graphview);
        graphview = new View(graphcontrol);

    }

}
