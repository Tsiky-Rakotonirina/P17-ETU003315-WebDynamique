package model.entites;

import java.sql.*;
import java.util.*;

import model.utils.*;

public class Credit extends BaseObject {
    String libelle;
    double montant;

    public Credit() {
    }

    public Credit(String libelle, double montant) {
        this.libelle = libelle;
        this.montant = montant;
    }

    public Credit(int id, String libelle, double montant) {
        super(id);
        this.libelle = libelle;
        this.montant = montant;
    }

    public int getId() {
        return super.getId();
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public void save(Connection conn) throws Exception {
        String sql = "INSERT INTO webdyn_credit(libelle, montant) VALUES (?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, this.getLibelle());
            pstmt.setDouble(2, this.getMontant());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
        }
    }

    @Override
    public void save() throws Exception {
        Connection conn = null;
        try {
            conn = Conn.getConnection();
            this.save(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
    }

    @Override
    public BaseObject getById(Connection conn) throws Exception {
        String sql = "SELECT * FROM webdyn_credit WHERE id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Credit credit = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, this.getId());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                credit = new Credit(
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getDouble("montant")
                );
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        }
        return credit;
    }

    @Override 
    public BaseObject getById() throws Exception{
        Connection conn = null;
        try {
            conn = Conn.getConnection();
            return this.getById(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
    } 

    @Override
    public ArrayList<BaseObject> getAll(Connection conn) throws Exception {
        String sql = "SELECT * FROM webdyn_credit";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<BaseObject> credits = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Credit credit = new Credit(
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getDouble("montant")
                );
                credits.add(credit);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        }
        return credits;
    }

    @Override
    public ArrayList<BaseObject> getAll() throws Exception{
        Connection conn = null;
        try {
            conn = Conn.getConnection();
            return this.getAll(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
    }

    @Override
    public void deleteById(Connection conn) throws Exception {
        String sql = "DELETE FROM webdyn_credit WHERE id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, this.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
        }
    }

    @Override
    public void deleteById() throws Exception{
        Connection conn = null;
        try {
            conn = Conn.getConnection();
            this.deleteById(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
    }

    @Override
    public void updateById(Connection conn) throws Exception {
        String sql = "UPDATE webdyn_credit SET libelle = ?, montant = ? WHERE id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, this.getLibelle());
            pstmt.setDouble(2, this.getMontant());
            pstmt.setInt(3, this.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
        }
    }

    @Override
    public void updateById() throws Exception{
        Connection conn = null;
        try {
            conn = Conn.getConnection();
            this.updateById(conn);
        } catch (Exception e) {
            throw e;
        } finally {
            if (conn != null) conn.close();
        }
    }

}
