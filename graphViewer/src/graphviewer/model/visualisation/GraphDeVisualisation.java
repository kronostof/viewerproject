/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package graphviewer.model.visualisation;

import edu.uci.ics.jung.graph.*;
import graphviewer.model.ModeleNoeud;
import graphviewer.model.ModeleArrete;
import graphviewer.vue.VueArrete;
import graphviewer.vue.VueNoeud;
/**
 *
 * @author p0304320
 */
public class GraphDeVisualisation{

    
    Graph<VueNoeud,VueArrete> graph = new UndirectedSparseGraph();;

    public GraphDeVisualisation(Graph newGraph) {
    
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

    public Graph<VueNoeud, VueArrete> getGraph() {
        return graph;
    }


    public VueNoeud getVueNoeudByID(int id){
        VueNoeud vn = null;
        for (Object object : graph.getVertices()) {
            vn = (VueNoeud)object;
            if (vn.getId() == id)
                break;
        }
        return vn;
    }

    @Override
    public String toString() {
        return graph.toString();
    }



        // TODO methode de manipulatioon de l ensemble du graph.


        
        

}
