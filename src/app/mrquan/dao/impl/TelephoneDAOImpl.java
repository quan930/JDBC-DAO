package app.mrquan.dao.impl;

import app.mrquan.dao.ITelephoneDAO;
import app.mrquan.dbc.DatabaseConnection;
import app.mrquan.vo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelephoneDAOImpl implements ITelephoneDAO {
    private Connection con;
    private PreparedStatement preparedStatement;
    private DatabaseConnection databaseConnection = new DatabaseConnection();
    public TelephoneDAOImpl (){
        this.con = databaseConnection.getConnection();
    }
    @Override
    public int add(Student vo) throws SQLException {
        int lenTrue=0;
        String id = vo.getId();
        List<String> trls = vo.getTels();
        try {
            preparedStatement = con.prepareStatement("insert into telephone values (?,?)");
            con.setAutoCommit(false);//1,首先把Auto commit设置为false,不让它自动提交
            for (int i = 0; i < trls.size(); i++) {
                preparedStatement.setString(1,id);
                preparedStatement.setString(2,trls.get(i));
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
    public int add(List<Student> vos) throws SQLException {
        int lenTrue=0;
        try {
            preparedStatement = con.prepareStatement("insert into telephone values (?,?)");
            con.setAutoCommit(false);//1,首先把Auto commit设置为false,不让它自动提交
            for (int i = 0; i < vos.size(); i++) {
                String id = vos.get(i).getId();
                List<String> trls = vos.get(i).getTels();
                for (int j = 0; j < trls.size(); j++) {
                    preparedStatement.setString(1,id);
                    preparedStatement.setString(2,trls.get(j));
                    preparedStatement.addBatch();
                }
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
    public List<String> findByID(String id) throws SQLException {
        List<String> all = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement("select tel from telephone where id = ?");
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                all.add(rs.getString("tel"));
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            databaseConnection.close();
            return all;
        }
    }
}
