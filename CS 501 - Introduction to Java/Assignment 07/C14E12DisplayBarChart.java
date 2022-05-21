/*
 * CS501 - Introduction to Java Programming
 * C14E12DisplayBarChart.java
 * Submitted by Chaitanya Pawar
 * */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class C14E12DisplayBarChart extends Application {

	/*
	 * (Display a bar chart) Write a program that uses a bar chart to display the
	 * percentages of the overall grade represented by projects, quizzes, midterm
	 * exams, and the final exam, as shown in Figure 14.46b. Suppose projects take
	 * 20% and are displayed in red, quizzes take 10% and are displayed in blue,
	 * midterm exams take 30% and are displayed in green, and the final exam takes
	 * 40% and is displayed in orange. Use the Rectangle class to display the bars.
	 * Interested readers may explore the JavaFX BarChart class for further study
	 */

	/*
	 * Two panes, one for TextFields and one for Bar Chart which update when Update
	 * button is pressed
	 */
	private DataPane dataPanel = new DataPane();
	private BarChart chartPanel = new BarChart();

	@Override
	public void start(Stage firstStage) {
		// Setting up main screen
		GridPane mainPanel = new GridPane();
		Button btnUpdate = new Button("Update");
		mainPanel.add(btnUpdate, 0, 1);
		GridPane.setHalignment(btnUpdate, HPos.CENTER);

		// Create and register the handler
		btnUpdate.setOnAction(new UpdateHandlerClass());

		// Insert Textfields and a Barchart into the main pane.
		mainPanel.add(dataPanel, 0, 0);
		mainPanel.add(chartPanel, 1, 0);

		// With the main pane, set up the scenario and stage.
		Scene scene = new Scene(mainPanel);
		firstStage.setTitle("Bar chart");
		firstStage.setScene(scene);
		firstStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	// After the update button is pushed, this class is used to handle the data.
	class UpdateHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			// Clears the text fields and checks to see if the inputs were valid.
			if (dataPanel.update() == true) {
				dataPanel.removeError(); // Removes any prior error messages displayed to the user.
				chartPanel.removeAll(); // Removes the Bar Chart from the user's view.
				chartPanel.update(dataPanel.getData()); // Draws the bar chart anew with new data from the user.
			}
		}
	}

	// Text Fields for user input are maintained by this class.
	class DataPane extends GridPane {
		private double[] data = { 0, 0, 0, 0 };
		private TextField projectTextField = new TextField();
		private TextField quizTextField = new TextField();
		private TextField midtermTextField = new TextField();
		private TextField finalTextField = new TextField();
		private Text errorMsg = new Text();

		public DataPane() {
			setAlignment(Pos.CENTER);
			setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
			setHgap(5.5);
			setVgap(5.5);

			errorMsg.setStyle("-fx-stroke: red; -fx-fill: red;");

			add(new Label("Projects:"), 0, 0);
			add(projectTextField, 1, 0);
			add(new Label("Quizzes:"), 0, 1);
			add(quizTextField, 1, 1);
			add(new Label("Midterm:"), 0, 2);
			add(midtermTextField, 1, 2);
			add(new Label("Final:"), 0, 3);
			add(finalTextField, 1, 3);
			add(errorMsg, 0, 4);
		}

		// This method is used to send new user data to the BarChart class.
		public double[] getData() {
			return data;
		}

		// Removes the error notice from the stage.
		public void removeError() {
			errorMsg.setText("");
		}

		// Stores user input from the four text fields and returns true if the values
		// are correct.
		public boolean update() {
			// Clear Text Fields
			String projectData = projectTextField.getText();
			projectTextField.setText("");
			String quizData = quizTextField.getText();
			quizTextField.setText("");
			String midtermData = midtermTextField.getText();
			midtermTextField.setText("");
			String finalData = finalTextField.getText();
			finalTextField.setText("");

			// Turn strings to Doubles
			double tempProject = Double.parseDouble(projectData);
			double tempQuiz = Double.parseDouble(quizData);
			double tempMidterm = Double.parseDouble(midtermData);
			double tempFinal = Double.parseDouble(finalData);

			// Check if values are greater than 0 and add up to 100
			// Assign error message accordingly if invalid
			if (tempProject < 0.0) {
				errorMsg.setText("ERROR: Project Input was less then 0.0");
				return false;
			}
			if (tempQuiz < 0.0) {
				errorMsg.setText("ERROR: Quiz Input was less then 0.0");
				return false;
			}
			if (tempMidterm < 0.0) {
				errorMsg.setText("ERROR: Midterm Input was less then 0.0");
				return false;
			}
			if (tempFinal < 0.0) {
				errorMsg.setText("ERROR: Final Input was less then 0.0");
				return false;
			}
			if (tempProject + tempQuiz + tempMidterm + tempFinal != 100) {
				errorMsg.setText("ERROR: All inputs must add up to 100");
				return false;
			}

			// Update data if valid terms found
			data[0] = tempProject;
			data[1] = tempQuiz;
			data[2] = tempMidterm;
			data[3] = tempFinal;
			return true;
		}

	}

	// Inner-Class that generates a bar chart depending on user input
	class BarChart extends Pane {
		Color[] colors = { Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.ORANGE,
				Color.PINK, Color.GRAY };
		String[] dataName = { "Projects", "Quizzes", "Midterm", "Final" };
		// Default data from question
		double[] data = { 20, 10, 30, 40 };
		double w = 200;
		double h = 200;

		public BarChart() {
			paint();
		}

		// The percentage weights data array is updated.
		public void update(double[] newData) {
			for (int i = 0; i < data.length; i++) {
				data[i] = newData[i];
			}
			paint();
		}

		// Clears the window of all Nodes, allowing the Chart to be rebuilt.
		public void removeAll() {
			getChildren().remove(0, data.length * 3 + 1);
		}

		// After the user enters data, it generates a bar chart.
		public void paint() {

			double max = data[0];
			for (int i = 1; i < data.length; i++) {
				max = Math.max(max, data[i]);
			}

			double barWidth = (w - 10.0) / data.length - 10;
			double maxBarHeight = h - 30;

			getChildren().add(new Line(5, h - 10, w - 5, h - 10));

			int x = 15;
			for (int i = 0; i < data.length; i++) {
				double newHeight = maxBarHeight * data[i] / max;
				double y = h - 10 - newHeight;
				Rectangle rectangle = new Rectangle(x, y, barWidth, newHeight);
				rectangle.setFill(colors[i % colors.length]);

				getChildren().add(rectangle);
				getChildren().add(new Text(x, y - 7, dataName[i]));
				getChildren().add(new Text(x + 3, h - newHeight + 10, (data[i] + "%")));
				x += barWidth + 10;
			}
		}
	}
}