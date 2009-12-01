package graphviewer.vue.placement;


import graphviewer.vue.vue2d.VueArrete;
import graphviewer.vue.vue2d.VueNoeud;
import edu.uci.ics.jung.graph.Graph;



/**
 *Classe gérant la radisposition des noeud dans la parties vue
 *<p>
 * Dans la version actuelle de notre programme: le repositionnement des points du graph sont géré autrement.<br>
 * Cette classe reste la référence pour toutes les prochaine implémentation de classe gérant la position de noeud pour une représentation.
 * @author chris
 */
public class Placement {
         Graph<VueNoeud,VueArrete> graph = null;

        



        



        public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graphPourVue) {
        graph = graphPourVue;
    }
}
