package services;

import dao.PersonalCRUD;
import dao.SelectPesonal;
import models.Personal;

import java.sql.SQLException;
import java.util.ArrayList;

public class PersonalService {
    public static ArrayList<Personal> list = new ArrayList<>();

    public PersonalService() {
        try {
            list = (ArrayList<Personal>) SelectPesonal.seclect();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void save(Personal personal) throws SQLException, ClassNotFoundException {
        PersonalCRUD.insert(personal);
        list.add(personal);
    }

    public void edit(Personal personal) throws SQLException, ClassNotFoundException {
        PersonalCRUD.update(personal);
    }

    public void delete(int index) throws SQLException, ClassNotFoundException {
        PersonalCRUD.delete(list.get(index).getId());
        list.remove(index);
    }
}
