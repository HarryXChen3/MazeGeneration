package personal.mazegeneration.main.shared;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    @Test
    public void CellCreationTest() {
        final int[] xCoords = IntStream.range(0, 100).toArray();
        final int[] yCoords = IntStream.range(0, 100).toArray();

        for (final int x : xCoords) {
            for (final int y : yCoords) {
                final Cell testCell = new Cell(x, y);
                assertEquals(x, testCell.getX());
                assertEquals(y, testCell.getY());
            }
        }
    }
}
