package com.winter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ShogiApp extends Application {
	public static final PreloadImages images = new PreloadImages();
	@Override
	public void start(Stage primaryStage) throws Exception{
		//Sets up layout
		primaryStage.setTitle("WinterShogi");

		BorderPane borderPane = new BorderPane();
		borderPane.setStyle("-fx-background-color: #141617");

		Hand senteHand = new Hand("player");
		Hand goteHand = new Hand("opponent");

		borderPane.setLeft(senteHand);
		borderPane.setRight(goteHand);

		BorderPane.setAlignment(senteHand, Pos.BOTTOM_LEFT);
		BorderPane.setAlignment(goteHand, Pos.TOP_RIGHT);


		//Create scene
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
		primaryStage.setMinHeight(600);
		primaryStage.setMinWidth(600);
        primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}