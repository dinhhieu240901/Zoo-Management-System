package com.codegym.main;

import com.codegym.model.animal.Animal;
import com.codegym.model.person.enumerations.AgeCategory;
import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.model.person.visitors.Adult;
import com.codegym.model.person.visitors.Child;
import com.codegym.model.person.visitors.Senior;
import com.codegym.model.person.visitors.Visitor;
import com.codegym.model.supply.Supply;
import com.codegym.model.supply.enumerations.BuildingMaterialType;
import com.codegym.model.supply.enumerations.FoodType;
import com.codegym.model.supply.enumerations.MedicineType;
import com.codegym.model.supply.types.BuildingMaterialSupply;
import com.codegym.model.supply.types.FoodSupply;
import com.codegym.model.supply.types.MedicineSupply;
import com.codegym.model.ticket.AdultTicket;
import com.codegym.model.ticket.ChildTicket;
import com.codegym.model.ticket.SeniorTicket;
import com.codegym.service.*;

import java.util.Scanner;

public class SupplierFunction implements MainFunction {

    SupplyService supplyService = SupplyService.getSupplyService();

    HistoryRequestBuySupplyService historyRequestBuySupplyService = HistoryRequestBuySupplyService.getHistoryRequestBuySupplyService();


    @Override
    public void show() {
        System.out.println("=== MENU NHÂN VIÊN CƠ SỞ VÂT CHẤT ===");
        System.out.println("1. Xem danh sách các nguyên vật liệu.");
        System.out.println("2. Thêm các nguyên vật liệu.");
        System.out.println("3. Sửa các nguyên vật liệu.");
        System.out.println("4. Xoá các nguyên vật liệu.");
        System.out.println("5. Xem danh sách yêu cầu mua nguyên vật liệu.");
        System.out.println("6. Yêu cầu mua nguyên vật liệu.");
        System.out.println("7. Trở về Menu chính.");
        Scanner scanner = new Scanner(System.in);
        int inputMenuManagerCustomerSelected = scanner.nextInt();
        switch (inputMenuManagerCustomerSelected) {
            case 1:
                supplyService.getSupplies().stream().forEach(System.out::println);
                break;
            case 2:
                supplyService.addSupply(getSupply());
                System.out.println("Thành Công");
                break;
            case 3:
                supplyService.updateSupply(getSupply());
                System.out.println("Thành Công");
                break;
            case 4:
                System.out.println("Id muốn xoá: ");
                int id = scanner.nextInt();
                supplyService.removeSupply(id);
                System.out.println("Thành Công");
                break;
            case 5:
                historyRequestBuySupplyService.getSupplies().stream().forEach(System.out::println);
                break;
            case 6:
                System.out.println("Id muốn mua: ");
                int idSupply = scanner.nextInt();
                System.out.println("Số lượng muốn mua: ");
                int quantityAvailable = scanner.nextInt();
                historyRequestBuySupplyService.addHistoryRequestBuySupply(idSupply,quantityAvailable);

                break;
            case 7:
                System.out.println("7. Trở về Menu chính.");
                return;
        }

    }

    public Supply getSupply() {
        Supply supply = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Thông tin vật liệu===");
        System.out.println("1. BuildingMaterialSupply ");
        System.out.println("2. FoodSupply ");
        System.out.println("3. MedicineSupply");
        System.out.println("Chọn loai vật liệu: ");
        int inputVisitorSelected = scanner.nextInt();
        System.out.println("Id: ");
        int id = scanner.nextInt();
        System.out.println("Name: ");
        String name = scanner.next();
        System.out.println("PricePerUnit: ");
        double pricePerUnit = scanner.nextDouble();
        System.out.println("QuantityAvailable: ");
        int quantityAvailable = scanner.nextInt();

        switch (inputVisitorSelected) {
            case 1:
                System.out.println("BuildingMaterialType WOOD,METAL,CONCRETE: ");
                BuildingMaterialType buildingMaterialType = BuildingMaterialType.valueOf(scanner.next());
                supply = new BuildingMaterialSupply(id,name,pricePerUnit,quantityAvailable,buildingMaterialType);
                break;
            case 2:
                System.out.println("FoodType  MEAT,FISH,VEGETABLES,INSECTS,FRUITS: ");
                FoodType foodType = FoodType.valueOf(scanner.next());
                supply = new FoodSupply(id,name,pricePerUnit,quantityAvailable,foodType);
                break;
            case 3:
                System.out.println("FoodType ANTIBIOTICS,VITAMIN,ANALGESIC,ANTIPARASITIC: ");
                MedicineType medicineType = MedicineType.valueOf(scanner.next());
                supply = new MedicineSupply(id,name,pricePerUnit,quantityAvailable,medicineType);
                break;
            default:
                break;
        }
        return supply;
    }


}
