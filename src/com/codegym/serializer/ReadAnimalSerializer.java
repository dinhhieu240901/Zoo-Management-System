package com.codegym.serializer;

import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.species.*;
import com.codegym.model.foodplan.FoodPlan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAnimalSerializer {


    private static ReadAnimalSerializer readAnimalSerializer;

    public static ReadAnimalSerializer getInstanceReadAnimalSerializer() {
        if (readAnimalSerializer == null) {
            readAnimalSerializer = new ReadAnimalSerializer();
        }
        return readAnimalSerializer;
    }


    private ReadAnimalSerializer() {
    }


    public void writeToCSV(List<Animal> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Zoo-system/animal.csv"))) {
            writer.println("Id,Name,Species,Weight,size,age,heal,gender,isHungry,cageId,foodPlanQuantity,foodPlanItem,typeAnimal");
            for (Animal obj : objects) {
                writer.println(obj.getId() + "," +
                        obj.getName() + "," +
                        obj.getSpecies() + "," +
                        obj.getWeight() + "," +
                        obj.getSize() + "," +
                        obj.getAge() + "," +
                        obj.getHeal() + "," +
                        obj.getGender() + "," +
                        obj.isHungry() + "," +
                        ((obj.getCageId() == null) ? "" : obj.getCageId()) + "," +
                        ((obj.getFoodPlan() == null) ? "" : obj.getFoodPlan().getQuantity()) + "," +
                        ((obj.getFoodPlan() == null) ? "" : obj.getFoodPlan().getFoodItem()) + "," +
                        obj.getTypeAnimal()
                );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Animal> readFromCSV() {
        List<Animal> loadedObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Zoo-system/animal.csv"))) {
            String line;
            Boolean co = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && co) {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String species = data[2];
                    double weight = Double.parseDouble(data[3]);
                    double size = Double.parseDouble(data[4]);
                    int age = Integer.parseInt(data[5]);
                    HealAnimals heal = HealAnimals.valueOf(data[6]);
                    GenderAnimals gender = GenderAnimals.valueOf(data[7]);
                    boolean isHungry = Boolean.valueOf(data[8]);

                    String cageId = data[9] == "" ? null : data[9];
                    FoodPlan foodPlan = null;
                    if (!data[10].equals("") && !data[11].equals("")) {
                        foodPlan = new FoodPlan(data[11], Integer.parseInt(data[10]));
                    }

                    String typeAnimal = data[12];

                    Animal  animal= null;
                    if (typeAnimal.equals("Dolphin")) {
                      animal =new Dolphin(id, name, species, weight, size, age, heal, gender, foodPlan,cageId);
                    } else if (typeAnimal.equals("Eagle")) {
                      animal =new Eagle(id, name, species, weight, size, age, heal, gender, foodPlan,cageId);
                    } else if (typeAnimal.equals("Elephant")) {
                      animal =new Elephant(id, name, species, weight, size, age, heal, gender, foodPlan,cageId);
                    } else if (typeAnimal.equals("Lion")) {
                      animal =new Lion(id, name, species, weight, size, age, heal, gender, foodPlan,cageId);
                    } else if (typeAnimal.equals("Panda")) {
                      animal =new Panda(id, name, species, weight, size, age, heal, gender, foodPlan,cageId);
                    } else if (typeAnimal.equals("Seal")) {
                      animal =new Seal(id, name, species, weight, size, age, heal, gender, foodPlan,cageId);
                    } else if (typeAnimal.equals("Shark")) {
                      animal =new Shark(id, name, species, weight, size, age, heal, gender, foodPlan,cageId);
                    } else if (typeAnimal.equals("Zebra")) {
                      animal =new Zebra(id, name, species, weight, size, age, heal, gender, foodPlan,cageId);
                    }
                    loadedObjects.add(animal);
                }
                co = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadedObjects;
    }

}
