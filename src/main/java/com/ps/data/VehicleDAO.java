
package com.ps.data;

import com.ps.models.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class VehicleDAO implements VehicleDAOInterface {
    private DataSource dataSource;

    public VehicleDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Vehicle getById(int id) {
        return null;
    }

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

    public void create(Vehicle vehicle) {
    }

    public void update(int id, Vehicle vehicle) {
    }

    public void delete(int id) {
    }
}
