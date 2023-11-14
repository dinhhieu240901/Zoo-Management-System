package com.codegym.serializer;


import com.codegym.model.history.HistoryRequestBuySupply;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ReadHistoryRequestBuySupplySerializer {

    private static ReadHistoryRequestBuySupplySerializer readHistoryRequestBuySupplySerializer;

    public  static ReadHistoryRequestBuySupplySerializer getInstanceReadHistoryRequestBySupplySerializer(){
        if (readHistoryRequestBuySupplySerializer == null){
            readHistoryRequestBuySupplySerializer = new ReadHistoryRequestBuySupplySerializer();
        }
        return readHistoryRequestBuySupplySerializer;
    }



    private ReadHistoryRequestBuySupplySerializer() {
    }

    public void writeToCSV(List<HistoryRequestBuySupply> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Zoo-system/historyRequestBuySupply.csv"))) {
            writer.println("Id,User Id Request,Supply Id,Amount,Total Money,Status");
            for (HistoryRequestBuySupply obj : objects) {
                writer.println(obj.getId() + "," +
                        obj.getUserIdRequest() + "," +
                        obj.getSupplyId()+ "," +
                        obj.getAmount()+ "," +
                        obj.getTotalMoney()+ "," +
                        obj.getStatus()
                );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HistoryRequestBuySupply> readFromCSV() {
        List<HistoryRequestBuySupply> loadedObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Zoo-system/historyRequestBuySupply.csv"))) {
            String line;
            Boolean co = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && co) {

                    String id = data[0];
                    String userIdRequest = data[1];
                    int supplyId = Integer.valueOf(data[2]);
                    int amount = Integer.parseInt(data[3]);
                    double totalMoney = Double.parseDouble(data[4]);
                    String status = data[5];
                    loadedObjects.add(new HistoryRequestBuySupply(id,userIdRequest,supplyId,amount,totalMoney,status));
                }
                co = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadedObjects;
    }
}
