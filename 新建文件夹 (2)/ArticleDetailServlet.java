package frank.servlet;

import frank.dao.ArticleDAO;
import frank.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req) throws Exception {
      Integer id = Integer.parseInt(req.getParameter("id"));

        //TODO 从数据库拿出数据
      Article article = ArticleDAO.queryArticleById(id);
      return article;
    }
}
