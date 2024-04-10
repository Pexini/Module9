package Middle.Parking;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(20);

        Car car1 = new Car("Honda1");
        Car car2 = new Car("Toyota1");
        Car car3 = new Car("Mercedes1");
        Car car4 = new Car("Reno1");

        parking.push(car1);
        parking.push(car2);
        parking.push(car3);
        parking.push(car4);

        parking.pop();

    }
}
