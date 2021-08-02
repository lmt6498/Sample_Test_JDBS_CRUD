package services;

import dao.SelectDepartment;
import models.Department;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    public static ArrayList<Department> listDP = new ArrayList<>();

    public DepartmentService() {
        try {
            listDP = (ArrayList<Department>) SelectDepartment.select();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
