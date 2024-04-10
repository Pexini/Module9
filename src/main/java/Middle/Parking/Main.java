package Middle.Parking;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking(10);

        Car car1 = new Car("Honda");
        Car car2 = new Car("Toyota");
        Car car3 = new Car("Mercedes");
        Car car4 = new Car("Honda");
        Car car5 = new Car("Mercedes");
        Car car6 = new Car("Reno");
        Car car7 = new Car("Honda");
        Car car8 = new Car("Mercedes");
        Car car9 = new Car("Honda");
        Car car10 = new Car("Toyota");


        parking.push(car1);
        parking.push(car2);
        parking.push(car3);
        parking.push(car4);
        parking.push(car5);
        parking.push(car6);
        parking.push(car7);
        parking.push(car8);
        parking.push(car9);
        parking.push(car10);

        parking.pop();

    }
}
