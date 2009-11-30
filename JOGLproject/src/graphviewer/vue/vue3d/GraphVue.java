/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue.vue3d;

import graphviewer.vue.VueArrete;
import graphviewer.vue.VueNoeud;
import java.util.ArrayList;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author Mathouston
 */
public class GraphVue {

    private ArrayList<VueNoeud3D> listeNoeud;

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
    private ArrayList<VueArrete3D> listeArc;

    public GraphVue(){
        listeNoeud = new ArrayList<VueNoeud3D>();
        listeArc = new ArrayList<VueArrete3D>();
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

}
