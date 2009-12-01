
package graphviewer.vue.vue3d;

import graphviewer.vue.vue2d.VueArrete;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;

/**
 * Representation d'une arrete pour une visualisation en 3 dimension.
 *
 * @author chris
 */
public class VueArrete3D {

    private int id = -1;
    private VueNoeud3D noeud1;
    private VueNoeud3D noeud2;
    private static final float rayon = (float) 0.01;

/**
 * Construit une arrete en conservant l'information indiquant quels noeuds sont relié grace a elle.
 * @param n1    noeud reliée par cet arc
 * @param n2    noeud reliée par cet arc
 */
    public VueArrete3D(VueNoeud3D n1, VueNoeud3D n2){
            noeud1 = n1;
            noeud2 = n2;

    }
/**
 * Construit une arrete a partir d'un objet {@link ModeleArrete} et de deux objet {@link VueArrete}
 * en conservant l'information indiquant quels noeuds sont relié grace a elle.
 *
 * @param vueArrete {@link VueArrete} utilisée pour la construction.
 * @param vueNoeud1
 * @param vueNoeud2
 */
    VueArrete3D(VueArrete vueArrete,VueNoeud3D vueNoeud1, VueNoeud3D vueNoeud2) {
        id = vueArrete.getId();

        noeud1 = vueNoeud1;
        noeud2 = vueNoeud2;
    }



    public void afficher(GLAutoDrawable drawable){
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        
        float x1,x2,y1,y2,z1,z2;

        x1=noeud1.getX();
        y1=noeud1.getY();
        z1=noeud1.getZ();
        x2=noeud2.getX();
        y2=noeud2.getY();
        z2=noeud2.getZ();

        float distance = (float)Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) + (z1-z2)*(z1-z2));
        gl.glPushMatrix();

           gl.glColor3f((float)1.0, (float)1.0, (float)0.0);
           gl.glBegin(gl.GL_LINES);
                gl.glVertex3f(x1,y1,z1);gl.glVertex3f(x2,y2,z2);
            gl.glEnd();
        /*
            gl.glTranslatef(x1, y1, z1);
            GLUquadric params = glu.gluNewQuadric();
            glu.gluCylinder(params, rayon , rayon , distance ,50 ,50);
            glu.gluDeleteQuadric(params);
         */
        gl.glPopMatrix();

    }

}
