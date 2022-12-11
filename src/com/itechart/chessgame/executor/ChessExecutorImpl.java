package com.itechart.chessgame.executor;

import com.itechart.chessgame.board.Board;
import com.itechart.chessgame.viewer.ChessGameViewer;

import java.util.Scanner;

public class ChessExecutorImpl implements ChessExecutor {

    private Board board;
    private ChessGameViewer gameViewer;

    public ChessExecutorImpl(Board board, ChessGameViewer chessGameViewer) {
        this.board = board;
        this.gameViewer = chessGameViewer;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            String startSquareId;
            String endSquareId;

            gameViewer.greetings();
            while (!board.isGameFinished()) {
                gameViewer.displayBoard();
                gameViewer.showWhoMovesNext();

                startSquareId = enterSquare(scanner, gameViewer::askToPickFigureStartSquare);
                endSquareId = enterSquare(scanner, gameViewer::askToPickFigureEndSquare);

                while (!board.isMoveValid(startSquareId, endSquareId)) {
                    gameViewer.showMoveIsNotValid();
                    startSquareId = enterSquare(scanner, gameViewer::askToPickFigureStartSquare);
                    endSquareId = enterSquare(scanner, gameViewer::askToPickFigureEndSquare);
                }

                board.makeMove(startSquareId, endSquareId);
            }

            gameViewer.showWinner();
        }
    }

    private String enterSquare(Scanner scanner, Message message) {
        message.show();
        String squareId = scanner.next();

        while (!board.isMoveCellExist(squareId)) {
            gameViewer.showSquareTypedIsIncorrect(squareId);
            squareId = scanner.next();
        }

        return squareId;
    }

    @FunctionalInterface
    private interface Message {
        void show();
    }
}
