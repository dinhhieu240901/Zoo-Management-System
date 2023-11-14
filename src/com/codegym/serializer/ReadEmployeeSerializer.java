package com.codegym.serializer;

import com.codegym.model.person.Person;
import com.codegym.model.person.employee.Accountant;
import com.codegym.model.person.employee.Employee;
import com.codegym.model.person.employee.Owner;
import com.codegym.model.person.employee.Supplier;
import com.codegym.model.person.enumerations.GenderPerson;
import com.codegym.model.supply.Supply;
import com.codegym.model.supply.enumerations.BuildingMaterialType;
import com.codegym.model.supply.enumerations.FoodType;
import com.codegym.model.supply.enumerations.MedicineType;
import com.codegym.model.supply.types.BuildingMaterialSupply;
import com.codegym.model.supply.types.FoodSupply;
import com.codegym.model.supply.types.MedicineSupply;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadEmployeeSerializer {
    private static ReadEmployeeSerializer readEmployeeSerializer;

    public static ReadEmployeeSerializer getInstanceReadEmployeeSerializer() {
        if (readEmployeeSerializer == null) {
            readEmployeeSerializer = new ReadEmployeeSerializer();
        }
        return readEmployeeSerializer;
    }


    private ReadEmployeeSerializer() {
    }

    public void writeToCSV(List<Employee> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Zoo-system/employee.csv"))) {
            writer.println("Name,Street, City,Country,Gender,Age,Employee Id,Job Position,Salary,Role,Total Revenue, Username, Password");
            for (Employee obj : objects) {
                if (obj instanceof Accountant) {
                    writer.println(obj.getName() + "," +
                            obj.getStreetAddress() + "," +
                            obj.getCity() + "," +
                            obj.getCountry() + "," +
                            obj.getGender() + "," +
                            obj.getAge() +
                            obj.getEmployeeId() + "," +
                            obj.getJobPosition() + "," +
                            obj.getSalary() + "," +
                            obj.getRole() + "," +
                            ((Accountant) obj).getTotalRevenue()+ "," +
                            obj.getUsername()+ "," +
                            obj.getPassword()
                    );
                } else {
                    writer.println(obj.getName() + "," +
                            obj.getStreetAddress() + "," +
                            obj.getCity() + "," +
                            obj.getCountry() + "," +
                            obj.getGender() + "," +
                            obj.getAge() + "," +
                            obj.getEmployeeId() + "," +
                            obj.getJobPosition() + "," +
                            obj.getSalary() + "," +
                            obj.getRole() + "," + " "+ "," +
                            obj.getUsername()+ "," +
                            obj.getPassword()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Employee> readFromCSV() {
        List<Employee> loadedObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Zoo-system/employee.csv"))) {
            String line;
            Boolean co = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && co) {

                     String name= data[0];

                     String streetAddress= data[1];
                    String city= data[2];
                    String country= data[3];
                     GenderPerson gender = GenderPerson.valueOf(data[4]);
                     int age = Integer.valueOf(data[5]);

                    String employeeId = data[6];
                    String jobPosition = data[7];
                    double salary = Double.parseDouble(data[8]);
                    String role = data[9];
                    String totalRevenueString = data[10];
                    double totalRevenue=0;
                    if (!totalRevenueString.isBlank()){
                        totalRevenue = Double.valueOf(totalRevenueString);
                    }
                    String username = data[11];
                    String password = data[12];
                    Employee employee ;
                    if ("Owner".equals(role)){
                        employee = new Owner(name,streetAddress,city,country,gender,age,employeeId,jobPosition,salary,username,password);
                    }else if ("Supplier".equals(role)){
                        employee =new Supplier(name,streetAddress,city,country,gender,age,employeeId,jobPosition,salary,username,password);
                    }else  if ("Accountant".equals(role)){
                        employee =new Accountant(name,streetAddress,city,country,gender,age,employeeId,jobPosition,salary,username,password);
                    }else {
                        employee = new Employee(name,streetAddress,city,country,gender,age,employeeId,jobPosition,salary,"Employee",username,password);
                    }
                    loadedObjects.add(employee);
                }
                co = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadedObjects;
    }
}
