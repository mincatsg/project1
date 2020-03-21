package dao;

import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

// 这个类负责针对 Project 对象进行数据操作
public class ProjectDao {
    public void save(Project project) {
        // 通过 save 方法就能把一个 project 对象保存到 数据库 中
        // 1. 获取到数据库连接
        Connection connection = DBUtil.getConnection();
        // 2. 构造 PrepareStatement 对象拼装 SQL 语句
        PreparedStatement statement = null;
        String sql = "insert into project_table values(?, ?, ?, ?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getUrl());
            statement.setString(3, project.getDescription());
            statement.setInt(4, project.getStarCount());
            statement.setInt(5, project.getForkCount());
            statement.setInt(6, project.getOpenIssueCount());
            // 预期想往数据库中插入的日期形如: 20200321
            // 可以根据当前系统时间 + SimpleDateFormat 类来完成
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd"); //设置日期格式
//            statement.setString(7, simpleDateFormat.format(System.currentTimeMillis()));
            statement.setString(7, simpleDateFormat.format(new Date().getTime()));
            // 3. 执行 SQL 语句, 完成数据库插入操作
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("当前数据库执行插入数据出错");
                return;
            }
            System.out.println("数据插入成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
