package model.entites;

import java.sql.*;
import java.util.*;

import model.utils.*;

public class Depense extends BaseObject {
    int id_credit;
    java.sql.Date date;
    double montant; // Nouvel attribut ajouté

    public Depense() {
    }

    public Depense(int id) {
        super(id);
    }

    public Depense(int id_credit, java.sql.Date date, double montant) {
        this.id_credit = id_credit;
        this.date = date;
        this.montant = montant;
    }

    public Depense(int id, int id_credit, java.sql.Date date, double montant) {
        super(id);
        this.id_credit = id_credit;
        this.date = date;
        this.montant = montant;
    }

    public int getIdCredit() {
        return id_credit;
    }

    public void setIdCredit(int id_credit) {
        this.id_credit = id_credit;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public void save(Connection conn) throws Exception {
        String sql = "INSERT INTO webdyn_depense(id_credit, date_ajout, montant) VALUES (?, ?, ?)";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, this.getIdCredit());
            pstmt.setDate(2, this.getDate());
            pstmt.setDouble(3, this.getMontant()); // Utilisation de montant ici
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
        String sql = "SELECT * FROM webdyn_depense WHERE id = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Depense depense = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, this.getId());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                depense = new Depense(
                        rs.getInt("id"),
                        rs.getInt("id_credit"),
                        rs.getDate("date_ajout"),
                        rs.getDouble("montant") // Récupération de montant
                );
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        }
        return depense;
    }

    @Override
    public BaseObject getById() throws Exception {
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
        String sql = "SELECT * FROM webdyn_depense";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<BaseObject> depenses = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Depense depense = new Depense(
                        rs.getInt("id"),
                        rs.getInt("id_credit"),
                        rs.getDate("date_ajout"),
                        rs.getDouble("montant") // Récupération de montant
                );
                depenses.add(depense);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        }
        return depenses;
    }

    @Override
    public ArrayList<BaseObject> getAll() throws Exception {
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
        String sql = "DELETE FROM webdyn_depense WHERE id = ?";
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
    public void deleteById() throws Exception {
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
        String sql = "UPDATE webdyn_depense SET id_credit = ?, date_ajout = ?, montant = ? WHERE id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, this.getIdCredit());
            pstmt.setDate(2, this.getDate());
            pstmt.setDouble(3, this.getMontant()); // Mise à jour du montant ici
            pstmt.setInt(4, this.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
        }
    }

    @Override
    public void updateById() throws Exception {
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
