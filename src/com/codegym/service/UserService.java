package com.codegym.service;

import com.codegym.model.person.employee.Employee;
import com.codegym.repository.EmployeeRepository;
import com.codegym.serializer.CacheSerializer;

import java.util.HashMap;

public class UserService {

    private CacheSerializer cacheSerializer = CacheSerializer.getInstanceCacheUserLogin();

    private EmployeeRepository employeeRepository = EmployeeRepository.getEmployeeRepository();

    private static UserService userService;

    public static UserService getInstanceUserService() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    private UserService() {

    }


    public void login(String username, String password) {
        Employee employee = employeeRepository.findEmployeeByUsernameAndPassword(username, password);
        if (employee != null) {
            cacheSerializer.addDataToCache("employeeId", employee.getEmployeeId());
            cacheSerializer.addDataToCache("role", employee.getRole());
        }

    }

    public void logout() {
        cacheSerializer.removeDataToCache("employeeId");
        cacheSerializer.removeDataToCache("role");
    }
}
