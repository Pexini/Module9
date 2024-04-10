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
        if (!isEnable){
            System.out.println("Лифт начал движение.");
        }else {
            System.out.println(" Превышен лимит, лифт не может начать движение");
        }
    }

}

