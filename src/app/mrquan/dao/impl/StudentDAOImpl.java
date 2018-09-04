package app.mrquan.dao.impl;

import app.mrquan.dao.IStudentDAO;
import app.mrquan.dbc.DatabaseConnection;
import app.mrquan.vo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class StudentDAOImpl implements IStudentDAO {
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    private Connection con;
    private PreparedStatement preparedStatement;
    public StudentDAOImpl(){
        this.con = databaseConnection.getConnection();
    }
    @Override
    public int add(Student vo) throws SQLException {
        int len = 0;
        try {
            preparedStatement = con.prepareStatement("insert into student values (?,?,?,?,?)");

            preparedStatement.setString(1,vo.getId());
            preparedStatement.setString(2,vo.getName());
            preparedStatement.setBoolean(3,vo.getSex());
            preparedStatement.setDate(4,new java.sql.Date(vo.getBirthday().getTime()));

            byte[] bytes = new byte[vo.getHeadPortrait().length];
            for(int i = 0; i < vo.getHeadPortrait().length; i++) {
                bytes[i] = vo.getHeadPortrait()[i];
            }
            preparedStatement.setBytes(5,bytes);

            len = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }finally {
            databaseConnection.close();
            return len;
        }
    }

    @Override
    public int add(List<Student> vos) throws SQLException {
        int lenTrue=0;
        try {
            preparedStatement = con.prepareStatement("insert into student values (?,?,?,?,?)");
            con.setAutoCommit(false);//1,首先把Auto commit设置为false,不让它自动提交
            for (int i = 0; i < vos.size(); i++) {
                preparedStatement.setString(1,vos.get(i).getId());
                preparedStatement.setString(2,vos.get(i).getName());
                preparedStatement.setBoolean(3,vos.get(i).getSex());
                preparedStatement.setDate(4,new java.sql.Date(vos.get(i).getBirthday().getTime()));

                byte[] bytes = new byte[vos.get(i).getHeadPortrait().length];
                for(int j = 0; j < vos.get(i).getHeadPortrait().length; j++) {
                    bytes[j] = vos.get(i).getHeadPortrait()[j];
                }
                preparedStatement.setBytes(5,bytes);
                preparedStatement.addBatch();
            }
            int[] len = preparedStatement.executeBatch();
            // 若成功执行完所有的插入操作，则正常结束
            con.commit();//2,进行手动提交（commit）
            lenTrue = len.length;
        }catch (SQLException e){
            con.rollback();
            throw e;
        }finally {
            con.setAutoCommit(true);//3,提交完成后回复现场将Auto commit,还原为true,
            databaseConnection.close();
            return lenTrue;
        }
    }

    @Override
    public Student findById(String id) throws SQLException {
        Student vo = null;
        try {
            preparedStatement = con.prepareStatement("select * from student where id = ?");
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                vo = new Student();
                vo.setId(rs.getString(1));
                vo.setName(rs.getString(2));
                vo.setSex(rs.getBoolean(3));
                vo.setBirthday(rs.getDate(4));

                byte [] byteBytes = rs.getBytes(5);
                Byte[] bytes = new Byte[byteBytes.length];
                int i = 0;
                for (byte b : byteBytes) bytes[i++] = b;
                vo.setHeadPortrait(bytes);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            databaseConnection.close();
            return vo;
        }
    }

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> all = new ArrayList<>();
        Student vo = null;
        try {
            preparedStatement = con.prepareStatement("select * from student");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                vo = new Student();
                vo.setId(rs.getString(1));
                vo.setName(rs.getString(2));
                vo.setSex(rs.getBoolean(3));
                vo.setBirthday(rs.getDate(4));

                byte [] byteBytes = rs.getBytes(5);
                Byte[] bytes = new Byte[byteBytes.length];
                int i = 0;
                for (byte b : byteBytes) bytes[i++] = b;
                vo.setHeadPortrait(bytes);

                all.add(vo);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            databaseConnection.close();
            return all;
        }
    }
}
