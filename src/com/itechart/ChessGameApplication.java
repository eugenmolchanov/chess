package com.itechart;

import com.itechart.board.Board;
import com.itechart.board.ClassicChessBoardImpl;
import com.itechart.executor.ChessExecutorImpl;
import com.itechart.viewer.ChessGameViewer;
import com.itechart.viewer.SimpleChessViewerImpl;

public class ChessGameApplication {

    public static void main(String[] args) {
        Board board = new ClassicChessBoardImpl();
        ChessGameViewer chessGameViewer = new SimpleChessViewerImpl(board);
	    ChessExecutorImpl chessExecutorImpl = new ChessExecutorImpl(board, chessGameViewer);
	    chessExecutorImpl.run();
    }
}
