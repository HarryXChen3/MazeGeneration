package shared;

import java.util.Collection;

public interface MazeBase<T extends CellBase> {
    int xSize = 0;
    int ySize = 0;

    default int getXSize() { return xSize; }
    default int getYSize() { return ySize; }

    T getCellAt(final int x, final int y);
    void setCellAt(final int x, final int y, final T cell);
    Collection<T> getYRow(final int y);
    Collection<T> getXRow(final int x);
}
