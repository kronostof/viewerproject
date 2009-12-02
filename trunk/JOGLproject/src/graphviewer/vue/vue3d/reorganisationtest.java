/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphviewer.vue.vue3d;

import java.util.Iterator;
import java.util.Observable;
import java.util.Vector;

/**
 *
 * @author chris
 */
class reorganisationtest extends Observable implements Runnable {

    final private Vector<nouvelleInfo> listaModifier = new Vector<nouvelleInfo>();
    private final GraphDeVisualisation3D vgraph;
    private boolean reorganisationEnCour = false;

    reorganisationtest(GraphDeVisualisation3D graph) {
        this.vgraph = graph;
        for (VueNoeud3D vueNoeud : graph.graph.getVertices()) {
            listaModifier.add(new nouvelleInfo((float) Math.random() * 20 - 10, (float) Math.random() * 20 - 10, (float) Math.random() * 20 - 20, vueNoeud));
        }
    }

    @Override
    public void run() {

        boolean test = true;
        if (!reorganisationEnCour) {
            reorganisationEnCour = true;

            while (test) {
                test = false;
                for (Iterator<nouvelleInfo> it = listaModifier.iterator(); it.hasNext();) {
                    try {
                        nouvelleInfo info = it.next();
                        if (!info.rapprocher(info)) {
                            listaModifier.remove(info);
                        }
                    } catch (Exception e) {
                        break;
                    }
                }
                test = true;

                vgraph.setData();
            }
            reorganisationEnCour = false;
        }
    }

    class nouvelleInfo {
        // toutes nv info utile pour la réorganisation.

        float x, y, z;
        boolean res;
        // lien vers le noeus assoicié
        VueNoeud3D noeud;
        private float marge = 0.5f;

        public nouvelleInfo(float x, float y, float z, VueNoeud3D noeud) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.noeud = noeud;
        }

        public void setXYZ(float x, float y, float z) {
            noeud.setXYZ(x, y, z);
        }

        private boolean rapprocher(nouvelleInfo info) {
            res = false;
            if ((noeud.getX() - x) < -marge) {
                noeud.setX(noeud.getX() + 0.001f);
                res = true;
            }
            if ((noeud.getX() - x) > marge) {
                noeud.setX(noeud.getX() - 0.001f);
                res = true;
            }

            if ((noeud.getY() - y) < -marge) {
                noeud.setY(noeud.getY() + 0.001f);
                res = true;
            }
            if ((noeud.getY() - y) > marge) {
                noeud.setY(noeud.getY() - 0.001f);
                res = true;
            }

            if ((noeud.getZ() - z) < -marge) {
                noeud.setZ(noeud.getZ() + 0.001f);
                res = true;
            }
            if ((noeud.getZ() - z) > marge) {
                noeud.setZ(noeud.getZ() - 0.001f);
                res = true;
            }

            return res;
        }

        @Override
        public String toString() {
            return "X= " + x + "Y= " + y + "Z= " + z + "\t noeud : X= " + noeud.getX() + "Y= " + noeud.getY() + "Z= " + noeud.getZ();
        }
    }
}
