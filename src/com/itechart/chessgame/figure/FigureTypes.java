package com.itechart.chessgame.figure;

import com.itechart.chessgame.movement.executor.ChainMoveExecutor;
import com.itechart.chessgame.movement.executor.FigureMoveExecutor;
import com.itechart.chessgame.movement.type.Move;
import com.itechart.chessgame.movement.type.MoveTypeFactory;

import java.util.List;

public enum FigureTypes {
    BISHOP("Bp", MoveTypeFactory.bishopMoves(), ChainMoveExecutor.getInstance()),
    KING("Kg", MoveTypeFactory.kingMoves(), ChainMoveExecutor.getInstance()),
    KNIGHT("Kt", MoveTypeFactory.knightMoves(), ChainMoveExecutor.getInstance()),
    PAWN("Pn", MoveTypeFactory.pawnMoves(), ChainMoveExecutor.getInstance()),
    QUEEN("Qn", MoveTypeFactory.queenMoves(), ChainMoveExecutor.getInstance()),
    ROOK("Rk", MoveTypeFactory.rookMoves(), ChainMoveExecutor.getInstance());

    private String name;
    private List<List<Move>> moveTypes;
    private FigureMoveExecutor figureMoveExecutor;

    FigureTypes(String name, List<List<Move>> moveTypes, FigureMoveExecutor figureMoveExecutor) {
        this.name = name;
        this.moveTypes = moveTypes;
        this.figureMoveExecutor = figureMoveExecutor;
    }

    public String getName() {
        return name;
    }

    public List<List<Move>> getMoveTypes() {
        return moveTypes;
    }

    public FigureMoveExecutor getFigureMoveExecutor() {
        return figureMoveExecutor;
    }
}
