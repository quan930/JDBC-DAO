package app.mrquan.service;

import app.mrquan.vo.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentService {
    /**
     * 学生数据的增加操作
     * 需要调用IStudentDAO.findById(String id)方法，判断要增加的数据是否存在
     * 如果要增加的数据不存在则调用IStudentDAO.docreat(Student vo)方法和ITelephoneDAO.(List<Telephone> vos)方法
     * @param vo 要增加的vo对象
     * @return
     * @throws SQLException
     */
    int[] insert(Student vo) throws SQLException;
    /**
     * 学生数据的批处理增加操作
     * 需要在创建list<Telephone>集合对象
     * @param vos 要增加的vo对象集合
     * @return
     * @throws SQLException
     */
    int[] insert(List<Student> vos) throws SQLException;

    /**
     * 判断id是否存在，根据id号增加电话号码
     * @param id 要加telephone表的id
     * @param tel 要加telephone表的tel
     * @return 成功返回1否则返回0
     * @throws SQLException
     */
    int insertTel(String id,String tel) throws SQLException;
    /**
     * 根据学生id返回student vo对象和电话集合
     * @param id 需要查询的对象
     * @return 有数据返回Student 对象，否则返回null
     * @throws SQLException
     */
    Student get(String id) throws SQLException;
    /**
     * 返回全部数据
     * @return 返回student 集合，没有size=0
     * @throws SQLException
     */
    List<Student> list() throws SQLException;
}
