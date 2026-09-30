package com.winter;

import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

public class Hand extends VBox{
	private HashMap<String, Integer> piecesInHand = new HashMap<>();

	Hand(String side){
		//Init empty hand
		String[] pieceNames = {"Rook", "Bishop", "Gold", "Silver", "Knight", "Lance", "Pawn"};
		for(String piece : pieceNames){
			piecesInHand.put(piece, 0);
		}

		//Graphics display
		Insets handInsets = new Insets(60,0,0,0);
		Image handImage;

		//Gets correct image
		handImage = new Image(getClass().getResource("/com/winter/images/boards/hand.png").toExternalForm());
		BackgroundImage handBackgroundImage = new BackgroundImage(handImage,
			javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
			javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.DEFAULT,
			BackgroundSize.DEFAULT
		);
		Background handBackground = new Background(handBackgroundImage);

		setBackground(handBackground);
		setMinWidth(handImage.getWidth());
		setMaxWidth(handImage.getWidth());
		setMaxHeight(handImage.getHeight());
		setAlignment(Pos.TOP_CENTER);
		setPadding(handInsets);
		if(side.equals("opponent")){
			setScaleX(-1);
			setScaleY(-1);
		}

		//Add content
		final Double pieceSize = (handImage.getHeight() - handInsets.getTop()) / pieceNames.length;
		for(String piece : pieceNames){
			ImageView view = new ImageView(ShogiApp.images.pieceImages.get(side + piece));
			view.setPreserveRatio(true);
			view.setFitHeight(pieceSize);
			if(piecesInHand.get(piece) == 0)
				view.setOpacity(0.5); //If not in hand, make partially opaque
			if(side.equals("opponent")){
				//Undo flipping of the icons
				view.setScaleX(-1);
				view.setScaleY(-1);
			}
			getChildren().add(view);
		}
	}
}
