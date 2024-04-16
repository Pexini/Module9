package Middle.Elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private static final int MAX_WEIGHT_CAPACITY = 500;
    private int currentWeight;
    private boolean isEnable;
    private List<Cargo> cargos;


    public Elevator() {
        this.currentWeight = 0;
        this.isEnable = true;
        this.cargos = new ArrayList<>();
    }

    public void add(Cargo cargo) {
        if (isEnable) {
            cargos.add(cargo);
            currentWeight += cargo.getWeight();
            System.out.println("Груз " + cargo.getType() + ", добавлен в лифт. Тукузий вес " + currentWeight);
        }
    }

    public void push() {
        int totalWeight = 0;
        for (Cargo cargo : cargos) {
            totalWeight += cargo.getWeight();
        }
        if (isEnable && totalWeight <= MAX_WEIGHT_CAPACITY) {
            System.out.println("Лифт начал движение.");
            System.out.println();
        } else {
            System.out.println(" Превышен лимит, лифт не может начать движение");
        }
    }

    public void pop() {
        System.out.println("Лифт приехал, происходит выгрузка  выгрузка...");
        cargos.clear();
        currentWeight = 0;
        isEnable = true;
    }

    public void popOneCargo(Cargo cargo) {
        if (cargos.contains(cargo)) {
            cargos.remove(cargo);
            currentWeight -= cargo.getWeight();
            System.out.println("Груз " + cargo.getType() + " Весом " + cargo.getWeight() + " Вышел из лифта.");
        } else {
            System.out.println("Лифт пуст, нет груза для выгрузки");
        }

    }


    public void chekWeight() {
        if (!cargos.isEmpty()) {
            StringBuilder cargoTypes = new StringBuilder();
            for (Cargo cargo : cargos) {
                cargoTypes.append(cargo.getType()).append(", ");
            }
            cargoTypes.delete(cargoTypes.length() - 2, cargoTypes.length() - 1);
            System.out.println("В лифте находится : " + cargoTypes.toString() + ", с обшим весом " + currentWeight + " кг.");
        } else {
            System.out.println("В лифте нет груза");
        }
    }
}

