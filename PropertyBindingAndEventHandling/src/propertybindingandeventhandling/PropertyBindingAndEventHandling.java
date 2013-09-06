package propertybindingandeventhandling;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * A sample showing how to use property bindings and event handlers
 * @author jeffreyguenther
 */
public class PropertyBindingAndEventHandling extends Application {
    private DoubleProperty endX;
    private DoubleProperty endY;
    private DoubleProperty startX;
    private DoubleProperty startY;
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Property Binding and Event Example");
        
        // create a root group node. We'll add everything in the scene to it.
        Group root = new Group();
        // create the scene
        Scene scene = new Scene(root, 600, 400);

        // Initialize double properties for the start and end points of a line
        endX = new SimpleDoubleProperty();
        endY = new SimpleDoubleProperty();
        startX = new SimpleDoubleProperty();
        startY = new SimpleDoubleProperty();
        
        // create an event handler to modify the start point
        EventHandler<MouseEvent> startPointHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                // update the x and y position of the start point
                // Changing the value of startX causes the value of the startX 
                // of the line and the centerX of startCircle to be updated. 
                // Automagically! Rinse and repeat for the y components
                startX.set(t.getX());
                startY.set(t.getY());

            }
        };
        
        // create an event handler to modify the end point
        EventHandler<MouseEvent> endPointHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                // same thing happens here, but for the endX/Y of the line 
                // and centerX/Y of endCircle
                endX.set(t.getX());
                endY.set(t.getY());

            }
        };
        
        // Create a circle for at the start of the line
        Circle startCircle = CircleBuilder.create()
                .centerX(100)
                .centerY(100)
                .radius(20)
                .fill(Color.AQUAMARINE)
                .build();
        // where the magic happens. Bind the circle's  center to the start point
        // Where ever startX and startY go, the circle will follow
        startCircle.centerXProperty().bind(startX);
        startCircle.centerYProperty().bind(startY);
        
        // Add the event handlers to circle
        // We need to add the MOUSE_PRESSED event to keep the circle from jumping
        // when we start to drag it.
        startCircle.addEventHandler(MouseEvent.MOUSE_PRESSED, startPointHandler);
        startCircle.addEventHandler(MouseEvent.MOUSE_DRAGGED, startPointHandler);
        // put the circle on screen
        root.getChildren().add(startCircle);

        // Create a circle for the end of the line
        Circle endCircle = CircleBuilder.create()
                .centerX(200)
                .centerY(200)
                .radius(20)
                .fill(Color.PINK)
                .build();
        
        // Add the event handlers. This is the same as the start 
        endCircle.addEventHandler(MouseEvent.MOUSE_PRESSED, endPointHandler);
        endCircle.addEventHandler(MouseEvent.MOUSE_DRAGGED, endPointHandler);
        endCircle.centerXProperty().bind(endX);
        endCircle.centerYProperty().bind(endY);
        root.getChildren().add(endCircle);

        // create a line between the centers of the two circles
        Line l = new Line();
        
        // bind the line's start x and y
        l.startXProperty().bind(startX);
        l.startYProperty().bind(startY);
        
        // bind the line's end x and y points
        l.endXProperty().bind(endX);
        l.endYProperty().bind(endY);
        
        // add the line to the scene. Forget and it won't show up! ;)
        root.getChildren().add(l);
        
        // move the circles in front of the line
        // (un)comment to see the effect
        endCircle.toFront();
        startCircle.toFront();

        // display the scene on the stage
        stage.setScene(scene);
        // show the stage on screen
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
