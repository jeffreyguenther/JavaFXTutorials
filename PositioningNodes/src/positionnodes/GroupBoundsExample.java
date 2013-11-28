package positionnodes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;

import com.javafx.experiments.scenicview.ScenicView;

public class GroupBoundsExample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		// Create a vbox to position all nodes in a vertical stack
		VBox root = new VBox();
		
		// Create a toolbar
		ToolBar toolbar = new ToolBar();
		toolbar.getItems().add(new Button("Do something!"));
		
		
		// position a rectangle absolutely
		Rectangle r = RectangleBuilder.create()
				.x(-100) // absolute position in container
				.y(100) // absolute position in container
				.fill(Color.AQUA)
				.width(50)
				.height(50)
				.build();
		
		Group canvas = new Group(r);
		
		// put the toolbar and the canvas group in the vbox.
		// Add the toolbar first so it is on top
		root.getChildren().addAll(toolbar, canvas);
		
		Scene scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.setTitle("Group Bounds Example");
		stage.show();
		
		ScenicView.show(scene);
		
		/* Notice how the entire rectangle is on screen?
		 * This is because the bounds of the Group expand to fit the entire
		 * rectangle effectively pushing the origin of the Group over.
		*/
	}

	public static void main(String[] args) {
		launch(args);

	}

}
