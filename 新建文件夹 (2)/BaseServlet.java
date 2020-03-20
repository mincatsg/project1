package frank.servlet;

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

/**
 * 1.发送/articleList的http请求
 * 2.tomcat接受http请求,根据路径找到对应的Servlet
 * 3.根据当前的Servlet对象,调用service方法
 * 4.service方法中调用子类(BaseServlet)重写doGet或者doPost方法
 * 5.doGet/doPost调用ArticleListServlet的process.
 */

public abstract class BaseServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");

        PrintWriter pw = resp.getWriter();
        Result result = new Result();  //返回信息都在这.

        try {
            result.setSuccess(true);
            result.setCode("200xx"); //自定义的错误码
            result.setMessage("OK");
            result.setData(process(req));
        } catch (Exception e) {
            result.setCode("500xx");
            result.setMessage("服务器出错了");
        }

        pw.println(JSONUtil.serialize(result));
        pw.flush();
    }

    public abstract Object process(HttpServletRequest req) throws Exception;
}
