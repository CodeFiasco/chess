package org.academiadecodigo.chess.movable.piece;

public enum PieceType {
    KING("king.png"),
    QUEEN("queen.png");

    private String filePath;

    PieceType(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
