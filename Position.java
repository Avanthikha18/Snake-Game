class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isEqual(Position p) {
        return this.x == p.x && this.y == p.y;
    }
}