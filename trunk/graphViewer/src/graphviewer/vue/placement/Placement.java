/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue.placement;

import edu.uci.ics.jung.graph.Graph;
import graphviewer.vue.*;

/**
 *Classe gérant la radisposition des noeud dans la parties vue
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
