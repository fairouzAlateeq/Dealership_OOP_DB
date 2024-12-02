package com.ps.data;

import com.ps.models.Vehicle;
import java.util.List;

public interface VehicleDAOInterface {
    Vehicle getById(int var1);

    List<Vehicle> getAll();

    void create(Vehicle var1);

    void update(int var1, Vehicle var2);

    void delete(int var1);
}