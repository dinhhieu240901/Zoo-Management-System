package com.codegym.model.Cage;

import com.codegym.model.Cage.enumerations.CleanlinessEnclosure;
import com.codegym.model.animal.Animal;
import com.codegym.model.animal.interfaces.Mammal;
import com.codegym.model.animal.interfaces.TerrestrialAnimal;

public class TerrestrialHabitat extends Cage  {
    private final int height;
    private CleanlinessEnclosure cleanlinessRoof;

    public TerrestrialHabitat(String id,String name, double area, int maxAnimals, int height, String employeeId) {
        super(id,name, area, maxAnimals,employeeId,"TerrestrialHabitat");
        if (height <= 0) {
            throw new IllegalArgumentException("Chiều cao của chuồng phải lớn hơn 0.");
        }
        this.height = height;
        this.cleanlinessRoof = CleanlinessEnclosure.CLEAN;
    }

    public CleanlinessEnclosure getCleanlinessRoof() {
        return cleanlinessRoof;
    }

    public void setCleanlinessRoof(CleanlinessEnclosure cleanlinessRoof) {
        this.cleanlinessRoof = cleanlinessRoof;
    }

    @Override
    public boolean isCompatible(Animal animal) {
        if (height <= 0) {
            System.out.println("Chiều cao của chuồng phải lớn hơn 0." );
        }
        return animal instanceof TerrestrialAnimal;
    }

    public int getHeight() {
        return height;
    }
}
