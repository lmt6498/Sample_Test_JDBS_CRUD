package dao;

import models.Department;
import models.Personal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectDepartment {
    static String select = "select * from department";
    public static List<Department> select() throws SQLException, ClassNotFoundException {
        ArrayList<Department> listDP = new ArrayList<>();
        Connection connection = Connect.getConnect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id_pb"));
            String name = resultSet.getString("name_pb");

            listDP.add(new Department(id,name));
        }
        return listDP;
    }
}
