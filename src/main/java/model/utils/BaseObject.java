package model.utils;

import java.sql.Connection;
import java.util.ArrayList;

public abstract class BaseObject {

    int id;

    public BaseObject() {

    }

    public BaseObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void save() throws Exception; 

    public abstract ArrayList<BaseObject> getAll() throws Exception;

    public abstract BaseObject getById() throws Exception ;

    public abstract void updateById() throws Exception;

    public abstract void deleteById() throws Exception ;

    public abstract void save(Connection conn) throws Exception; 

    public abstract ArrayList<BaseObject> getAll(Connection conn) throws Exception;

    public abstract BaseObject getById(Connection conn) throws Exception ;

    public abstract void updateById(Connection conn) throws Exception;

    public abstract void deleteById(Connection conn) throws Exception ;
    
}
