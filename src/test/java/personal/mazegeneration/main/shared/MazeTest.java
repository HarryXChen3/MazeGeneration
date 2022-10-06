package personal.mazegeneration.main.shared;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ListIterator;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazeTest {
    private static final int xDim = 10;
    private static final int yDim = 10;
    private static final BiFunction<Integer, Integer, Cell> constructor = Cell::new;

    @ParameterizedTest
    @MethodSource("MazeIterTest")
    public void MazeForwardIterTest(final int xSize, final int ySize) {
        final Maze<Cell> maze = new Maze<>(xSize, ySize, constructor);
        for (final ListIterator<Cell> iterator = maze.iterator(); iterator.hasNext();) {
            final int rawIndex = iterator.nextIndex();

        }
    }

    @ParameterizedTest
    @MethodSource("MazeIterTest")
    public void MazeBackwardsIterTest(final int xSize, final int ySize) {
        final Maze<Cell> maze = new Maze<>(xSize, ySize, constructor);
        for (final ListIterator<Cell> iterator = maze.iterator((ySize * xSize) - 1); iterator.hasPrevious();) {
            final int rawIndex = iterator.previousIndex();
            final Cell cell = iterator.previous();

            assertEquals((Math.max(0, rawIndex) % xSize), cell.getX());
            assertEquals((rawIndex / xSize) + 1, cell.getY());

            //System.out.printf("(%d, %d); ", cell.getX(), cell.getY());
            //System.out.print(cell.getX() == (0) ? "\n" : "");
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
