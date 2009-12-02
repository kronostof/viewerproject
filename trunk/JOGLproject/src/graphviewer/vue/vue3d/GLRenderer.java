package graphviewer.vue.vue3d;

import graphviewer.model.visualisation.GraphDeVisualisation;
import graphviewer.vue.vue2d.VueArrete;
import graphviewer.vue.vue2d.VueNoeud;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import java.awt.Point;

/**
 * GLRenderer.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class GLRenderer implements GLEventListener,EventListener {

    private final float PI_180 = (float) (Math.PI / 180.0);
    private boolean stepForward;
    private boolean stepBackward;
    private boolean turnRight;
    private boolean turnLeft;

    private float yrot;  // Y Rotation

    private float walkbias = 0;
    private float walkbiasangle = 0;

    private float lookupdown = 1.0f;
    private boolean lookUp;
    private boolean lookDown;

    private Point pickPoint;
    private float heading;
    private float xpos;
    private float zpos;
    
    

    public GraphDeVisualisation3D graphDeVisualisation = null;

    GLRenderer(GraphDeVisualisation3D graph) {
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



     //   GestionClavier gestionClavier = new GestionClavier(this);
    //    drawable.addMouseListener(gestionClavier);
        
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
        update();
        GL gl = drawable.getGL();
        //GLU glu = new GLU();




        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        
        float x = 0,y = 0,z = 0,u = 0,v = 0;


        float xtrans = -xpos;
        float ztrans = -zpos;
        float ytrans = -walkbias - 0.25f;
        float sceneroty = 360.0f - yrot;

        gl.glRotatef(lookupdown, 1.0f, 0, 0);
        gl.glRotatef(sceneroty, 0, 1.0f, 0);

        gl.glTranslatef(xtrans, ytrans, ztrans);

        
        
        if (graphDeVisualisation != null)
            graphDeVisualisation.afficher(drawable);
        else
            System.out.println("graphDeVisualisation == null ! ! ! \n êtes tu sur de ce que tu fait ?");

        
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }





private void update() {
        if (stepForward) {
            xpos -= (float) Math.sin(heading * PI_180) * 0.05f;
            zpos -= (float) Math.cos(heading * PI_180) * 0.05f;
            if (walkbiasangle >= 359.0f) {
                walkbiasangle = 0.0f;
            } else {
                walkbiasangle += 10;
            }
            walkbias = (float) Math.sin(walkbiasangle * PI_180) / 20.0f;
        }

        if (stepBackward) {
            xpos += (float) Math.sin(heading * PI_180) * 0.05f;
            zpos += (float) Math.cos(heading * PI_180) * 0.05f;
            if (walkbiasangle <= 1.0f) {
                walkbiasangle = 359.0f;
            } else {
                walkbiasangle -= 10;
            }
            walkbias = (float) Math.sin(walkbiasangle * PI_180) / 20.0f;
        }

        if (turnRight) {
            heading -= 10.0f;
            yrot = heading;
        }

        if (turnLeft) { 
            heading += 10.0f;
            yrot = heading;
        }

        if (lookUp) {
            lookupdown -= 10.0f;
        }

        if (lookDown) {
            lookupdown += 10.0f;
        }
    }



    
    public void stepForward(boolean step) {
        stepForward = step;
    }

    public void stepBackward(boolean step) {
        stepBackward = step;
    }

    public void turnRight(boolean turn) {
        turnRight = turn;
        graphDeVisualisation.setData();
    }

    public void turnLeft(boolean turn) {
        turnLeft = turn;
    }

    public void lookUp(boolean look) {
        lookUp = look;
    }

    public void lookDown(boolean look) {
        lookDown = look;
    }

    void mousePressed(MouseEvent e) {
        pickPoint = e.getPoint();
        graphDeVisualisation.setData();
    }




    
}
