package frank.dao;

import frank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDAO {

    public boolean verify(String username, String password) {
        //jdbc操作步骤
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where username=? and password=?";
            ps = connection.prepareStatement(sql);
            //替换占位符
            ps.setString(1, username);
            ps.setString(2, password);
            //获取结果,有结果就数据库里有数据,否则没有
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                //登录成功就改变状态和时间.
                updateUser(username);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("查询失败", e);
        } finally {
            DBUtil.close(connection, ps, resultSet);
        }
    }

    public void updateUser(String username) {
        //jdbc操作步骤
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update user set status=?, time=?  where username=?";
            ps = connection.prepareStatement(sql);
            //替换占位符
            ps.setString(1, "yes");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期格式
            ps.setString(2, simpleDateFormat.format(new Date().getTime()));
            ps.setString(3, username);
            //获取结果,有结果就数据库里有数据,否则没有
            int one = ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("查询失败", e);
        } finally {
            DBUtil.close(connection, ps, null);
        }
    }
}
