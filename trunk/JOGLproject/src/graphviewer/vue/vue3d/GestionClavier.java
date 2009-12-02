package graphviewer.vue.vue3d;


import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.media.opengl.GLAutoDrawable;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import javax.media.opengl.GLEventListener;

/**
 *
 * Classe servant a gérer les frappe au clavier.
 *
 * @author chris
 */
public class GestionClavier implements GLEventListener, MouseListener{
    

    private GLRenderer renderer;
    private Point pickPoint;

    public GestionClavier(GLRenderer renderer) {
        this.renderer = renderer;
        /*
        display.registerKeyStrokeForHelp(
                KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "Toggle blending");

        display.registerKeyStrokeForHelp(
                KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "Switch texture filter");

        display.registerKeyStrokeForHelp(
                KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Move forward");

        display.registerKeyStrokeForHelp(
                KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Move backward");

        display.registerKeyStrokeForHelp(
                KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Turn left");

        display.registerKeyStrokeForHelp(
                KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Turn right");

        display.registerKeyStrokeForHelp(
                KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, 0), "Look up");

        display.registerKeyStrokeForHelp(KeyStroke.getKeyStroke(
                KeyEvent.VK_PAGE_DOWN, 0), "Look down");
         */
    }

    public void init(GLAutoDrawable drawable) {
        System.out.println("Not supported yet.");
    }

    public void display(GLAutoDrawable drawable) {
        System.out.println("Not supported yetXXXXXXXXXx.");
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("Not supported yet.");
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        System.out.println("Not supported yet.");
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        pickPoint = e.getPoint();
        System.out.println("sourie presse");
        renderer.mousePressed(e);
        
    }

    public void mouseReleased(MouseEvent e) {
        renderer.turnRight(false);
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
