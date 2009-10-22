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
        //TODO pour chaque noeud on cree un objet VueNoeud

        VueNoeud vn = null;
        for (Object object : newGraph.getVertices()) {
            vn = new VueNoeud((ModeleNoeud)object);
            graph.addVertex(vn);
            //ajoute dans le graphe
        }


        VueArrete va = null;
        int nbredge  = newGraph.getEdgeCount();


        

        //TODO pour chaque arrete on cree un objet VueArrete relier correctement !

     /*
        for (Object n1 : newGraph.getVertices()) {
            for (Object n2 : newGraph.getVertices()) {
                
                if ((newGraph.findEdge((ModeleNoeud)n1,(ModeleNoeud) n2)) != null){
                    va = new VueArrete(
                            (ModeleArrete)(newGraph.findEdge((ModeleNoeud)n1,(ModeleNoeud) n2)),
                            getVueNoeudByID(((ModeleNoeud)n1).getID()),
                            getVueNoeudByID(((ModeleNoeud)n2).getID())
                            );
                    graph.addEdge(va, vn, vn, arg3);
                }
                va = new VueArrete((ModeleArrete)object);

            }
        }

*/
        // AFFICHAGE DU GRAPH DE VISUALISATION
        System.out.println(graph);
    }

    public Graph<VueNoeud, VueArrete> getGraph() {
        return graph;
    }





/*

    public VueNoeud getVueDuNoeud(ModeleNoeud){
        return
    }
*/

/*
    
    public void addArret(ModeleArrete art,ModeleNoeud n1 , ModeleNoeud n2 ) {
       // TODO faire le noeud de visualisation
        VueArrete newNoeud = new VueArrete(art);


        
        graph.addEdge(newNoeud, graph.getvn1, n2);
    }

    public void addNoeud(ModeleNoeud n1) {

        // TODO faire le noeud de visualisation
        VueNoeud newNoeud = new VueNoeud(n1);



        
        graph.addVertex(newNoeud);
    }
*/

        // TODO methode de manipulatioon de l ensemble du graph.


        
        

}
