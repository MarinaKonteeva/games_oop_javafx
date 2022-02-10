package ru.job4j.chess;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KingBlack;

public class LogicTest {

    @Test(expected = OccupiedCellException.class)
    public void testMoveOccupiedCellException()
            throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.G5);
        Figure figure = new KingBlack(Cell.D2);
        logic.add(bishopBlack);
        logic.add(figure);
        logic.move(Cell.C1, Cell.G5);
    }

    @Test(expected = FigureNotFoundException.class)
    public void testMoveFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.G5);
        Figure figure = new KingBlack(Cell.D3);
        logic.add(bishopBlack);
        logic.add(figure);
        logic.move(Cell.D2, Cell.G5);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void testMoveImpossibleMoveException()
            throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells = bishopBlack.way(Cell.G6);
        Figure figure = new KingBlack(Cell.D3);
        logic.add(bishopBlack);
        logic.add(figure);
        logic.move(Cell.D2, Cell.G5);
    }
}