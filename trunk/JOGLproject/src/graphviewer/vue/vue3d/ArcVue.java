/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue.vue3d;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class ArcVue {
    
    private NoeudVue noeud1;
    private NoeudVue noeud2;

    private static final float rayon = (float) 0.01;

    public ArcVue(NoeudVue n1, NoeudVue n2){
            noeud1 = n1;
            noeud2 = n2;

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
