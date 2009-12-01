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
import java.util.Observable;
import java.util.Observer;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author Mathouston
 */
public class GraphDeVisualisation3D extends Observable implements Observer{//UndirectedSparseGraph implements Observer{

    public Graph<VueNoeud3D,VueArrete3D> graph = new UndirectedSparseGraph();
    private ArrayList<VueNoeud3D> listeNoeud = new ArrayList<VueNoeud3D>();
    private ArrayList<VueArrete3D> listeArc = new ArrayList<VueArrete3D>();
    private VueNoeud3D vn;


    public ArrayList<VueArrete3D> getListeArc() {
        return listeArc;
    }

    public ArrayList<VueNoeud3D> getListeNoeud() {
        return listeNoeud;
    }






   

    public GraphDeVisualisation3D(GraphDeVisualisation newGraph) {
        newGraph.addObserver(this);

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

    public void update(Observable o, Object vueNoeud) {

System.out.println("c a  ezkfljeziofezjhiqfpoa  ezkfljeziofezjhiqfpoa  ezkfljeziofezjhiqfpo");
        if (vueNoeud != null){
         vn = new VueNoeud3D((VueNoeud)vueNoeud);
            graph.addVertex(vn);
            listeNoeud.add(vn);
        }
    }

    void organize() {
        reorganisationtest r = new reorganisationtest(this);
        Thread t = new Thread(r);


        r.addObserver(this);
        t.start();
    }


        public void setData() {

            System.out.println("c a  ezkfljeziofezjhiqfpo");
         setChanged(); // Positionne son indicateur de changement
        notifyObservers(); // (1) notification

    }

}
