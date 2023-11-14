package com.codegym.service;


import com.codegym.model.history.HistoryTransaction;
import com.codegym.model.history.HistoryType;
import com.codegym.model.person.employee.Employee;
import com.codegym.repository.EmployeeRepository;

import java.sql.Date;
import java.util.List;

public class EmployeeService extends BaseService{

    private static EmployeeService employeeService;

    private EmployeeRepository employeeRepository =  EmployeeRepository.getEmployeeRepository();

    private HistoryTransactionService historyTransactionService = HistoryTransactionService.getHistoryTransactionService();

    private EmployeeService() {

    }

    public static EmployeeService getEmployeeService(){
        if (employeeService == null){
            employeeService = new EmployeeService();
        }
        return employeeService;
    }

    public void payWage(){
        getEmployees().stream().forEach(x->{
            historyTransactionService.addHistoryTransaction(new HistoryTransaction( genId(),x.getEmployeeId(), HistoryType.PAY_WAGE,x.getSalary(),new Date(System.currentTimeMillis())));
        });
        System.out.println("Thành Công");
    }




    public List<Employee> getEmployees(){
        return employeeRepository.getAllEmployees();
    }

    public Employee findById(String employeeId){
        return employeeRepository.findEmployeeById(employeeId);
    }
    public  List<Employee> findByName(String employeeName){
        return employeeRepository.findEmployeesByName(employeeName);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    public void removeEmployee(String employeeId) {
        employeeRepository.removeEmployee(employeeId);
    }
}
