package graphviewer.model.visualisation;


import edu.uci.ics.jung.graph.*;
import graphviewer.model.ModeleNoeud;
import graphviewer.model.ModeleArrete;
import graphviewer.vue.vue2d.VueArrete;
import graphviewer.vue.vue2d.VueNoeud;
import java.util.Observable;


/**
 *  Cette classe conserve les donnée propre au graph de visualisation pour un représentation en deux dimension.
 *<p>
 * Dans la version actuelle de notre programme:
 * @author p0304320
 */
public class GraphDeVisualisation extends Observable{

    /**
     * Structure de donnée conservant les donnée du graph
     */
    public Graph<VueNoeud,VueArrete> graph = new UndirectedSparseGraph();;


    /**
     * Crée une instant a partir d'une structure de donnée {@link Graph}
     *
     * @param newGraph
     */
    public GraphDeVisualisation(Graph newGraph){

        
        VueNoeud vn = null;
        VueArrete va = null;
        ModeleNoeud n1=null, n2=null;
        
        for (Object object : newGraph.getVertices()) {
            vn = new VueNoeud((ModeleNoeud)object);
            graph.addVertex(vn);
        }
    
        for (Object o1 : newGraph.getVertices()) {
            n1 = (ModeleNoeud)o1;
            for (Object o2 : newGraph.getVertices()) {
                n2 = (ModeleNoeud)o2;
    
                if ((newGraph.findEdge(n1, n2)) != null){
                    if ( graph.findEdge(
                            getVueNoeudByID(n1.getID()),
                            getVueNoeudByID(n2.getID())
                            ) == null){
                        va = new VueArrete((ModeleArrete)(newGraph.findEdge(n1,n2)));
                        graph.addEdge(va, getVueNoeudByID(n1.getID()), getVueNoeudByID(n2.getID()));
                    }
                }
            }
        }
    }


    /**
     * Renvoi le graph conservant les informations du graph de visualisation.
     * @return la structure de donnée graph
     */
    public Graph<VueNoeud, VueArrete> getGraph() {
        return graph;
    }


    /**
     *
     * Renvoi un noeud dont l'identifiant corespond a l'identifiant passée en paramètre.
     *
     * @param id    identifiant du noeud recherché.
     * @return  le noeud recherché.
     */
    public VueNoeud getVueNoeudByID(int id){
        VueNoeud vn = null;
        for (Object object : graph.getVertices()) {
            vn = (VueNoeud)object;
            if (vn.getId() == id)
                break;
        }
        return vn;
    }

    /**
     * Représentation de l'instance sous forme de chaine de caractère.
     * @return un affichage de la structure de donnée graph en mémoire.
     */
    @Override
    public String toString() {
        return graph.toString();
    }



    // TODO cette methode est elle utilisée ?
    public void setData() {
    
        setChanged(); // Positionne son indicateur de changement
        notifyObservers(); // (1) notification

    }

    public void setData(VueNoeud nv) {
         setChanged(); // Positionne son indicateur de changement
        notifyObservers(nv); // (1) notification

    }
}
