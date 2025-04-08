package service;

import model.entites.*;
import model.utils.*;
import model.utils.BaseObject;

import java.sql.Connection;

public class Depenser {

    public static void faireDepense(Depense depense) throws Exception{
        Connection conn = null;
        try{
            conn =  Conn.getConnection();
            conn.setAutoCommit(false);

            Credit credit = new Credit();
            credit.setId(depense.getIdCredit());
            BaseObject base = credit.getById();
            if(base == null) {
                throw new Exception("Credit indisponible");
            }
            credit = (Credit) base;
            
            double nouveauMontantCredit = credit.getMontant() - depense.getMontant();

            if(nouveauMontantCredit < 0) {
                throw new Exception("Montant du credit insuffisant");
            }
            
            credit.setMontant(nouveauMontantCredit);
            credit.updateById(conn);
            depense.save(conn);
            conn.commit();
            conn.setAutoCommit(true);
        }catch(Exception e) {
            conn.rollback();
            throw e;
        } finally{
            if(conn != null) conn.close();
        }
    }

}
