package personal.mazegeneration.main.shared;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;

public class Maze<T extends Cell> implements Iterable<T>, MazeBase<T> {
    private final int xSize;
    private final int ySize;
    private final List<List<T>> maze;

    public Maze(final BiFunction<Integer, Integer, T> constructor) {
        this(0, 0, constructor);
    }

    public Maze(final int xSize, final int ySize, final BiFunction<Integer, Integer, T> constructor) {
        this(xSize, ySize, new ArrayList<>(ySize));

        for (int yDim = 0; yDim < ySize; yDim++) {
            final List<T> xCells = new ArrayList<>(xSize);
            for (int xDim = 0; xDim < xSize; xDim++) {
                xCells.add(constructor.apply(xDim, yDim));
            }

            maze.add(xCells);
        }
    }

    public Maze(final int xSize, final int ySize, final List<List<T>> maze) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.maze = maze;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int xDim = 0;
            private int yDim = 0;
            private List<T> yRow;

            @Override
            public boolean hasNext() {
                return (yDim < (ySize - 1)) || (xDim < (xSize - 1)) || (xDim == 0 && yRow == null && xSize > 0);
            }

            @Override
            public T next() {
                if (xDim < (xSize - 1) || (xDim == 0 && xSize > 0))
                    return (yRow == null ? ((yRow = maze.get(yDim)).get(xDim)) : (yRow.get(++xDim)));
                else
                    return (yRow = maze.get(++yDim)).get(xDim = 0);
            }
        };
    }

    public int getXSize() { return xSize; }
    public int getYSize() { return ySize; }

    public T getCellAt(final int x, final int y) {
        if (x < 0 || y < 0 || x > (xSize - 1) || y > (ySize - 1))
            throw new RuntimeException("Attempt to access cell out of bounds!");

        return maze.get(y).get(x);
    }

    public void setCellAt(final int x, final int y, final T cell) {
        if (x < 0 || y < 0 || x > (xSize - 1) || y > (ySize - 1))
            throw new RuntimeException("Attempt to set cell out of bounds!");

        maze.get(y).set(x, cell);
    }

    public List<T> getYRow(final int y) {
        if (y < 0 || y > (ySize - 1))
            throw new RuntimeException("Attempt to access yRow out of bounds!");

        return maze.get(y);
    }

    public List<T> getXRow(final int x) {
        if (x < 0 || x > (xSize - 1))
            throw new RuntimeException("Attempt to access xRow out of bounds!");

        final List<T> xRow = new ArrayList<>(xSize);
        for (final List<T> yRow : maze)
            xRow.add(yRow.get(x));

        return xRow;
    }
}
