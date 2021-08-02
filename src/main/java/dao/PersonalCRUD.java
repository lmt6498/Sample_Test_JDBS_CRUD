package dao;

import models.Personal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonalCRUD {
    static Connection connection;

    static {
        try {
            connection = Connect.getConnect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(Personal personal) throws SQLException, ClassNotFoundException {


        String create = "insert into personal values(?,?,?,?,?,?,?)";

        PreparedStatement prep = connection.prepareStatement(create);
        prep.setInt(1, personal.getId());
        prep.setString(2,personal.getName());
        prep.setString(3,personal.getDate());
        prep.setString(4,personal.getAddress());
        prep.setString(5,personal.getPhone());
        prep.setString(6,personal.getEmail());
        prep.setInt(7,personal.getId_dp());
        prep.execute();
    }
    public static void update(Personal personal) throws SQLException, ClassNotFoundException {

        String create = "update personal " +
                "set name = ?, date = ?, address = ?, phone = ?, email = ?, dp_id = ? " +
                "where id = ?";

        PreparedStatement prep = connection.prepareStatement(create);
        prep.setString(1,personal.getName());
        prep.setString(2,personal.getDate());
        prep.setString(3,personal.getAddress());
        prep.setString(4,personal.getPhone());
        prep.setString(5,personal.getEmail());
        prep.setInt(6,personal.getId_dp());
        prep.setInt(7, personal.getId());
        prep.execute();
    }

    public static void delete(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement prep = connection.prepareStatement("delete from personal where id =?");
        prep.setInt(1,id);
        prep.execute();

    }
}
