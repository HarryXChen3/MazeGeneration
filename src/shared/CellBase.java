package shared;

public interface CellBase {
    int x = 0;
    int y = 0;

    boolean north = true;
    boolean east = true;
    boolean south = true;
    boolean west = true;

    default int getX() { return x; }
    default int getY() { return y; }

    default boolean hasNorth() { return north; }
    void setNorth(final boolean north);

    default boolean hasEast() { return east; }
    void setEast(final boolean east);

    default boolean hasSouth() { return south; }
    void setSouth(final boolean south);

    default boolean hasWest() { return west; }
    void setWest(final boolean west);
}
