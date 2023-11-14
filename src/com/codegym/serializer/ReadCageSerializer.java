package com.codegym.serializer;

import com.codegym.model.Cage.*;
import com.codegym.model.Cage.enumerations.CleanlinessEnclosure;
import com.codegym.model.animal.Animal;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.species.*;
import com.codegym.model.foodplan.FoodPlan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadCageSerializer {
    private static ReadCageSerializer readCageSerializer;

    public static ReadCageSerializer getInstanceReadCageSerializer() {
        if (readCageSerializer == null) {
            readCageSerializer = new ReadCageSerializer();
        }
        return readCageSerializer;
    }


    private ReadCageSerializer() {
    }

    public void writeToCSV(List<Cage> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Zoo-system/cage.csv"))) {
            writer.println("CageId,Name,Area,MaxAnimals,Employee Id,Clean liness,Cage Type,Height,Deepness");
            for (Cage obj : objects) {
                if (obj instanceof Aviary) {
                    writer.println(obj.getCageId() + "," +
                            obj.getName() + "," +
                            obj.getArea() + "," +
                            obj.getMaxAnimals() + "," +
                            obj.getEmployeeId() + "," +
                            obj.getCleanliness() + "," +
                            obj.getCageType() + "," +
                            ((Aviary) obj).getHeight() + ","+" ,"
                    );
                }else if (obj instanceof TerrestrialHabitat) {
                    writer.println(obj.getCageId() + "," +
                            obj.getName() + "," +
                            obj.getArea() + "," +
                            obj.getMaxAnimals() + "," +
                            obj.getEmployeeId() + "," +
                            obj.getCleanliness() + "," +
                            obj.getCageType() + "," +
                            ((TerrestrialHabitat) obj).getHeight() + ","+" ,"
                    );
                }else {
                    writer.println(obj.getCageId() + "," +
                            obj.getName() + "," +
                            obj.getArea() + "," +
                            obj.getMaxAnimals() + "," +
                            obj.getEmployeeId() + "," +
                            obj.getCleanliness() + "," +
                            obj.getCageType() + "," +" "+
                             " ," +  ((AquaticHabitat) obj).getDeepness());

                }            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cage> readFromCSV() {
        List<Cage> loadedObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Zoo-system/cage.csv"))) {
            String line;
            Boolean co = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && co) {

                    String id = data[0];
                    String name = data[1];
                    double area = Double.parseDouble(data[2]);
                    int maxAnimals = Integer.parseInt(data[3]);
                    String employeeId = data[4] == "" ? null : data[4];
                    CleanlinessEnclosure heal = CleanlinessEnclosure.valueOf(data[5]);
                    String cageType = data[6];
                    int height = 0;
                    int deepness =0;
                    if (!data[7].isBlank()){
                         height = Integer.parseInt(data[7]);
                    }
                    if (!data[8].isBlank()){
                        deepness = Integer.parseInt(data[8]);
                    }




                    Cage  cage= null;
                    if (cageType.equals("Aviary")) {
                        cage =new Aviary(id,name,area,maxAnimals,height,employeeId);
                    } else if (cageType.equals("TerrestrialHabitat")) {
                        cage =new TerrestrialHabitat(id,name,area,maxAnimals,height,employeeId);
                    } else if (cageType.equals("AquaticHabitat")) {
                        cage =new AquaticHabitat(id,name,area,maxAnimals,deepness,employeeId);
                    }
                    loadedObjects.add(cage);
                }
                co = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadedObjects;
    }
}
