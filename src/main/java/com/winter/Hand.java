package com.winter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;

public class Hand extends VBox{
	final Double handWidth = 50d; //width of each player's hand
	Image handImage = new Image(getClass().getResource("/com/winter/images/boards/hand2.png").toExternalForm());
	BackgroundImage handBackgroundImage = new BackgroundImage(handImage,
		javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
		javafx.scene.layout.BackgroundRepeat.NO_REPEAT,
		BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT
	);
	Background handBackground = new Background(handBackgroundImage);

	Insets handInsets = new Insets(50, 0, 0, 0);
	Hand(String side){
		setBackground(handBackground);
		setMinWidth(handWidth);
		setMaxWidth(handImage.getWidth());
		setMaxHeight(handImage.getHeight());
		setAlignment(Pos.TOP_CENTER);
		setPadding(handInsets);

		if(side.equals("gote")){
			setScaleX(-1);
			setScaleY(-1);
		}
	}
}
