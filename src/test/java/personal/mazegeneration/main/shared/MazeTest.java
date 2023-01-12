package personal.mazegeneration.main.shared;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ListIterator;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazeTest {
    private static final int xDim = 50;
    private static final int yDim = 50;
    private static final BiFunction<Integer, Integer, Cell> constructor = Cell::new;

    @ParameterizedTest
    @MethodSource("MazeIterTest")
    public void MazeForwardIterTest(final int xSize, final int ySize) {
        final Maze<Cell> maze = new Maze<>(xSize, ySize, constructor);
        for (final ListIterator<Cell> iterator = maze.iterator(); iterator.hasNext();) {
            final int rawIndex = iterator.nextIndex();
            final Cell cell = iterator.next();

            assertEquals((Math.max(0, rawIndex) % xSize), cell.getX());
            assertEquals(rawIndex / xSize, cell.getY());
        }
    }

    @ParameterizedTest
    @MethodSource("MazeIterTest")
    public void MazeBackwardsIterTest(final int xSize, final int ySize) {
        final Maze<Cell> maze = new Maze<>(xSize, ySize, constructor);
        for (final ListIterator<Cell> iterator = maze.iterator(ySize * xSize); iterator.hasPrevious();) {
            final int rawIndex = iterator.previousIndex();
            final Cell cell = iterator.previous();

            assertEquals((Math.max(0, rawIndex) % xSize), cell.getX());
            assertEquals(rawIndex / xSize, cell.getY());
        }
    }

    private static Stream<Arguments> MazeIterTest() {
        final Stream.Builder<Arguments> builder = Stream.builder();
        for (int x = 0; x < xDim; x++)
            for (int y = 0; y < yDim; y++)
                builder.add(Arguments.of(x, y));
        return builder.build();
    }
}
