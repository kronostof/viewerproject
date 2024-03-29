package graphviewer.vue.vue3d;

import graphviewer.vue.vue2d.VueNoeud;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;


/**
 * Representation d'un noeud pour une visualisation en 3 dimension.
 * @author Mathouston
 */
public class VueNoeud3D {
    private int id = -1;
    private float x;
    private float y;
    private float z;

    private static final float rayon = (float) 0.2;

    public VueNoeud3D (float x, float y, float z){

        this.x = x;
        this.y = y;
        this.z = z;
    }

    VueNoeud3D(double x, double y, double z) {
        this.x = (float) x;
        this.y = (float) y;
        this.z = (float) z;
    }

    VueNoeud3D(VueNoeud vueNoeud) {
        id = vueNoeud.getId();
        this.x = (float) vueNoeud.getX();
        this.y = (float) vueNoeud.getY();
        this.z = (float) vueNoeud.getZ();
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
    /**
     * retourne la valeur de la position en x
     * @return x.
     */
    public float getX(){
        return x;
    }
    /**
     * retourne la valeur de la position en y
     * @return y.
     */
    public float getY(){
        return y;
    }
    /**
     * retourne la valeur de la position en z.
     * @return z.
     */
    public float getZ(){
        return z;
    }

    @Override
    public String toString() {
        return "x="+x+ " y="+y+ " z="+z;
    }

    int getID() {
        return id;
    }
//TODO a jarter !!! très vite - horible
    void setXYZ(double nx, double ny, int nz) {
        this.x = (float) nx;
        this.y = (float) ny;
        this.z = (float) nz;
    }

    public void setXYZ(float x, float y, float z){

        this.x = x;
        this.y = y;
        this.z = z;
    }
    /**
     * modifie la valeur de la position en x
     * @param x    nouvelle valeur de x.
     */
    public void setX(float x) {
        this.x = x;
    }
    /**
     * modifie la valeur de la position en y.
     * @param y    nouvelle valeur de y.
     */
    public void setY(float y) {
        this.y = y;
    }
    /**
     * modifie la valeur de la position en z.
     * @param z    nouvelle valeur de z.
     */
    public void setZ(float z) {
        this.z = z;
    }
}
