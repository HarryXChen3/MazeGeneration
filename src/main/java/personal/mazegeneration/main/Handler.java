package personal.mazegeneration.main;

import personal.mazegeneration.main.shared.Cell;
import personal.mazegeneration.main.shared.Maze;

public class Handler {
    public static void main(final String[] args) {
        final Maze<Cell> maze = new Maze<>(100, 100, Cell::new);
        for (final Cell cell : maze) {
            System.out.printf("(%d, %d); ", cell.getX(), cell.getY());
            System.out.print(cell.getX() == (maze.getXSize() - 1) ? "\n" : "");
        }
    }
}
