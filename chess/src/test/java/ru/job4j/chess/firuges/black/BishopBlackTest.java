package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

public class BishopBlackTest {

    @Test
    public void testPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        Cell cell = bishopBlack.position();
        Assert.assertEquals(Cell.B2, cell);
    }

    @Test
    public void testCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        Cell cell = bishopBlack.copy(Cell.B5).position();
        Assert.assertEquals(Cell.B5, cell);
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cells1 = bishopBlack.way(Cell.G5);
        Cell[] cells2 = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(cells1, cells2);
    }

    @Test
    public void testIsDiagonalTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean res = bishopBlack.isDiagonal(Cell.E1, Cell.A5);
        Assert.assertTrue(res);
    }

    @Test
    public void testIsDiagonalFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        boolean res = bishopBlack.isDiagonal(Cell.E1, Cell.A6);
        Assert.assertFalse(res);
    }
}