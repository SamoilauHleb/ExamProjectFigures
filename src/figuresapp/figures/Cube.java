package figuresapp.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Cube extends Figure{
    private double side;


    private Cube(double cx, double cy, double lineWigth, Color color) {
        super(Figure.FIGURE_TYPE_CUBE, cx, cy, lineWigth, color);
    }

    public Cube(double cx, double cy, double lineWigth, Color color, double side) {
        this(cx, cy, lineWigth, color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWigth);
        gc.setStroke(color);
        gc.strokeRect(cx,cy,side*2,side*2);
        gc.strokeLine(cx,cy,cx-side,cy-side);
        gc.strokePolygon(new double[]{cx-side,cx-side,cx,cx+side*2,cx+side*2,cx+side},new double[]{cy-side,cy+side,cy+side*2,cy+side*2,cy,cy-side},6);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube{");
        sb.append("side=").append(side);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWigth=").append(lineWigth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
