import java.util.LinkedList;

class Snake {
    LinkedList<Position> body;

    Snake() {
        body = new LinkedList<>();
        body.add(new Position(5, 5)); // initial position
    }

    Position getHead() {
        return body.getFirst();
    }

    void move(Position newHead, boolean grow) {
        body.addFirst(newHead);

        if (!grow) {
            body.removeLast();
        }
    }
}