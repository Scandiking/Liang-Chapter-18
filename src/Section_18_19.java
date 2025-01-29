/*
Sierpinski triangle
Revise Listing 18.9 to develop a program that lets the user use the +/- buttons,
primary/secondary mouse buttons and UP/DOWN arrow keys to increase or decrease the current order by 1,
as shown in Figure 18.12a. The initial order is 0. If the current order is 0, the Decrease button is ignored.
 */

// NB: Make sure you have JavaFX installed on your system and that your IDE is set to use the libraries.


import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Section_18_19 extends Application{
    @Override
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane pane = new SierpinskiTrianglePane();
        TextField tfOrder = new TextField("0");
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

        // Buttons to control order
        Button btnIncrease = new Button("Increase");
        Button btnDecrease = new Button("Decrease");

        // Button actions
        btnIncrease.setOnAction(e -> pane.setOrder(pane.getOrder() + 1));
        btnDecrease.setOnAction(e -> {
            if (pane.getOrder() > 0) pane.setOrder(pane.getOrder() - 1);
        });

        // Manual input via text field
        tfOrder.setOnAction(e-> {
            try {
                int order = Integer.parseInt(tfOrder.getText());
                if (order >= 0) {
                    pane.setOrder(order);
                }
        } catch (NumberFormatException ignored) {}
        });

        // Control panel layout
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Order:"), tfOrder, btnDecrease, btnIncrease);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 500, 500);
        primaryStage.setTitle("Sierpinski Triangle v2");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Mouse click controls
        pane.setOnMouseClicked(e -> {
            if (e.isPrimaryButtonDown()) {
                pane.setOrder(pane.getOrder() + 1);
            } else if (e.isSecondaryButtonDown() && pane.getOrder() > 0) {
                pane.setOrder(pane.getOrder() - 1);
            }
        });

        // Keyboard controls
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                pane.setOrder(pane.getOrder() + 1);
            } else if (e.getCode() == KeyCode.DOWN && pane.getOrder() > 0) {
                pane.setOrder(pane.getOrder() - 1);
            }
        });

        // Update text field when order changes
        pane.orderProperty().addListener((obs, oldVal, newVal) -> tfOrder.setText(newVal.toString()));

        // Redraw when window resizes
        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }

    // Pane to draw Sierpinski triangle
    static class SierpinskiTrianglePane extends Pane {
        private int order = 0;
        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        SierpinskiTrianglePane() {
        }

        protected void paint() {
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

            this.getChildren().clear();
            drawTriangles(order, p1, p2, p3);
        }

        private void drawTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
            if (order == 0) {
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.WHITE);
                this.getChildren().add(triangle);
            } else {
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);

                drawTriangles(order - 1, p1, p12, p31);
                drawTriangles(order - 1, p12, p2, p23);
                drawTriangles(order - 1, p31, p23, p3);
            }
        }

        public javafx.beans.property.IntegerProperty orderProperty() {
            return new javafx.beans.property.SimpleIntegerProperty(order);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
}
