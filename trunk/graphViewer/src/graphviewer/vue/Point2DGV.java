/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphviewer.vue;

import java.awt.geom.Point2D;

/**
 *
 * @author chris
 */
class Point2DGV extends Point2D{

    double x;
    double y;


    public Point2DGV(double x, double y) {
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setLocation(double arg0, double arg1) {
        this.x = arg0; this.y = arg1;
    }

}
