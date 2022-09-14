package personal.mazegeneration.main.shared;

public class Cell implements CellBase {
    final int x;
    final int y;

    boolean north = true;
    boolean east = true;
    boolean south = true;
    boolean west = true;

    public Cell(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Cell(
            final int x,
            final int y,
            final boolean north,
            final boolean east,
            final boolean south,
            final boolean west) {
        this(x, y);
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public boolean hasNorth() { return north; }
    public void setNorth(final boolean north) { this.north = north; }

    public boolean hasEast() { return east; }
    public void setEast(final boolean east) { this.east = east; }

    public boolean hasSouth() { return south; }
    public void setSouth(final boolean south) { this.south = south; }

    public boolean hasWest() { return west; }
    public void setWest(final boolean west) { this.west = west; }
}
