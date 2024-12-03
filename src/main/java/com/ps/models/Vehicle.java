package com.ps.models;

public class Vehicle{
    private int vin;
    private int year;
    private boolean sold;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, String make, String model, String vehicleType, String color,boolean sold, int odometer, double price) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public Vehicle(int vin, String make, String model, String color, boolean sold, int dealershipId) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.color = color;
        this.sold = sold;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "VIN: " + vin + ", Make: " + make + ", Model: " + model +
                ", Type: " + vehicleType + ", Color: " + color + ", Odometer: " + odometer +
                ", Price: " + price;
    }
}