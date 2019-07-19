package figuresapp.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Circle extends Figure {
    private double radius;

    private Circle(double cx, double cy, double lineWigth, Color color) {
        super(Figure.FIGURE_TYPE_CIRCLE, cx, cy, lineWigth, color);
    }

    public Circle(double cx, double cy, double lineWigth, Color color, double radius) {
        this(cx, cy, lineWigth, color);
        this.radius = radius;
    }

    public double getRadius() {

        return radius;
    }

    public void setRadius(double radius) {

        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWigth);
        gc.setStroke(color);
        gc.strokeOval(cx - radius, cy - radius, radius * 2, radius * 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Circle{");
        sb.append("radius=").append(radius);
        sb.append(", cx=").append(cx);
        sb.append(", cy=").append(cy);
        sb.append(", lineWigth=").append(lineWigth);
        sb.append(", color=").append(color);
        sb.append('}');

        return sb.toString();
    }
}
