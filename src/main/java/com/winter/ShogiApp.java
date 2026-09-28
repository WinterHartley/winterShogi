package com.winter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShogiApp extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		final Double handWidth = 50d; //width of each player's hand
		//Sets up layout
		primaryStage.setTitle("WinterShogi");

		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #141617");

		//Hand Content

		//TODO

		//Hand Backgrounds
		Image handImage = new Image(getClass().getResource("/com/winter/images/boards/hand2.png").toExternalForm());
		BackgroundImage handBackgroundImage = new BackgroundImage(handImage,
			javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
			javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.DEFAULT,
			BackgroundSize.DEFAULT
		);
		Background handBackground = new Background(handBackgroundImage);

		Insets handInsets = new Insets(50, 0, 0, 0);

		VBox leftBox = new VBox(new Label("AAAAA"));
		leftBox.setBackground(handBackground);
		leftBox.setMinWidth(handWidth);
		leftBox.setMaxWidth(handImage.getWidth());
		leftBox.setMaxHeight(handImage.getHeight());
		leftBox.setAlignment(Pos.TOP_CENTER);
		leftBox.setPadding(handInsets);

		VBox rightBox = new VBox(new Label("BBBBB"));
		rightBox.setBackground(handBackground);
		rightBox.setMinWidth(handWidth);
		rightBox.setMaxWidth(handImage.getWidth());
		rightBox.setMaxHeight(handImage.getHeight());
		rightBox.setAlignment(Pos.BOTTOM_CENTER);
		rightBox.setPadding(handInsets);
		rightBox.setScaleX(-1);
		rightBox.setScaleY(-1);

		borderPane.setLeft(leftBox);
		borderPane.setRight(rightBox);

		BorderPane.setAlignment(leftBox, Pos.BOTTOM_LEFT);
		BorderPane.setAlignment(rightBox, Pos.TOP_RIGHT);


		//Create scene
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
		primaryStage.setMinHeight(500);
		primaryStage.setMinWidth(500);
        primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}