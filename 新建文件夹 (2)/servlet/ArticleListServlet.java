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
import java.util.ArrayList;
import java.util.List;

//注解和xml配置的方式二选一:路径必须是/开头的.
@WebServlet("/articleList")
public class ArticleListServlet extends BaseServlet {


    @Override
    public Object process(HttpServletRequest req) throws Exception{
        //请求的参数: 用户id
        Integer id = Integer.parseInt(req.getParameter("id"));

        //TODO 需要把文章信息保存到数据库
        List<Article> articles = ArticleDAO.listArticle(id);
        return articles;
    }
}
