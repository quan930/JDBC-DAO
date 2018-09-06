package app.mrquan.factory;

import app.mrquan.dao.IStudentDAO;
import app.mrquan.dao.impl.StudentDAOImpl;


public class DAOFactory {
    public static IStudentDAO getIStudentDAOInstance(){
        return new StudentDAOImpl();
    }
}
