package com.itechart.chessgame;

import com.itechart.chessgame.board.Board;
import com.itechart.chessgame.board.ClassicChessBoardImpl;
import com.itechart.chessgame.executor.ChessExecutorImpl;
import com.itechart.chessgame.viewer.ChessGameViewer;
import com.itechart.chessgame.viewer.SimpleChessViewerImpl;

public class ChessGameApplication {

    public static void main(String[] args) {
        Board board = new ClassicChessBoardImpl();
        ChessGameViewer chessGameViewer = new SimpleChessViewerImpl(board);
	    ChessExecutorImpl chessExecutorImpl = new ChessExecutorImpl(board, chessGameViewer);
	    chessExecutorImpl.run();
    }
}
