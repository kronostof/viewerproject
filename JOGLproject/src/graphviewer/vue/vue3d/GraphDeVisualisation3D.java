/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue.vue3d;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import graphviewer.model.visualisation.GraphDeVisualisation;
import graphviewer.vue.VueArrete;
import graphviewer.vue.VueNoeud;
import java.util.ArrayList;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author Mathouston
 */
public class GraphDeVisualisation3D extends UndirectedSparseGraph {

    private ArrayList<VueNoeud3D> listeNoeud = new ArrayList<VueNoeud3D>();
    private ArrayList<VueArrete3D> listeArc = new ArrayList<VueArrete3D>();


    public ArrayList<VueArrete3D> getListeArc() {
        return listeArc;
    }

    public ArrayList<VueNoeud3D> getListeNoeud() {
        return listeNoeud;
    }






    public Graph<VueNoeud3D,VueArrete3D> graph = new UndirectedSparseGraph();

    public GraphDeVisualisation3D(GraphDeVisualisation newGraph) {

        VueNoeud3D vn = null;
        VueArrete3D va = null;
        VueNoeud n1=null, n2=null;

        for (VueNoeud vueNoeud : newGraph.graph.getVertices()) {
            vn = new VueNoeud3D(vueNoeud);
            graph.addVertex(vn);
            listeNoeud.add(vn);
        }

        for (Object o1 : newGraph.graph.getVertices()) {
            n1 = (VueNoeud)o1;
            for (Object o2 : newGraph.graph.getVertices()) {
                n2 = (VueNoeud)o2;

                if ((newGraph.graph.findEdge(n1, n2)) != null){
                    if ( graph.findEdge(
                            getVueNoeud3DByID(n1.getId()),
                            getVueNoeud3DByID(n2.getId())
                            ) == null){
                        va = new VueArrete3D((VueArrete)(newGraph.graph.findEdge(n1,n2)),getVueNoeud3DByID(n1.getId()), getVueNoeud3DByID(n2.getId()));
                        graph.addEdge(va, getVueNoeud3DByID(n1.getId()), getVueNoeud3DByID(n2.getId()));
                        listeArc.add(va);
                    }
                }
            }
        }
    }




/*
    GraphDeVisualisation3D(GraphDeVisualisation newGraph) {

        // TODO il faut faire le tour des information contenu ds le graphe de visualidation et l'integrer ici

        // code repris honteusement dans la classe : GraphDeVisualisation
        // quel honte, trop la classe!




        VueNoeud3D vn = null;
        VueArrete3D va = null;
        VueNoeud n1=null, n2=null;

        for (Object object : newGraph.graph.getVertices()) {
            vn = new VueNoeud3D((VueNoeud)object);
            ajouterNoeud(vn);
            System.out.println(vn);
        }

        for (Object o1 : newGraph.graph.getVertices()) {
            n1 = (VueNoeud)o1;
            for (Object o2 : newGraph.graph.getVertices()) {
                n2 = (VueNoeud)o2;

                if ((newGraph.graph.findEdge(n1, n2)) != null){
                    if ( graph.findEdge(
                            getVueNoeudByID(n1.getId()),
                            getVueNoeudByID(n2.getId())
                            ) == null){
                        va = new VueArrete((ModeleArrete)(newGraph.findEdge(n1,n2)));
                        graph.addEdge(va, getVueNoeudByID(n1.getID()), getVueNoeudByID(n2.getID()));
                    }
                }
            }
        }




/ *

        VueNoeud3D nv1 = new VueNoeud3D(1.0f, 0.0f, -20.0f);
        VueNoeud3D nv2 = new VueNoeud3D(0.0f, 1.0f, -20.0f);
        VueNoeud3D nv3 = new VueNoeud3D(1.0f, 1.0f, -20.0f);
        VueNoeud3D nv4 = new VueNoeud3D(0.0f, 0.0f, -20.0f);


        VueArrete3D av1 = new VueArrete3D(nv1, nv2);
        VueArrete3D av2 = new VueArrete3D(nv1, nv3);
        VueArrete3D av3 = new VueArrete3D(nv1, nv4);


        ajouterNoeud(nv1);
        ajouterNoeud(nv2);
        ajouterNoeud(nv3);
        ajouterNoeud(nv4);

         nv1 = new VueNoeud3D(1.0f, 0.0f, -10.0f);
         nv2 = new VueNoeud3D(0.0f, 1.0f, -10.0f);
         nv3 = new VueNoeud3D(1.0f, 1.0f, -10.0f);
         nv4 = new VueNoeud3D(0.0f, 0.0f, -10.0f);

        ajouterNoeud(nv1);
        ajouterNoeud(nv2);
        ajouterNoeud(nv3);
        ajouterNoeud(nv4);


        ajouterArc(av1);
        ajouterArc(av2);
        ajouterArc(av3);
* /
    }
*/
    public void setListeArc(ArrayList<VueArrete> listeArc) {

        VueNoeud tmp,tmp1;
        /*
        for (VueArrete arc : listeArc) {
            tmp = arc.get
            this.listeArc.add(new VueArrete(tmp, tmp1));
            tmp1= tmp;
        }
        */

    }

    public void setListeNoeud(ArrayList<VueNoeud> listeNoeud) {
        for (VueNoeud noeud : listeNoeud) {
            this.listeNoeud.add(new VueNoeud3D(noeud.getX(),noeud.getY(),noeud.getZ()));
        }

    }
    

    public GraphDeVisualisation3D(){
        
        //Recupere liste NoeudModele -> NoeudVue
        VueNoeud3D nv1 = new VueNoeud3D(1.0f, 0.0f, -20.0f);
        VueNoeud3D nv2 = new VueNoeud3D(0.0f, 1.0f, -20.0f);
        VueNoeud3D nv3 = new VueNoeud3D(1.0f, 1.0f, -20.0f);
        VueNoeud3D nv4 = new VueNoeud3D(0.0f, 0.0f, -20.0f);

        VueArrete3D av1 = new VueArrete3D(nv1, nv2);
        VueArrete3D av2 = new VueArrete3D(nv1, nv3);
        VueArrete3D av3 = new VueArrete3D(nv1, nv4);


        ajouterNoeud(nv1);
        ajouterNoeud(nv2);
        ajouterNoeud(nv3);
        ajouterNoeud(nv4);
        ajouterArc(av1);
        ajouterArc(av2);
        ajouterArc(av3);

    }

    public void ajouterNoeud(VueNoeud3D nv){
        listeNoeud.add(nv);
    }

    public void ajouterArc(VueArrete3D av){
        listeArc.add(av);
    }

    public void afficher(GLAutoDrawable drawable){

        int i;

        // il faut absolument dessiner les arcs avant les noeuds... Sinon les arcs se redessinent sur les noeud (utiliser DepthTest ?)
        VueArrete3D tempAV;
        for (i=0 ;i<listeArc.size(); i++){
            tempAV = (VueArrete3D) listeArc.get(i);
            tempAV.afficher(drawable);
        }

        VueNoeud3D tempNV;
        for (i=0 ;i<listeNoeud.size(); i++){
            tempNV = (VueNoeud3D) listeNoeud.get(i);
            tempNV.afficher(drawable);
        }
        
    }


     public VueNoeud3D getVueNoeud3DByID(int id){
      VueNoeud3D vn = null;
        for (VueNoeud3D vueNoeud3D : graph.getVertices()) {
            vn = vueNoeud3D;
            if (vn.getID()== id)
                break;
        }
        return vn;
    }


}
