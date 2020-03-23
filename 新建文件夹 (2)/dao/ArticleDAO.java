package frank.dao;

import frank.model.Article;
import frank.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleDAO {

    //文章添加
    public static boolean addArticle(Article article){
         //jdbc操作步骤
        Connection connection = null;
        PreparedStatement ps = null;

        try{
            //1.保证数据库user表中有数据
            //2.保证article对象中userId属性和user表中id是一致
          connection = DBUtil.getConnection();
          String sql = "insert into article(title, content, user_id, create_time)" + " values (?, ?, ?, ?)";
          ps = connection.prepareStatement(sql);
          //替换占位符
          ps.setString(1, article.getTitle());
          ps.setString(2, article.getContent());
          ps.setInt(3, article.getUserId());
          ps.setTimestamp(4, new Timestamp(new Date().getTime()));

          int num = ps.executeUpdate();
          return num > 0;
        }catch (Exception e){
            throw new RuntimeException("查询文章列表jdbc操作失败: ", e);
        }finally {
            DBUtil.close(connection, ps);
        }
    }


    public static List<Article> listArticle(Integer id) {
        //jdbc操作步骤
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Article> articles = new ArrayList<>();
        try{
            //1.保证数据库user表中有数据
            //2.保证article对象中userId属性和user表中id是一致
            connection = DBUtil.getConnection();
            String sql = "select id, title, content, user_id, create_time" + " from article where user_id=?";
            ps = connection.prepareStatement(sql);
            //替换占位符
              ps.setInt(1, id);

            resultSet = ps.executeQuery();
            while(resultSet.next()){
                Article article = new Article();
                //添加article对象的属性
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(id);
                article.setCreateTime(new Date(
                        resultSet.getTimestamp("create_time").getTime()
                ));
                articles.add(article);
            }
            return articles;
        }catch (Exception e){
            throw new RuntimeException("文章添加jdbc操作失败: ", e);
        }finally {
            DBUtil.close(connection, ps, resultSet);
        }

    }

    public static Article queryArticleById(Integer id) {
        //jdbc操作步骤
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try{
            //1.保证数据库user表中有数据
            //2.保证article对象中userId属性和user表中id是一致
            connection = DBUtil.getConnection();
            String sql = "select id, title, content, user_id, create_time" + " from article where id=?";
            ps = connection.prepareStatement(sql);
            //替换占位符
            ps.setInt(1, id);

            resultSet = ps.executeQuery();
            Article article = new Article();
            while(resultSet.next()){
                //添加article对象的属性
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(id);
                article.setCreateTime(new Date(
                        resultSet.getTimestamp("create_time").getTime()
                ));
            }
            return article;
        }catch (Exception e){
            throw new RuntimeException("查询文章详细信息jdbc操作失败: ", e);
        }finally {
            DBUtil.close(connection, ps, resultSet);
        }
    }
}
