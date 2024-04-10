package Middle.Parking;

public class Parking {
    private int capacity;
    private int occupiedSpaces;

    public Parking(int capacity, int occupiedSpaces) {
        this.capacity = capacity;
        this.occupiedSpaces = occupiedSpaces;
    }

    public boolean isFull() {
        return occupiedSpaces >= capacity;
    }

    public void push() {
        if (!isFull()) {
            occupiedSpaces++;
            System.out.println("Машина заехала на парковку " + "Свободныъ мест осталось " + occupiedSpaces);
        } else {
            System.out.println(" Свободных мест на парковке нет, въезд запрещен !");
        }
    }

    public void pop() {
        if (occupiedSpaces > 0) {
            occupiedSpaces--;
            System.out.println("Машина выехала с парковки " + "Свободных мест " + occupiedSpaces);
        } else {
            System.out.println("Парковка пустая");
        }
    }

}
