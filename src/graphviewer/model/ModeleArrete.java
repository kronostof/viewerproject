/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.model;

/**
 *
 * @author chris
 */
public class ModeleArrete {
    int id=0;

    public ModeleArrete(int id) {
    this.id = id ;
    }

    @Override
    public String toString() {
        return "\n arrete id = " + id;
    }




}
