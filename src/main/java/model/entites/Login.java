package model.entites;

import model.utils.*;
import java.sql.*;

public class Login {
    int id;
    String nom;
    String motDePasse;

    public Login(int id, String nom, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.motDePasse = motDePasse;
    }

    public boolean checkLogin() throws Exception {
        try (Connection conn = Conn.getConnection();
            Statement statement = conn.createStatement()) {
            String sql="SELECT * FROM webdyn_login where nom='"+this.getNom()+"' and motDePasse='"+this.getMotDePasse()+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePase(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
