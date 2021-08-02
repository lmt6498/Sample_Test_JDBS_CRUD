package controllers;

import dao.SelectPesonal;
import models.Personal;
import services.DepartmentService;
import services.PersonalService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/nhanvien",""})
public class PersonalServlet extends HttpServlet {
    public PersonalService personalService = new PersonalService();
    public DepartmentService departmentService = new DepartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null){
            action ="";
        }
        switch (action) {
            case "create" -> {
                req.setAttribute("listDepartment", departmentService.listDP);
                requestDispatcher = req.getRequestDispatcher("views/personals/CreatePersonal.jsp");
                requestDispatcher.forward(req, resp);
            }
            case "edit" -> {
                int indexEdit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("add", personalService.list.get(indexEdit));
                req.setAttribute("listDepartment", departmentService.listDP);
                requestDispatcher = req.getRequestDispatcher("views/personals/EditPersonal.jsp");
                requestDispatcher.forward(req, resp);
            }
            case "delete" -> {
                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    personalService.delete(index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("/nhanvien");
            }
            default -> {
                req.setAttribute("listPersonal", personalService.list);
                requestDispatcher = req.getRequestDispatcher("views/personals/ShowPersonal.jsp");
                requestDispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        if (action == null){
            action ="";
        }
        switch (action){
            case "create" ->{
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String date = req.getParameter("date");
                String address = req.getParameter("address");
                String phone = req.getParameter("phone");
                String email = req.getParameter("email");
                int id_dp = Integer.parseInt(req.getParameter("id_dp"));

                Personal personal = new Personal(id,name,date,address,phone,email,id_dp);
                try {
                    personalService.save(personal);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    PersonalService.list = (ArrayList<Personal>) SelectPesonal.seclect();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/nhanvien");
            }
            case "edit" -> {
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String date = req.getParameter("date");
                String address = req.getParameter("address");
                String phone = req.getParameter("phone");
                String email = req.getParameter("email");
                int id_dp = Integer.parseInt(req.getParameter("id_dp"));

                Personal personal = new Personal(id, name, date, address,phone,email,id_dp);

                try {
                    personalService.edit(personal);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    PersonalService.list = (ArrayList<Personal>) SelectPesonal.seclect();
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/nhanvien");
            }
            case "find" -> {
                String findName = req.getParameter("nameFind");
                ArrayList<Personal> personalsSearch = new ArrayList<>();
                for (Personal s:personalService.list
                ) {
                    if (s.getName().contains(findName)){
                        personalsSearch.add(s);
                    }
                }
                req.setAttribute("listPersonal",personalsSearch);
                requestDispatcher = req.getRequestDispatcher("views/personals/SearchPersonal.jsp");
                requestDispatcher.forward(req,resp);
            }
        }

    }
}
