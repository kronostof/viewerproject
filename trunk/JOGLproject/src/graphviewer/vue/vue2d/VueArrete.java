package graphviewer.vue.vue2d;


import graphviewer.model.ModeleArrete;
import java.awt.Color;

/**
 * Representation d'une arrete pour une visualisation en 2 dimension.
 * 
 * @author chris
 */
public class VueArrete {

    /**
     * identifiant unique pour une instance.
     */
    private int id = -1;
    private VueNoeud n1=null,n2=null;
    /**
     * retourne la valeur de l'identifiant de l'instance.
     * @return identifiant de l'instance.
     */
    public int getId() {
        return id;
    }

    /**
     * Attribue utilisé a des fin de test
     */
    Color couleur = null;


    //TODO Ajouter l'ensemble des attributs de representation : couleur, taille , attribut composée (effet (clignote, texture ,..))
    
    // Couleur alternative
/**
 * Construit une arrete en conservant l'information indiquant quels noeuds sont relié grace a elle.
 * @param n1    noeud reliée par cet arc
 * @param n2    noeud reliée par cet arc
 */
    public VueArrete(VueNoeud n1, VueNoeud n2) {
        this.n1 = n1;
        this.n2 = n2;
        couleur = Color.red;
    }

/**
 * Construit une arrete a partir d'un objet {@link ModeleArrete} 
 * @param modeleArrete {@link ModeleArrete} utilisée pour la construction.
 */
     public VueArrete(ModeleArrete modeleArrete) {
        id = modeleArrete.getID();
    }


/**
 * Construit une arrete a partir d'un objet {@link ModeleArrete} et de deux objet {@link VueArrete}
 * en conservant l'information indiquant quels noeuds sont relié grace a elle.
 *
 * @param modeleArrete {@link ModeleArrete} utilisée pour la construction.
 * @param vueNoeud1
 * @param vueNoeud2
 */
     public VueArrete(ModeleArrete modeleArrete,VueNoeud vueNoeud1, VueNoeud vueNoeud2) {
        this.n1 = vueNoeud1;
        this.n2 = vueNoeud2;
        couleur = Color.red;
        id = modeleArrete.getID();
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
