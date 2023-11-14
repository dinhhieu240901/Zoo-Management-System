package com.codegym.model.Cage;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.interfaces.AquaticAnimal;

public class AquaticHabitat extends Cage  {

    private final int deepness;
    private double salinity;

    public AquaticHabitat(String id,String name, double area, int maxAnimals, int deepness, String employeeId) {
        super(id,name, area, maxAnimals,employeeId,"AquaticHabitat");
        if (deepness <= 0) {
            throw new IllegalArgumentException("Độ sâu của chuồng phải lớn hơn 0.");
        }
        this.deepness = deepness;
        this.salinity = 1.0;
    }

    public int getDeepness() {
        return deepness;
    }

    public double getSalinity() {
        return salinity;
    }

    public void setSalinity(double salinity) {
        if (salinity < 0f || salinity > 1f) {
            throw new IllegalArgumentException("Độ mặn của nước phải nằm trong khoảng từ 0 đến 1.");
        }
        this.salinity = salinity;
    }

    @Override
    public String maintain() {
        this.salinity = 1.0;
        return super.maintain();
    }


    @Override
    public boolean isCompatible(Animal animal) {
        if (animal == null) {
            System.out.println("Chuồng phải chứa động vật.");
        }
        return animal instanceof AquaticAnimal;
    }
}
