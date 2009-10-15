/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue;

/**
 *
 * @author chris
 */
public class Position3D {
    double x,y,z;
    
    public Position3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Position3D(double x,double y,double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "x="+x+" y=" + y + " z=" + z;
    }


   
}
