package app.mrquan.factory;

import app.mrquan.dao.IStudentDAO;
import app.mrquan.dao.ITelephoneDAO;
import app.mrquan.dao.impl.StudentDAOImpl;
import app.mrquan.dao.impl.TelephoneDAOImpl;

import java.sql.Connection;

public class DAOFactory {
    public static IStudentDAO getIStudentDAOInstance(){
        return new StudentDAOImpl();
    }
    public static ITelephoneDAO getITelephoneDAOInstance(){
        return new TelephoneDAOImpl();
    }
}
