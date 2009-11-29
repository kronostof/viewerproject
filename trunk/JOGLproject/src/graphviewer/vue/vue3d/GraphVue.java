/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue.vue3d;

import java.util.ArrayList;
import javax.media.opengl.GLAutoDrawable;

/**
 *
 * @author Mathouston
 */
public class GraphVue {

    private ArrayList<NoeudVue> listeNoeud;
    private ArrayList<ArcVue> listeArc;

    public GraphVue(){
        listeNoeud = new ArrayList<NoeudVue>();
        listeArc = new ArrayList<ArcVue>();
    }

    public void ajouterNoeud(NoeudVue nv){
        listeNoeud.add(nv);
    }

    public void ajouterArc(ArcVue av){
        listeArc.add(av);
    }

    public void afficher(GLAutoDrawable drawable){

        int i;

        // il faut absolument dessiner les arcs avant les noeuds... Sinon les arcs se redessinent sur les noeud (utiliser DepthTest ?)
        ArcVue tempAV;
        for (i=0 ;i<listeArc.size(); i++){
            tempAV = (ArcVue) listeArc.get(i);
            tempAV.afficher(drawable);
        }

        NoeudVue tempNV;
        for (i=0 ;i<listeNoeud.size(); i++){
            tempNV = (NoeudVue) listeNoeud.get(i);
            tempNV.afficher(drawable);
        }
        
    }

}
