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
        if (isEnable && currentWeight + cargo.getWeight() <= MAX_WEIGHT_CAPACITY) {
            cargos.add(cargo);
            currentWeight += cargo.getWeight();
            System.out.println("Груз " + cargo.getType() + ", добавлен в лифт. Тукузий вес " + currentWeight);
        } else {
            System.out.println("Груз " + cargo.getType() + " превысел лимит. Текущий вес " + currentWeight);
        }
    }

    public void push() {
        if (isEnable){
            System.out.println("Лифт начал движение.");
            System.out.println();
        }else {
            System.out.println(" Превышен лимит, лифт не может начать движение");
        }
    }
    public void pop(){
        System.out.println("Лифт приехал, происходит выгрузка  выгрузка...");
        cargos.clear();
        currentWeight = 0;
        isEnable = true;
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
