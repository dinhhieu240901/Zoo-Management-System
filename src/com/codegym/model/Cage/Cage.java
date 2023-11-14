package com.codegym.model.Cage;

import com.codegym.model.animal.Animal;
import com.codegym.model.Cage.enumerations.CleanlinessEnclosure;
import com.codegym.model.person.employee.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cage implements Comparator<Animal>,Habitat {
    private String cageId;
    private String name;
    private double area;
    private int maxAnimals;

    private String employeeId;
    Habitat habitat;
    private List<Animal> animals;
    private CleanlinessEnclosure cleanliness;

    private Employee employee;

    private String cageType;

    public Cage(String cageId,String name, double area, int maxAnimals, String employeeId, String cageType) {
        this.employeeId = employeeId;
        this.cageType = cageType;
        this.cageId = cageId;
        this.name = name;
        this.area = area;
        this.maxAnimals = maxAnimals;
        this.animals = new ArrayList<>();
        this.cleanliness = CleanlinessEnclosure.NORMAL;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCageType() {
        return cageType;
    }

    public void setCageType(String cageType) {
        this.cageType = cageType;
    }

    public String getCageId() {
        return cageId;
    }

    public void setCageId(String cageId) {
        this.cageId = cageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getMaxAnimals() {
        return maxAnimals;
    }

    public void setMaxAnimals(int maxAnimals) {
        this.maxAnimals = maxAnimals;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getAnimalsPresent() {
        return animals.size();
    }

    public CleanlinessEnclosure getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(CleanlinessEnclosure cleanliness) {
        this.cleanliness = cleanliness;
    }



    public void addAnimal(Animal animal) {
        if (habitat.isCompatible(animal) && !isFull()) {
            animals.add(animal);
        }
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public boolean isEmpty() {
        return animals.isEmpty();
    }

    public String maintain() {
        boolean empty = isEmpty();
        if (empty && getCleanliness() == CleanlinessEnclosure.NEED_CLEANING) {
            setCleanliness(CleanlinessEnclosure.CLEAN);
            return "Chuồng đã được vệ sinh.";
        } else if (!empty) {
            return "Chuồng phải trống để vệ sinh.";
        } else {
            return "Chuồng không cần được vệ sinh.";
        }
    }

    public boolean isFull() {
        return animals.size() >= maxAnimals;
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getAge() - o2.getAge();
    }

    @Override
    public String toString() {
        return "Cage{" +
                "cageId='" + cageId + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", maxAnimals=" + maxAnimals +
                ", employeeId='" + employeeId + '\'' +
                ", habitat=" + habitat +
                ", animals=" + animals +
                ", cleanliness=" + cleanliness +
                ", employee=" + employee +
                ", cageType='" + cageType + '\'' +
                '}';
    }

    @Override
    public boolean isCompatible(Animal animal) {
        return false;
    }
}
