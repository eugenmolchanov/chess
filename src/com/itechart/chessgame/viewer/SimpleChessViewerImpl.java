package com.itechart.chessgame.viewer;

import com.itechart.chessgame.board.Board;

public class SimpleChessViewerImpl implements ChessGameViewer {

    private Board board;

    public SimpleChessViewerImpl(Board board) {
        this.board = board;
    }

    @Override
    public void greetings() {
        System.out.println("The game is starting...");
        System.out.println();
    }

    @Override
    public void displayBoard() {
        System.out.println(board.getCurrentBoardStateView());
    }

    @Override
    public void showWhoMovesNext() {
        System.out.println(board.nextPlayerMove() + " player moves.");
    }

    @Override
    public void askToPickFigureStartSquare() {
        System.out.println("Pick a figure to move. Enter a square identifier (starts from a letter):");
    }

    @Override
    public void askToPickFigureEndSquare() {
        System.out.println("Pick a square to finish move. Enter a square identifier (starts from a letter):");
    }

    @Override
    public void showSquareTypedIsIncorrect(String squareId) {
        System.out.println(squareId + " square is not exist. Please, enter existing one.");
    }

    @Override
    public void showMoveIsNotValid() {
        System.out.println("Move is forbidden. Let's pick a move one more time.");
    }

    @Override
    public void showWinner() {
        System.out.println("Player number " + board.lastPlayerMove() + " won on the move number " + board.movesMadeNumber());
    }
}
