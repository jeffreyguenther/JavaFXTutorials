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

public class PositioningNodesAbsolutely extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// Create a pane as the scene root
		Pane root = new Pane();
		
		// position a rectangle absolutely
		// NOTE: A rectangle is drawn from the upper left hand corner
		Rectangle r = RectangleBuilder.create()
				.x(100) // absolute position in container
				.y(100) // absolute position in container
				.fill(Color.AQUA)
				.width(50)
				.height(50)
				.build();
		
		// NOTE: A circle is drawn from the center
		Circle c = CircleBuilder.create()
				.centerX(200)
				.centerY(200)
				.radius(50)
				.fill(Color.ORANGERED)
				.build();
		
		root.getChildren().addAll(r,c);
		
		Scene scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.setTitle("Position Nodes Aboslutely");
		stage.show();
		
		ScenicView.show(scene);
		/*
		 * If you inspect the rectangle and circle with SceniceView, you'll
		 * that they don't have a layoutX/Y. When you position nodes absolutely
		 * layoutX/Y is never set. This isn't a problem, just be aware that it 
		 * happens. It can effect the way you do custom layouts.
		 */
	}

	public static void main(String[] args) {
		launch(args);

	}

}
