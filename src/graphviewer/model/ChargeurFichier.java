/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.model;

/**
 *
 * @author chris
 */
public class ChargeurFichier {
    String nomFichier;

    public ChargeurFichier(String nomFichier) {
        this.nomFichier = nomFichier;
        load();
    }

    private void load() {
        throw new UnsupportedOperationException("Not yet implemented : Non mais tu crois quoi là !");
        //TODO charger reelement le fichier
    }


}
