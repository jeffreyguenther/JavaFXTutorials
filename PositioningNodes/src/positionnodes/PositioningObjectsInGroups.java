package positionnodes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;

import com.javafx.experiments.scenicview.ScenicView;

public class PositioningObjectsInGroups extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// Create a pane as the scene root
		Pane root = new Pane();
		
		// position a rectangle absolutely
		// NOTE: A rectangle is drawn from the upper left hand corner
		Rectangle r = RectangleBuilder.create()
				.x(0) // absolute position in container
				.y(0) // absolute position in container
				.fill(Color.AQUA)
				.width(50)
				.height(50)
				.build();
		r.relocate(100, 100);
		
		// NOTE: A circle is drawn from the center
		Circle c = CircleBuilder.create()
				.centerX(0)
				.centerY(0)
				.radius(50)
				.fill(Color.ORANGERED)
				.build();
		c.relocate(200, 200);
		
		Group g = new Group(r, c);
		g.relocate(0, 0); // add/remove this line to see the effect of relocate 
		root.getChildren().add(g);
		
		
		Scene scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.setTitle("Position Nodes With Relocate");
		stage.show();
		
		ScenicView.show(scene);
		
		/*
		 *By default the bounds of the Group will be the sum of it's children's
		 *bounds. If we don't set it's position with relocate, we'll need to use
		 *BoundsInParent.getMinX/Y() to get it's position. 
		 *
		 *Notice also that if we don't call g.relocate() the circles and rectangles
		 *positions appear to be with respect to the Pane's coordinate system. That is 
		 *the Group is just wrapping the rectangle and circle. The only way we
		 *can treat a Group like a coordinate system is use relocate to position
		 *it. Then it behaves as we might expect.
		 */
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
