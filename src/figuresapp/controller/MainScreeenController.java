package figuresapp.controller;

import drawutils.Drawer;
import figuresapp.figureException.UnknownFiguresException;
import figuresapp.figures.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreeenController implements Initializable {

    private static final Logger logger = Logger.getLogger(MainScreeenController.class);
    private ArrayList<Figure> figures;
    private Random random;
    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        logger.info("MainScreenController started.");
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    @FXML
    private void onMouseClicked(MouseEvent evt) {
        addFigure(createFigure(evt.getX(), evt.getY()));
        repaint();

    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    private Figure createFigure(double x, double y) {
        Figure figure = null;

        switch (random.nextInt(4)) {
            case Figure.FIGURE_TYPE_CIRCLE:
                figure = new Circle(x, y, random.nextInt(4), Color.AQUA, random.nextInt(50));
                break;
            case Figure.FIGURE_TYPE_RECT:
                figure = new Rectangle(x, y, random.nextInt(4), Color.DARKCYAN, random.nextInt(100), random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                figure = new Triangle(x, y, random.nextInt(4), Color.FIREBRICK, random.nextInt(100));
                break;
            case Figure.FIGURE_TYPE_CUBE:
                figure = new Cube(x, y, random.nextInt(4), Color.INDIGO, random.nextInt(100));
                break;
            default:
                try {
                    throw new UnknownFiguresException("Unknown figure");
                } catch (UnknownFiguresException e) {
                    logger.error(e.getMessage());
                }

        }

        return figure;
    }


}
