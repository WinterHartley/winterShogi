package com.winter;

import java.util.HashMap;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
		handImage = ShogiApp.images.boardImages.get("hand");
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
		final Double pieceSize = (handImage.getHeight() - handInsets.getTop()) / pieceNames.length - 1; //-1 prevents pieces *slightly* breaking the bottom
		for(String piece : pieceNames){
			ImageView view = new ImageView(ShogiApp.images.pieceImages.get(side + piece));
			view.setPreserveRatio(true);
			view.setFitHeight(pieceSize);
			if(piecesInHand.get(piece) == 0)
				view.setOpacity(0.5); //If not in hand, make partially opaque
			
			StackPane stackPane = new StackPane(view);
			stackPane.setId(piece); //used to identify which piece is which for when updating hand content
			stackPane.setMaxWidth(view.getFitWidth());
			stackPane.setMaxHeight(view.getFitHeight());
			//add number to bottom right of stackpane
			Label label = new Label(piecesInHand.get(piece).toString());
			label.setStyle("-fx-background-color: #141617; -fx-text-fill: whitesmoke;");
			label.setBorder(Border.stroke(Color.WHITESMOKE));
			stackPane.getChildren().add(label);
			StackPane.setAlignment(label, Pos.BOTTOM_RIGHT);
			
			if(side.equals("opponent")){
				//Undo flipping of the icons
				stackPane.setScaleX(-1);
				stackPane.setScaleY(-1);
			}
			getChildren().add(stackPane);
		}
	}

	public int getPieceNum(String pieceName){
		return piecesInHand.get(pieceName);
	}

	public void setPieceNum(String pieceName, int num){
		piecesInHand.put(pieceName, num);

		//Update label and imageview
		for(Node child : getChildren()){
			if(child.getId().equals(pieceName)){
				StackPane stack = (StackPane) child; //all children are stackpanes, so this is safe. need to convert to get required methods to update content
				ObservableList<Node> grandChildren = stack.getChildren();

				if(grandChildren.get(0) instanceof ImageView){
					if(num > 0){
						grandChildren.get(0).setOpacity(1);
					} else{
						grandChildren.get(0).setOpacity(0.5);
					}
				}

				if(grandChildren.get(1) instanceof Label){
					Label label = (Label) grandChildren.get(1);
					label.setText(Integer.toString(num));
				}
				break;
			}
		}
	}
}
