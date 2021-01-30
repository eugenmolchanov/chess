package com.itechart.board;

public interface Board {

    /**
     * Creates a string representation of the current board state.
     * @return string view of the board
     */
    String getCurrentBoardStateView();

    /**
     * Checks whether the game is finished.
     * @return finish game flag
     */
    boolean isGameFinished();

    /**
     * Identifies the total number of made moves.
     * @return the number of made moves
     */
    int movesMadeNumber();

    /**
     * Identifies who should move next.
     * @return next move player number
     */
    int nextPlayerMove();

    /**
     * Identifies who moved last.
     * @return last move player number
     */
    int lastPlayerMove();

    /**
     * Checks whether the game board actually has this square.
     * @param squareId id of the square
     * @return square existence flag
     */
    boolean isMoveCellExist(String squareId);

    /**
     * Checks whether the move with the defined start square and end square can be executed.
     * @param startSquareId id of the move start square. There should be a figure of the player who moves
     * @param endSquareId id of the move end square
     * @return ability to move flag
     * @throws IllegalArgumentException if startSquareId or endSquareId are not valid ids. They should exist on the board.
     */
    boolean isMoveValid(String startSquareId, String endSquareId);

    /**
     * Makes actual move and changes the board state
     * @param startSquareId id of the move start square
     * @param endSquareId id of the move end square
     * @throws IllegalArgumentException if startSquareId or endSquareId are not valid ids. They should exist on the board.
     */
    void makeMove(String startSquareId, String endSquareId);
}
