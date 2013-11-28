package positionnodes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;

import com.javafx.experiments.scenicview.ScenicView;

public class PositioningNodesWithRelocate extends Application {

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
		
		root.getChildren().addAll(r,c);
		
		Scene scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.setTitle("Position Nodes With Relocate");
		stage.show();
		
		ScenicView.show(scene);
		/*
		 * This approach treats the shape as its own coordinate system and uses
		 * layoutX/Y to position the nodes.
		 * 
		 * Check layoutX/Y for the circle. Notice anything strange? It's position
		 * says it is 250, 250. What?! Remember that when you use relocate(x, y)
		 * it does the calculation finalX - getLayoutBounds().getMinX().
		 * Because a circle is drawn from the center it's layout bounds are
		 * [-50, -50, 100, 100]. 200 - -50 is 250. If you want to know the
		 * position of the circle in the parent container, use 
		 * boundsInParent.getMinX/Y(). This also works for rectangles.
		 */
	}

	public static void main(String[] args) {
		launch(args);

	}

}
