/*
 * CS501 - Introduction to Java Programming
 * C14E12DisplayBarChart.java
 * Submitted by Chaitanya Pawar
 * */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class C14E1FourImageDisplay extends Application {
	@Override
	public void start(Stage firstStage) {
		// Configuring GridPanel properties
		GridPane panel = new GridPane();
		panel.setPadding(new Insets(5));
		panel.setHgap(5.5);
		panel.setVgap(5.5);

		// Loading images from files
		Image image1 = new Image("us_flag.gif");
		Image image2 = new Image("england_flag.gif");
		Image image3 = new Image("brazil_flag.gif");
		Image image4 = new Image("china_flag.gif");

		// Comfiguring images to display
		ImageView usa = new ImageView(image1);
		ImageView england = new ImageView(image2);
		ImageView brazil = new ImageView(image3);
		ImageView china = new ImageView(image4);

		// Inserting each flag into the grid
		panel.add(usa, 0, 0);
		panel.add(england, 0, 1);
		panel.add(brazil, 1, 0);
		panel.add(china, 1, 1);

		// Set up the scene and the stage
		Scene scene = new Scene(panel);
		firstStage.setTitle("Four Flags");
		firstStage.setScene(scene);
		firstStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}