package graphviewer.model;

/**
 *
 * Cette classe permettrai de charger un fichier.
 * <p>
 * Dans la version actuelle de notre programme:  Le chargeur de fichier n'est pas fonctionnel.
 * @author chris
 */
public class ChargeurFichier {

    private String nomFichier;


    /**
     * Construit le chargeur de fichier.
     *
     * @param nomFichier    nom du fichier a charger.
     */
    public ChargeurFichier() {
    }

    /**
     * Charge le fichier passé en paramètre.
     *
     * @param nomFichier    Nom du fichier passé en paramètre.
     */
    public void load(String nomFichier) {
        
        //TODO charger reelement le fichier
        this.nomFichier = nomFichier;
        throw new UnsupportedOperationException("Not yet implemented : Non mais tu crois quoi là !");
    }


}
