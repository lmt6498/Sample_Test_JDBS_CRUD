package models;

public class Personal {
    private int id;
    private String name;
    private String date;
    private String address;
    private String phone;
    private String email;
    private int id_dp;
    private String name_dp;

    public Personal(int id, String name, String date, String address, String phone, String email, int id_dp, String name_dp) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id_dp = id_dp;
        this.name_dp = name_dp;
    }

    public Personal(int id, String name, String date, String address, String phone, String email, int id_dp) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id_dp = id_dp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_dp() {
        return id_dp;
    }

    public void setId_dp(int id_dp) {
        this.id_dp = id_dp;
    }

    public String getName_dp() {
        return name_dp;
    }

    public void setName_dp(String name_dp) {
        this.name_dp = name_dp;
    }
}
