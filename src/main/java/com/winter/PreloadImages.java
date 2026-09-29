package com.winter;

import java.util.HashMap;

import javafx.scene.image.Image;

public class PreloadImages {
	public HashMap<String, Image> pieceImages = new HashMap<>();
	public HashMap<String, Image> boardImages = new HashMap<>();

	PreloadImages(){
		//I would have *much* preferred to list all files in the directory and use that, but i couldn't make it work with javafx. maybe another time
		final String[] pieceNameList = {"Bishop", "Gold", "Silver", "Jewel", "King", "Knight", "Lance", "Pawn", "Rook"};
		final String playerPieceFolderPath = "/com/winter/images/pieces/player";
		final String opponentPieceFolderPath = "/com/winter/images/pieces/opponent";
		final String boardFolderPath = "/com/winter/images/boards";

		for(String pieceName : pieceNameList){
			pieceImages.put("player" + pieceName, new Image(getClass().getResource(playerPieceFolderPath + "/player" + pieceName + ".jpg").toExternalForm()));
			pieceImages.put("opponent" + pieceName, new Image(getClass().getResource(opponentPieceFolderPath + "/opponent" + pieceName + ".jpg").toExternalForm()));
		}
		boardImages.put("lightYellowBoard", new Image(getClass().getResource(boardFolderPath + "/light-yellow.jpg").toExternalForm()));
	}

	
}
