public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isOn(int x, int y) {
        return this.x == x && this.y == y;
    }
}
