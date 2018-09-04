package app.mrquan.service.impl;

import app.mrquan.factory.DAOFactory;
import app.mrquan.service.IStudentService;
import app.mrquan.vo.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    @Override
    public int[] insert(Student vo) throws SQLException {
        int[]len = {0,0};
        if (DAOFactory.getIStudentDAOInstance().findById(vo.getId())==null){//id不存在
            len[0] = DAOFactory.getIStudentDAOInstance().add(vo);
            if (len[0]==1){
                len[1] = DAOFactory.getITelephoneDAOInstance().add(vo);
            }
        }
        return len;
    }

    @Override
    public int[] insert(List<Student> vos) throws SQLException {
        int[] len = {0,0};
        len[0] = DAOFactory.getIStudentDAOInstance().add(vos);
        if (len[0]>0){
            len[1] = DAOFactory.getITelephoneDAOInstance().add(vos);
        }
        return len;
    }

    @Override
    public int insertTel(String id, String tel) throws SQLException {
        if(DAOFactory.getIStudentDAOInstance().findById(id) != null){
            Student vo = new Student();
            List<String> addTel = new ArrayList<>();
            addTel.add(tel);
            vo.setId(id);
            vo.setTels(addTel);
            return DAOFactory.getITelephoneDAOInstance().add(vo);
        }else {
            return 0;
        }
    }

    @Override
    public Student get(String id) throws SQLException {
        Student vo = DAOFactory.getIStudentDAOInstance().findById(id);
        if (vo!=null){
            vo.setTels(DAOFactory.getITelephoneDAOInstance().findByID(id));
        }
        return vo;
    }

    @Override
    public List<Student> list() throws SQLException {
        List<Student> vos;
        vos = DAOFactory.getIStudentDAOInstance().findAll();
        for (int i = 0; i < vos.size(); i++) {
            if (vos.get(i)!=null){
                vos.get(i).setTels(DAOFactory.getITelephoneDAOInstance().findByID(vos.get(i).getId()));
            }
        }
        return vos;
    }
}
