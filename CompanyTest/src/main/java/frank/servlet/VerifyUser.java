package frank.servlet;

import frank.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class VerifyUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        //获取表单的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取数据库连接调用方法.
        UserDAO userDAO = new UserDAO();
        boolean judge = userDAO.verify(username, password);

        //数据库里存的是用户名 mingming 234, wozhende 123。
        if(judge){
            resp.setStatus(200);
            resp.getWriter().write("登陆成功");
        }else{
            resp.setStatus(404);
            resp.getWriter().write("用户名密码未识别, 登陆失败");
            return;
        }
    }
}
