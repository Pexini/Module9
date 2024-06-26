package Middle.Parking;

public class Parking {
    private int capacity;
    private int occupiedSpaces;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.occupiedSpaces = 0;
    }

    private boolean isFull() {
        return occupiedSpaces >= capacity;
    }

    public void push(Car car) {
        if (!isFull()) {
            occupiedSpaces++;
            System.out.println("Машина заехала на парковку " + "Свободныъ мест осталось " + (capacity - occupiedSpaces));
        } else {
            System.out.println(" Свободных мест на парковке нет, въезд запрещен !");
        }
    }

    public void pop() {
        if (capacity > 0) {
            occupiedSpaces--;
            System.out.println("Машина выехала с парковки " + "Свободных мест " + (capacity - occupiedSpaces));
        } else {
            System.out.println("Парковка пустая");
        }
    }

}
