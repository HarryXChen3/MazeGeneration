package personal.mazegeneration.main.shared;

import java.util.Collection;

public interface MazeBase<T extends CellBase> {
    int getXSize();
    int getYSize();

    T getCellAt(final int x, final int y);
    void setCellAt(final int x, final int y, final T cell);
    Collection<T> getYRow(final int y);
    Collection<T> getXRow(final int x);
}
