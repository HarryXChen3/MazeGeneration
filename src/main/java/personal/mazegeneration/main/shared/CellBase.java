package personal.mazegeneration.main.shared;

public interface CellBase {
    int getX();
    int getY();

    boolean hasNorth();
    void setNorth(final boolean north);

    boolean hasEast();
    void setEast(final boolean east);

    boolean hasSouth();
    void setSouth(final boolean south);

    boolean hasWest();
    void setWest(final boolean west);
}
