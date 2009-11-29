package graphviewer.vue.vue3d;

import graphviewer.model.visualisation.GraphDeVisualisation;
import graphviewer.vue.VueArrete;
import graphviewer.vue.VueNoeud;
import java.util.ArrayList;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;


/**
 * GLRenderer.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class GLRenderer implements GLEventListener {

    
    GraphDeVisualisation graphDeVisualisation = null;
    


    GLRenderer() {
        super();
    }


    GLRenderer(GraphDeVisualisation graph) {
        super();
        graphDeVisualisation = graph;
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        // TODO a remplacer par le graphe de visualisation directement !!! URGENT
        GraphVue gv = new GraphVue();
        if (graphDeVisualisation != null) {

            for (VueNoeud noeud : graphDeVisualisation.getGraph().getVertices()){
                gv.ajouterNoeud(new NoeudVue(noeud.getX(),noeud.getY(),noeud.getZ()));

                 gv.setListeNoeud(new ArrayList<VueNoeud>(graphDeVisualisation.getGraph().getVertices()));
          //TODO gerrer les arrette
          //  gv.setListeArc(new ArrayList<VueArrete>(graphDeVisualisation.getGraph().getEdges()));
            }
        }else{
           
        //Recupere liste NoeudModele -> NoeudVue
        NoeudVue nv1 = new NoeudVue(-1.0f, 1.0f, 0.0f);
        NoeudVue nv2 = new NoeudVue(-3.0f, 5.0f, -2.0f);
        NoeudVue nv3 = new NoeudVue(2.0f, -0.1f, -3.0f);
        NoeudVue nv4 = new NoeudVue(0.0f, 4.5f, -2.3f);

        ArcVue av1 = new ArcVue(nv1, nv2);
        ArcVue av2 = new ArcVue(nv1, nv3);
        ArcVue av3 = new ArcVue(nv1, nv4);
       
        
        gv.ajouterNoeud(nv1);
        gv.ajouterNoeud(nv2);
        gv.ajouterNoeud(nv3);
        gv.ajouterNoeud(nv4);
        gv.ajouterArc(av1);
        gv.ajouterArc(av2);
        gv.ajouterArc(av3);

        

            
        }
        gv.afficher(drawable);

        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
