/*
Display circles
Write a Java program that displays ovals, as shown in figure 18.12b. The circles are centered in the pane.
The gap between two adjacent circles is 10 pixels,
and the gap between the border of the pane and the largest circle is also 10.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Section_18_20 extends Application {
    @Override
    public void start(Stage primaryStage) {
        CirclePane pane = new CirclePane();

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Display Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Pane to display circles
    static class CirclePane extends Pane {
        private static final int GAP = 10; // Gap between circles
        public CirclePane() {
            drawCircles();
            widthProperty().addListener(ov -> drawCircles());
            heightProperty().addListener(ov -> drawCircles());
        }

        // Method to draw nested circles
        private void drawCircles() {
            getChildren().clear(); // Clear and drawings

            double centerX = getWidth() / 2;
            double centerY = getHeight() / 2;
            double maxRadius = Math.min(getWidth(), getHeight()) / 2 - GAP; // Largest circle
            drawRecursiveCircle(centerX, centerY, maxRadius);
        }

        // Recursive method to draw circles
        private void drawRecursiveCircle(double x, double y, double radius) {
            if (radius < GAP) return; // Base case: stop when circles are too small

            Circle circle = new Circle(x, y, radius);
            circle.setFill(Color.TRANSPARENT);
            circle.setStroke(Color.BLACK);

            getChildren().add(circle); // Add circle to pane
            drawRecursiveCircle(x, y, radius - GAP); // Recursive call for smaller circle
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
