package com.itechart.chessgame.board;

import com.itechart.chessgame.figure.Color;
import com.itechart.chessgame.figure.Figure;
import com.itechart.chessgame.figure.FigureTypes;
import com.itechart.chessgame.movement.executor.MoveExecutorDto;
import com.itechart.chessgame.movement.executor.MoveExecutorDtoImpl;
import com.itechart.chessgame.movement.type.Move;
import com.itechart.chessgame.square.Square;
import com.itechart.chessgame.square.SquareId;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassicChessBoardImpl implements Board {

    private static final String EMPTY_LETTER_NOTATION_VIEW = "  ";
    private static final String A_LETTER_NOTATION_VIEW = " A  ";
    private static final String B_LETTER_NOTATION_VIEW = " B  ";
    private static final String C_LETTER_NOTATION_VIEW = " C  ";
    private static final String D_LETTER_NOTATION_VIEW = " D  ";
    private static final String E_LETTER_NOTATION_VIEW = " E  ";
    private static final String F_LETTER_NOTATION_VIEW = " F  ";
    private static final String G_LETTER_NOTATION_VIEW = " G  ";
    private static final String H_LETTER_NOTATION_VIEW = " H  ";

    private Map<Integer, List<Square>> board;
    private final int ROW_NUMBER = 8;
    private int movesMadeNumber = 0;
    private final List<Character> LETTER_NOTATIONS = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
    private final List<Integer> NUMERIC_NOTATIONS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

    private Map<Character, Integer> fileToSquareIndex;
    private Map<Integer, Character> squareIndexToFile;

    public ClassicChessBoardImpl() {
        this.board = new InitialBoardStateFactory().getBoardContainer();
        this.fileToSquareIndex = new HashMap<>();
        this.squareIndexToFile = new HashMap<>();
        for (int i = 0; i < LETTER_NOTATIONS.size(); i++) {
            this.fileToSquareIndex.put(LETTER_NOTATIONS.get(i), i);
            this.squareIndexToFile.put(i, LETTER_NOTATIONS.get(i));
        }
    }

    @Override
    public String getCurrentBoardStateView() {
        StringBuilder sb = new StringBuilder();
        addLetterNotations(sb);
        sb.append("\n");

        for (int rowNumber = ROW_NUMBER; rowNumber > 0; rowNumber--) {
            sb.append(rowNumber).append(" ");
            this.board.get(rowNumber).forEach(square -> sb.append(square).append(" "));
            sb.append(rowNumber).append("\n");
        }

        addLetterNotations(sb);

        return sb.toString();
    }

    @Override
    public boolean isGameFinished() {
        int kingCount = 0;
        for (int rowNumber = 1; rowNumber <= ROW_NUMBER; rowNumber++) {
            List<Square> kingSquares = this.board.get(rowNumber).stream()
                    .filter(square -> square.getFigure() != null && square.getFigure().getFigureType() == FigureTypes.KING)
                    .collect(Collectors.toList());
            kingCount += kingSquares.size();
            if (kingCount == 2) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int movesMadeNumber() {
        return this.movesMadeNumber;
    }

    @Override
    public int nextPlayerMove() {
        return this.movesMadeNumber % 2 == 0 ? 1 : 2;
    }

    @Override
    public int lastPlayerMove() {
        return this.movesMadeNumber % 2 == 0 ? 2 : 1;
    }

    @Override
    public boolean isMoveCellExist(String squareId) {
        return isSquareIdValid(squareId);
    }

    @Override
    public void makeMove(String startSquareId, String endSquareId) {
        validateIds(startSquareId, endSquareId);

        Square startSquare = getSquareById(squareId(startSquareId));
        Figure figure = startSquare.getFigure();
        startSquare.setFigure(null);

        Square endSquare = getSquareById(squareId(endSquareId));
        endSquare.setFigure(figure);

        this.movesMadeNumber++;
    }

    @Override
    public boolean isMoveValid(String startSquareId, String endSquareId) {
        validateIds(startSquareId, endSquareId);

        SquareId startId = squareId(startSquareId);
        return isStartSquareContainsMovePlayerFigure(startId) && isMoveValid(startId, squareId(endSquareId));
    }

    private void addLetterNotations(StringBuilder sb) {
        sb.append(EMPTY_LETTER_NOTATION_VIEW)
                .append(A_LETTER_NOTATION_VIEW)
                .append(B_LETTER_NOTATION_VIEW)
                .append(C_LETTER_NOTATION_VIEW)
                .append(D_LETTER_NOTATION_VIEW)
                .append(E_LETTER_NOTATION_VIEW)
                .append(F_LETTER_NOTATION_VIEW)
                .append(G_LETTER_NOTATION_VIEW)
                .append(H_LETTER_NOTATION_VIEW)
                .append(EMPTY_LETTER_NOTATION_VIEW);
    }

    private boolean isSquareIdValid(String id) {
        if (id == null || id.length() != 2) {
            return false;
        }

        char[] notations = id.toCharArray();

        char letterNotation = notations[0];
        char numericNotation = notations[1];

        return Character.isLetter(letterNotation) && LETTER_NOTATIONS.contains(letterNotation) &&
                Character.isDigit(numericNotation) && NUMERIC_NOTATIONS.contains(Character.getNumericValue(numericNotation));
    }

    private void validateIds(String startSquareId, String endSquareId) {
        if (!isSquareIdValid(startSquareId)) {
            throw new IllegalArgumentException(startSquareId + " is not valid square id.");
        }

        if (!isSquareIdValid(endSquareId)) {
            throw new IllegalArgumentException(endSquareId + " is not valid square id.");
        }
    }

    private Square getSquareById(SquareId squareId) {
        return this.board.get(squareId.getRank()).get(this.fileToSquareIndex.get(squareId.getFile()));
    }

    private SquareId squareId(String squareId) {
        char[] notations = squareId.toCharArray();

        char letterNotation = notations[0];
        char numericNotation = notations[1];

        return new SquareId(letterNotation, Character.getNumericValue(numericNotation));
    }

    private boolean isStartSquareContainsMovePlayerFigure(SquareId id) {
        Square square = getSquareById(id);
        Figure figure = square.getFigure();
        if (figure == null) {
            return false;
        }

        Color color = figure.getColor();
        if (nextPlayerMove() == 1 && color != Color.WHITE) {
            return false;
        }

        return nextPlayerMove() != 2 || color == Color.BLACK;
    }

    private boolean isMoveValid(SquareId startSquareId, SquareId endSquareId) {
        Set<SquareId> possibleMoves = getPossibleMoveSquares(startSquareId);
        return possibleMoves.contains(endSquareId);
    }

    private Set<SquareId> getPossibleMoveSquares(SquareId squareId) {
        Square square = getSquareById(squareId);
        Figure figure = square.getFigure();

        Set<SquareId> possibleMoves = new HashSet<>();
        for (List<Move> allMoves : figure.getMoveTypes()) {
            MoveExecutorDto moveExecutorDtoImpl = new MoveExecutorDtoImpl.MoveExecutorBuilder(this::nextMoveSquareId, this::getSquareById, this::nextPlayerMove)
                    .withMoves(allMoves)
                    .withFigure(figure)
                    .withSquareId(squareId)
                    .build();

            Set<SquareId> moves = figure.getFigureMoveExecutor().executeMove(moveExecutorDtoImpl);
            possibleMoves.addAll(moves);
        }

        return possibleMoves;
    }

    private Optional<SquareId> nextMoveSquareId(SquareId startSqId, Move move, Figure figure) {
        Integer currentCol = this.fileToSquareIndex.get(startSqId.getFile());
        if (currentCol == null) {
            return Optional.empty();
        }

        Character file = this.squareIndexToFile.get(currentCol + move.getxDelta());
        if (file == null) {
            return Optional.empty();
        }

        int currentRow = startSqId.getRank();

        int rank = figure.getColor() == Color.WHITE ? currentRow + move.getyDelta() : currentRow - move.getyDelta();
        if (!NUMERIC_NOTATIONS.contains(rank) || !LETTER_NOTATIONS.contains(file)) {
            return Optional.empty();
        }

        return Optional.of(new SquareId(file, rank));
    }
}
