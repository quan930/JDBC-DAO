package app.mrquan.dao;

import app.mrquan.vo.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * 定义业务层student表和telephone表的操作标准
 */
public interface ITelephoneDAO {
    /**
     * 实现电话表的增加操作
     * @param vo 要增加的Student 对象
     * @return 数据保存成功返回true
     * @throws SQLException
     */
    int add(Student vo) throws SQLException;

    /**
     * 实现电话表的批处理增加操作
     * @param vos 要增加的Telephone 集合对象
     * @return 数据保存成功返回1否则返回0
     * @throws SQLException
     */
    int add(List<Student> vos) throws SQLException;
    /**
     * 根据学生ID号查询电话
     * @param id telephone id 即 student id
     * @return 存在id对应的电话集合，没有size=0
     * @throws SQLException
     */
    List<String> findByID (String id) throws SQLException;
}