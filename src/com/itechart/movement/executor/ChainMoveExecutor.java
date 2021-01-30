package com.itechart.movement.executor;

import com.itechart.figure.Figure;
import com.itechart.movement.type.Move;
import com.itechart.square.Square;
import com.itechart.square.SquareId;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ChainMoveExecutor implements FigureMoveExecutor {

    private ChainMoveExecutor() {

    }

    private static final ChainMoveExecutor INSTANCE = new ChainMoveExecutor();

    public static ChainMoveExecutor getInstance() {
        return INSTANCE;
    }

    @Override
    public Set<SquareId> executeMove(MoveExecutorDto moveExecutorDto) {
        Set<SquareId> possibleMoves = new HashSet<>();
        for (Move move : moveExecutorDto.getMoves()) {
            Optional<SquareId> optionalSquareId = moveExecutorDto.getNextMoveSquareId().apply(moveExecutorDto.getSquareId(), move, moveExecutorDto.getFigure());
            if (!optionalSquareId.isPresent()) {
                return possibleMoves;
            }

            SquareId moveSquareId = optionalSquareId.get();
            Square square = moveExecutorDto.getSquareById().apply(moveSquareId);
            Figure squareFigure = square.getFigure();
            if (squareFigure != null) {
                if (isMoveOnlyMove(move) || isGoingToHitOwnFigure(moveExecutorDto.getNextPlayerMove().get(), squareFigure)) {
                    return possibleMoves;
                }

                possibleMoves.add(moveSquareId);
                return possibleMoves;
            }

            if (isHitOnlyMove(move)) {
                return possibleMoves;
            }

            possibleMoves.add(moveSquareId);
        }

        return possibleMoves;
    }
}
