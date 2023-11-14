package com.codegym.main;

import com.codegym.service.BaseService;
import com.codegym.service.UserService;

import java.util.Scanner;

public class MainActivity extends BaseService {

    private static MainActivity mainActivity;


    private UserService userService = UserService.getInstanceUserService();

    private MainActivity() {
    }

    public static MainActivity getInstanceMainActivity() {
        if (mainActivity == null) {
            mainActivity = new MainActivity();
        }
        return mainActivity;
    }

    public void showMainActivity() {
        while (true) {
            userService.logout();
            System.out.println("=== MENU CHÍNH ===");
            System.out.println("1. Đăng nhập Owner.");
            System.out.println("2. Đăng nhập Zookeeper.");
            System.out.println("3. Đăng nhập Thu ngân.");
            System.out.println("4. Đăng nhập quản lý cơ sở vật chất.");
            System.out.println("5. Khách tham quan.");
            System.out.println("0. Khách tham quan.");
            Scanner scanner = new Scanner(System.in);
            int inputDataMainSelected = scanner.nextInt();
            if (inputDataMainSelected == 1
                    || inputDataMainSelected == 2
                    || inputDataMainSelected == 3
                    || inputDataMainSelected == 4) {
                System.out.println("=== Login ===");
                System.out.println("Username:");
                String username = scanner.next();
                System.out.println("Password:");
                String password = scanner.next();
                userService.login(username,password);
            }
            ScreenActivity screenActivity = null;
            switch (inputDataMainSelected) {
                case 1:
                    screenActivity = new OwnerScreenActivity();
                    if (!"Owner".equals(getRole())) {
                    System.out.println("Role không hợp lệ.");
                        continue;
                    }
                    break;
                case 2:
                    screenActivity = new ZookeeperScreenActivity();
                    if (!"Zookeeper".equals(getRole())) {
                        System.out.println("Role không hợp lệ.");
                        continue;
                    }
                    break;
                case 3:
                    screenActivity = new AccountantScreenActivity();
                    if (!"Accountant".equals(getRole())) {
                        System.out.println("Role không hợp lệ.");
                        continue;
                    }
                    break;
                case 4:
                    screenActivity = new SupplierScreenActivity();
                    if (!"Supplier".equals(getRole())) {
                        System.out.println("Role không hợp lệ.");
                        continue;
                    }
                    break;
                case 5:
                    screenActivity = new VisitorScreenActivity();
                    break;
                case 0:
                    return;

            }
            if (screenActivity != null) {
                screenActivity.renderWindow();
            }
        }
    }
}
