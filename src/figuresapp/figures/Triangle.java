package figuresapp.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {
    private double base;

    private Triangle(double cx, double cy, double lineWigth, Color color) {
        super(Figure.FIGURE_TYPE_TRIANGLE,cx, cy, lineWigth, color);
    }

    public Triangle(double cx, double cy, double lineWigth, Color color, double base) {
        this(cx, cy, lineWigth, color);
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWigth);
        gc.setStroke(color);
        gc.strokePolygon(new double[]{
                cx, cx+base/2, cx-base/2
        }, new  double[]{cy-base/2, cy+base/2,cy+base/2}, 3);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.base, base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("base=").append(base);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWigth=").append(lineWigth);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
