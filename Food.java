import java.util.Random;

class Food {
    Position foodPos;

    Food(int width, int height) {
        Random rand = new Random();
        int x = rand.nextInt(width);
        int y = rand.nextInt(height);
        foodPos = new Position(x, y);
    }
}