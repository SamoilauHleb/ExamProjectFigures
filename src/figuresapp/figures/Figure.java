package figuresapp.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Figure {
    public static final int FIGURE_TYPE_CIRCLE = 0;
    public static final int FIGURE_TYPE_RECT = 1;
    public static final int FIGURE_TYPE_TRIANGLE = 2;
    public static final int FIGURE_TYPE_CUBE = 3;

    private int type;
    protected double cx;
    protected double cy;
    protected double lineWigth;
    protected Color color;

    public Figure(int type, double cx, double cy, double lineWigth, Color color) {
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.lineWigth = lineWigth;
        this.color = color;
    }

    public int getType() {

        return type;
    }

    public double getCx() {

        return cx;
    }

    public void setCx(double cx) {

        this.cx = cx;
    }

    public double getCy() {
        return cy;
    }

    public void setCy(double cy) {

        this.cy = cy;
    }

    public double getLineWigth() {

        return lineWigth;
    }

    public void setLineWigth(double lineWigth) {

        this.lineWigth = lineWigth;
    }

    public Color getColor() {

        return color;
    }

    public void setColor(Color color) {

        this.color = color;
    }

    public abstract void draw(GraphicsContext gc);
}
