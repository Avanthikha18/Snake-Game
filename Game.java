import java.util.Scanner;

class Game {
    Grid grid;
    Snake snake;
    Food food;
    String direction;
    Scanner sc;

    Game() {
        grid = new Grid(10, 10);
        snake = new Snake();
        food = new Food(grid.width, grid.height);
        direction = "RIGHT";
        sc = new Scanner(System.in);
    }

    void updateDirection() {
        System.out.print("Enter move (W/A/S/D): ");
        char ch = sc.next().toUpperCase().charAt(0);

        if (ch == 'W' && !direction.equals("DOWN")) {
            direction = "UP";
        } else if (ch == 'S' && !direction.equals("UP")) {
            direction = "DOWN";
        } else if (ch == 'A' && !direction.equals("RIGHT")) {
            direction = "LEFT";
        } else if (ch == 'D' && !direction.equals("LEFT")) {
            direction = "RIGHT";
        }
    }

    Position getNextHead() {
        Position head = snake.getHead();
        int x = head.x;
        int y = head.y;

        if (direction.equals("UP")) x--;
        else if (direction.equals("DOWN")) x++;
        else if (direction.equals("LEFT")) y--;
        else if (direction.equals("RIGHT")) y++;

        return new Position(x, y);
    }

    boolean isGameOver(Position nextHead) {
        // Wall collision
        if (!grid.isInside(nextHead)) return true;

        // Self collision
        for (Position p : snake.body) {
            if (p.isEqual(nextHead)) return true;
        }

        return false;
    }

    void printBoard() {
        for (int i = 0; i < grid.width; i++) {
            for (int j = 0; j < grid.height; j++) {

                Position p = new Position(i, j);
                boolean isSnake = false;

                for (Position s : snake.body) {
                    if (s.isEqual(p)) {
                        isSnake = true;
                        break;
                    }
                }

                if (isSnake) {
                    System.out.print("S ");
                } else if (p.isEqual(food.foodPos)) {
                    System.out.print("F ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    void play() {
        while (true) {
            updateDirection();

            Position nextHead = getNextHead();

            if (isGameOver(nextHead)) {
                System.out.println("Game Over!");
                break;
            }

            boolean grow = nextHead.isEqual(food.foodPos);

            snake.move(nextHead, grow);

            if (grow) {
                food = new Food(grid.width, grid.height);
            }

            printBoard();
        }
    }
}