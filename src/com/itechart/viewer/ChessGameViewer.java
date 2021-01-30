package com.itechart.viewer;

public interface ChessGameViewer {

    void greetings();

    void displayBoard();

    void showWhoMovesNext();

    void askToPickFigureStartSquare();

    void askToPickFigureEndSquare();

    void showSquareTypedIsIncorrect(String squareId);

    void showMoveIsNotValid();

    void showWinner();
}
