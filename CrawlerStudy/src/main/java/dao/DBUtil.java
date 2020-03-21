package dao;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


// 这是一个单例类, 帮我们管理数据库的连接
public class DBUtil {
    // 对于我来说, 我的 MySQL 服务器在云服务器上, 这个代码就无法通过以下 URL 在本地执行.
    // 后面执行的时候, 我就需要把代码部署到云服务器上, 然后在服务器上执行.
    private static String URL = "jdbc:mysql://localhost:3306/java_github_crawler";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    private static volatile DataSource dataSource = null;

    // 线程不安全
    //线程安全 （双重if判断 + synchronized关键字 + volatile）
    private static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    // 向下转型
                    MysqlDataSource mysqlDataSource = (MysqlDataSource)dataSource;
                    mysqlDataSource.setURL(URL);
                    mysqlDataSource.setUser(USERNAME);
                    mysqlDataSource.setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
               preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("释放失败", e);
        }
    }
}