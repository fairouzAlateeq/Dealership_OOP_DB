package com.ps.data;

import com.ps.data.VehicleDAO;
import com.ps.models.Vehicle;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.dbcp2.BasicDataSource;

public class UserInterface {
    private static Scanner scanner;
    private static BasicDataSource basicDataSource;

    public UserInterface() {
    }

    public static void init() {
    }

    public static void display(String username, String password) {
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/dealership_db");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        init();

        int mainCommand;
        do {
            System.out.println("1) Manage Vehicles");
            System.out.println("0) Exit");
            System.out.print("Command: ");
            mainCommand = scanner.nextInt();
            switch (mainCommand) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    handleManageVehicles();
                    break;
                default:
                    System.out.println("Invalid command, please try again");
            }
        } while(mainCommand != 0);

    }

    public static void handleManageVehicles() {
        int manageVehicleCommand;
        do {
            System.out.println("Manage Vehicles");
            System.out.println("1) Get a vehicle by id");
            System.out.println("2) Get all vehicles");
            System.out.println("3) Create a vehicle");
            System.out.println("4) Update a vehicle");
            System.out.println("5) Delete a vehicle");
            System.out.println("0) Back");
            System.out.print("Command: ");
            manageVehicleCommand = scanner.nextInt();
            switch (manageVehicleCommand) {
                case 0:
                    System.out.println("Going back...");
                    break;
                case 1:
                    handleGetVehicle();
                    break;
                case 2:
                    handleGetAllVehicles();
                    break;
                case 3:
                    handleCreateVehicle();
                    break;
                case 4:
                    handleUpdateVehicle();
                    break;
                case 5:
                    handleDeleteVehicle();
                    break;
                default:
                    System.out.println("Invalid command, please try again");
            }
        } while(manageVehicleCommand != 0);

    }

    private static void handleGetVehicle() {
    }

    private static void handleGetAllVehicles() {
        VehicleDAO vehicleDAO = new VehicleDAO(basicDataSource);
        List<Vehicle> vehicles = vehicleDAO.getAll();
    }

    private static void handleCreateVehicle() {
    }

    private static void handleUpdateVehicle() {
    }

    private static void handleDeleteVehicle() {
    }

    static {
        scanner = new Scanner(System.in);
        basicDataSource = new BasicDataSource();
    }
}