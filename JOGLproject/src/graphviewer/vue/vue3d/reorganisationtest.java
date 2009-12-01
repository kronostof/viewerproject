/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue.vue3d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
class reorganisationtest extends Observable implements Runnable {

    private ArrayList<nouvelleInfo> listaModifier = new ArrayList<nouvelleInfo>();
    private final GraphDeVisualisation3D vgraph;

    reorganisationtest(GraphDeVisualisation3D graph) {
        this.vgraph = graph;
        for (VueNoeud3D vueNoeud : graph.graph.getVertices())
            listaModifier.add(new nouvelleInfo((float)Math.random()*20-10,(float)Math.random()*20-10,(float)Math.random()*20-20,vueNoeud));
    }

    @Override
    public void run() {

        boolean test = true;
        while(test){
            test = false;
            synchronized(listaModifier){
                for (nouvelleInfo info : listaModifier) {
                    if(!info.rapprocher(info))
                        listaModifier.remove(info);
                    test = true;
                }
            }
        vgraph.setData();
        }
    }




class nouvelleInfo{
    // toutes nv info utile pour la réorganisation.
    float x,y,z;
    boolean res;
    // lien vers le noeus assoicié
    VueNoeud3D noeud;
        private float marge=0.5f;

        public nouvelleInfo(float x, float y, float z, VueNoeud3D noeud) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.noeud = noeud;
        }

    public void setXYZ(float x, float y, float z){
        noeud.setXYZ(x, y, z);
    }


    private boolean rapprocher(nouvelleInfo info) {
        res=false;
        if ((noeud.getX() - x) < -marge ) {noeud.setX(noeud.getX()+0.001f);res=true;}
        if ((noeud.getX() - x) > marge ){ noeud.setX(noeud.getX()-0.001f);res=true;}

        if ((noeud.getY() - y) < -marge ){ noeud.setY(noeud.getY()+0.001f);res=true;}
        if ((noeud.getY() - y) > marge ) {noeud.setY(noeud.getY()-0.001f);res=true;}

        if ((noeud.getZ() - z) < -marge ){ noeud.setZ(noeud.getZ()+0.001f);res=true;}
        if ((noeud.getZ() - z) > marge ) {noeud.setZ(noeud.getZ()-0.001f);res=true;}

        return res;
    }


        @Override
        public String toString() {
            return "X= " + x +"Y= " + y +"Z= " + z +"\t noeud : X= " + noeud.getX() +"Y= " + noeud.getY() +"Z= " + noeud.getZ() ;
        }
}
}
