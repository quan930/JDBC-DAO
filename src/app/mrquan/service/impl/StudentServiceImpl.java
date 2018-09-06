package app.mrquan.service.impl;

import app.mrquan.factory.DAOFactory;
import app.mrquan.service.IStudentService;
import app.mrquan.vo.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    @Override
    public int insert(Student vo) throws SQLException {
        return DAOFactory.getIStudentDAOInstance().add(vo);
    }

    @Override
    public int insert(List<Student> vos) throws SQLException {
        return DAOFactory.getIStudentDAOInstance().add(vos);
    }

    @Override
    public Student get(String id) throws SQLException {
        return DAOFactory.getIStudentDAOInstance().findById(id);
    }

    @Override
    public List<Student> list() throws SQLException {
        return DAOFactory.getIStudentDAOInstance().findAll();
    }
}
