package Middle.Elevator;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        Cargo cargo1 = new Cargo("Мужчина", 85);
        Cargo cargo2 = new Cargo("Диван", 125);
        Cargo cargo3 = new Cargo("Женщина", 105);
        Cargo cargo4 = new Cargo("Шкаф", 56);
        Cargo cargo5 = new Cargo("ребенок", 30);
        Cargo cargo6 = new Cargo("Собака", 20);

        elevator.add(cargo1);
        elevator.add(cargo2);
        elevator.add(cargo3);
        elevator.add(cargo4);
        elevator.add(cargo5);
        elevator.add(cargo5);
        elevator.add(cargo5);
        elevator.add(cargo6);
        elevator.add(cargo6);
        elevator.add(cargo6);
        elevator.chekWeight();
        elevator.push();

        elevator.pop();

        elevator.add(cargo3);
        elevator.add(cargo4);
        elevator.add(cargo5);
        elevator.add(cargo6);
        elevator.chekWeight();
        elevator.push();
        elevator.pop();

        elevator.chekWeight();
    }
}
