package dao;

import models.Personal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectPesonal {
    static String select = "select p.id,p.name,p.date,p.address,p.phone,p.email,department.name_pb " +
            "from personal p " +
            "inner join department on p.dp_id = department.id_pb " +
            "order by p.id";
    public static List<Personal> seclect() throws SQLException, ClassNotFoundException {
        ArrayList<Personal> list = new ArrayList<>();
        Connection connection = Connect.getConnect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()) {
            int id = Integer.parseInt(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String date =resultSet.getString("date");
            String address =resultSet.getString("address");
            String phone =resultSet.getString("phone");
            String email =resultSet.getString("email");
            int id_dp = Integer.parseInt(resultSet.getString("id"));
            String name_dp =resultSet.getString("name_pb");

            list.add(new Personal(id,name,date,address,phone,email,id_dp,name_dp));
        }
        return list;
    }
}
