package org.academiadecodigo.chess.movable.piece;

public enum Player {
    BLACK("black-"),
    WHITE("white-");

    private String filePath;

    Player(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
