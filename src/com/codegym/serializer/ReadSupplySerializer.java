package com.codegym.serializer;




import com.codegym.model.supply.Supply;
import com.codegym.model.supply.enumerations.BuildingMaterialType;
import com.codegym.model.supply.enumerations.FoodType;
import com.codegym.model.supply.enumerations.MedicineType;
import com.codegym.model.supply.types.BuildingMaterialSupply;
import com.codegym.model.supply.types.FoodSupply;
import com.codegym.model.supply.types.MedicineSupply;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadSupplySerializer {

    private static ReadSupplySerializer readSupplySerializer;

    public  static ReadSupplySerializer getReadSupplySerializer(){
        if (readSupplySerializer == null){
            readSupplySerializer = new ReadSupplySerializer();
        }
        return readSupplySerializer;
    }



    private ReadSupplySerializer() {
    }

    public void writeToCSV(List<Supply> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("supply.csv"))) {
            writer.println("Supply Id,Name, Price Per Unit,Quantity Available,Supply Type,Data Type");
            for (Supply obj : objects) {
                String data = obj.getSupplyId() + "," +
                        obj.getName() + "," +
                        obj.getPricePerUnit()+ "," +
                        obj.getQuantityAvailable()+ "," +
                        obj.getSupplyType() + "," ;
                if (obj instanceof BuildingMaterialSupply){
                    data += ((BuildingMaterialSupply) obj).getBuildingMaterialType();
                }else if (obj instanceof FoodSupply){
                    data += ((FoodSupply) obj).getFoodType();
                }else {
                    data += ((MedicineSupply) obj).getMedicineType();
                }
                writer.println(data);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Supply> readFromCSV() {
        List<Supply> loadedObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("supply.csv"))) {
            String line;
            Boolean co = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && co) {

                    int id = Integer.valueOf(data[0]);
                    String name = data[1];
                    double pricePerUnit = Double.parseDouble(data[2]);
                    int quantityAvailable = Integer.parseInt(data[3]);
                    String supplyType = data[4];
                    String dataType = data[5];
                    Supply supply ;
                    if ("FoodSupply".equals(supplyType)){
                        supply = new FoodSupply(id,name,pricePerUnit,quantityAvailable, FoodType.valueOf(dataType));
                    }else if ("BuildingMaterialSupply".equals(supplyType)){
                        supply =new BuildingMaterialSupply(id,name,pricePerUnit,quantityAvailable, BuildingMaterialType.valueOf(dataType));
                    }else {
                        supply =new MedicineSupply(id,name,pricePerUnit,quantityAvailable, MedicineType.valueOf(dataType));
                    }
                    loadedObjects.add(supply);
                }
                co = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadedObjects;
    }
}
