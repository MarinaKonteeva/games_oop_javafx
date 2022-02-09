package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getX() - position.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - position.getX() > 0 ? 1 : -1;
        int deltaY = dest.getY() - position.getY() > 0 ? 1 : -1;
        for (int index = 0; index < size; index++) {
            int i = index + 1;
            steps[index] = Cell.findBy(position.getX() + deltaX * i, position.getY() + deltaY * i);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = dest.getX();
        int y2 = dest.getY();

        if (x1 - x2 == y1 - y2 || x1 - x2 == y2 - y1) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
