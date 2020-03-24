package frank.servlet;

import frank.dao.ArticleDAO;
import frank.model.Article;
import frank.model.Result;
import frank.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//注解和xml配置的方式二选一:路径必须是/开头的.
@WebServlet("/articleAdd")
public class ArticleAddServlet extends BaseServlet {


    @Override
    public Object process(HttpServletRequest req) throws Exception {
        //请求的JSON数据转变为java对象(反序列化)
        Article article = JSONUtil.deserialize(req.getInputStream(), Article.class);
        article.setUserId(1);
        System.out.println("请求数据: " +article);

        //TODO 需要把文章信息保存到数据库
        if(!ArticleDAO.addArticle(article)){
            throw new RuntimeException("文章添加失败");
        }

        return null;
    }
}
