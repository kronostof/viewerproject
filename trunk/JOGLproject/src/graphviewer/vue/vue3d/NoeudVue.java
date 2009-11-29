package graphviewer.vue.vue3d;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author Mathouston
 */
public class NoeudVue {

    private float x;
    private float y;
    private float z;

    private static final float rayon = (float) 0.1;

    public NoeudVue (float x, float y, float z){

        this.x = x;
        this.y = y;
        this.z = z;
    }

    NoeudVue(double x, double y, double z) {
        this.x = (float) x;
        this.y = (float) y;
        this.z = (float) z;
    }

    public void afficher(GLAutoDrawable drawable){
        
        GL gl = drawable.getGL();
        GLU glu = new GLU();

       
        gl.glPushMatrix();
            gl.glTranslatef(x, y, z);
            gl.glColor3f((float)1.0, (float)0.0, (float)0.0);
            GLUquadric params = glu.gluNewQuadric();
            glu.gluSphere(params,rayon,50,50);
            glu.gluDeleteQuadric(params);
        gl.glPopMatrix();
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getZ(){
        return z;
    }
}
