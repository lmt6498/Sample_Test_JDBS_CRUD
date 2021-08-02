package models;

public class Department {
    private int id_dp;
    private String name;

    public Department(int id_dp, String name) {
        this.id_dp = id_dp;
        this.name = name;
    }

    public int getId_dp() {
        return id_dp;
    }

    public void setId_dp(int id_dp) {
        this.id_dp = id_dp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
