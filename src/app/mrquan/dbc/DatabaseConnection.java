package app.mrquan.dbc;


import java.sql.*;
/**
 * 本类专门负责数据库的连接与关闭操作，在实例化本类对象是意味这要进行数据库的开发
 * 所以在本类的构造方法里要进行数据库驱动加载与数据库连接取得
 */

public class DatabaseConnection {
    private static final String DBDRIVER = "org.postgresql.Driver";
    private static final String DBURL = "jdbc:postgresql://localhost:5432/daquan";
    private static final String DBUSER = "postgres";
    private static final String DBPASSWORD = "123456";
    private Connection connection = null;

    public DatabaseConnection(){
        try {
            Class.forName(DBDRIVER);
            this.connection = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}