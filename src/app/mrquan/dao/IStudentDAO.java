package app.mrquan.dao;

import app.mrquan.vo.Student;
import java.sql.SQLException;
import java.util.List;

/**
 * 定义student表的数据层的操作标准
 */
public interface IStudentDAO {
    /**
     *实现数据单一增加操作
     * @param vo 要增加的student对象
     * @return 数据保存成功返回1否则返回0
     * @throws SQLException
     */
    int add(Student vo) throws SQLException;

    /**
     * 实现数据批处理增加操作
     * @param vos 要增加的student对象集合
     * @return 数据保存成功返回增加数量否则返回0
     * @throws SQLException
     */
    int add(List<Student> vos) throws SQLException;
    /**
     *根据id返回vo对象
     * @param id 根据编号查询学生
     * @return 存在返回Student对象否则返回null
     * @throws SQLException
     */
    Student findById (String id) throws SQLException;
    /**
     *查询指定表的全部内容，以集合形式返回
     * @return student集合,没有集合长度为0
     * @throws SQLException
     */
    List<Student> findAll() throws SQLException;

}
