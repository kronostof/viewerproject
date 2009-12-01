package graphviewer.model;

/**
 * Cette classe est utilisée mour la représentation d'une arrete du graph.
 * @author chris
 */
public class ModeleArrete {

    /**
     * identifiant unique pour une instance.
     */
    int id=0;


    /**
     * Construit une arrete ayant un identifiant égal a l'entier passé en paramètre.
     * @param id    valeur de l'identifiant de l'instance créée.
     */
    public ModeleArrete(int id) {
    this.id = id ;
    }

    /**
     * retourne la valeur de l'identifiant de l'instance.
     * @return identifiant de l'instance.
     */
    public int getID() {
        return id;
    }


    /**
     * Représentation de l'instance sous forme de chaine de caractère.
     * @return arrete id = identifiant
     */
    @Override
    public String toString() {
        return "\n arrete id = " + id;
    }
}
