
package com.ps.data;

import com.ps.models.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class VehicleDAO implements VehicleDAOInterface {
    private DataSource dataSource;

    public VehicleDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Vehicle getByVin(int vin){
        String query = "Select * from vehicle where vin = ?";

        try(
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            //inject user input
            preparedStatement.setInt(1, vin);
            // setresultset
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ){
                resultSet.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return vehicles;
    }

    @Override
    public List<Vehicle> getAll() {
        new ArrayList();
        String query = "SELECT * FROM vehicle";

        try {
            Connection connection = this.dataSource.getConnection();

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    ResultSet resultSet = preparedStatement.executeQuery();

                    try {
                        while(resultSet.next()) {
                            String vin = resultSet.getString("vin");
                            System.out.println(vin);
                        }
                    } catch (Throwable var11) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var12) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var13) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception var14) {
            Exception e = var14;
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void create(Vehicle vehicle) {
        String query = "INSERT INTO vehicle (vin, make, model, color) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, vehicle.getVin());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setString(4, vehicle.getColor());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Vehicle vehicle) {
        String query = "UPDATE vehicle SET make = ?, model = ?, color = ?, sold = ? WHERE vin = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, vehicle.getVin());
            preparedStatement.setString(2, vehicle.getMake());
            preparedStatement.setString(3, vehicle.getModel());
            preparedStatement.setString(4, vehicle.getColor());
            preparedStatement.setBoolean(5, vehicle.isSold());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM vehicle WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Vehicle mapVehicle(ResultSet resultSet) throws SQLException {
        int vin = resultSet.getInt("vin");
        String make = resultSet.getString("make");
        String model = resultSet.getString("model");
        String color = resultSet.getString("color");
        boolean sold = resultSet.getBoolean("sold");
        int dealershipId = resultSet.getInt("dealership_id");

        return new Vehicle(vin, make, model, color, sold, dealershipId);
    }
}
