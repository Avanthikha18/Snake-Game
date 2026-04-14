class Grid {
    int width;
    int height;

    Grid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    boolean isInside(Position p) {
        if (p.x < 0 || p.x >= width) return false;
        if (p.y < 0 || p.y >= height) return false;
        return true;
    }
}