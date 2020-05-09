package frank.controller;

import frank.model.Duck;
import frank.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(User user, HttpServletRequest request){
        System.out.printf("username=%s, password=%s\n", user.getUsername(), user.getPassword());
        //校验用户名和密码，校验通过，设置用户身份信息到session
        if("abc".equals(user.getUsername()) && "123".equals(user.getPassword())) {
            HttpSession session = request.getSession();//默认是true，如果获取不到session，就创建
            session.setAttribute("user", user);
            return "redirect:/user/login6";//登录成功，返回首页
        }else if("a".equals(user.getUsername())){
            throw new RuntimeException("用户名为a，出错了");// /error
        }else{
            return "/login.html";
        }
    }

    @RequestMapping(value = "/login_0", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Duck login_0(User user){
        System.out.printf("username=%s, password=%s\n", user.getUsername(), user.getPassword());
        return new Duck("LadyGaga0", 3);
    }

    @RequestMapping(value = "/login2", method = RequestMethod.GET)
    public String login2(HttpServletRequest request, HttpServletResponse response){
        return "/login.html";
    }

    @RequestMapping("/login3")
    public String login3(){
        // 先做一部分业务操作
        return "redirect:/user/login";
    }

    @RequestMapping(value = "/{id}/login4", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Duck login4(@PathVariable("id") Integer id){
        System.out.printf("id=%s\n", id);
        return new Duck("LadyGaga", 2);
    }

    @RequestMapping(value = "/login5", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Duck login5(@RequestBody User user){
        System.out.printf("username=%s, password=%s\n", user.getUsername(), user.getPassword());
        return new Duck("LadyGaga0", 3);
    }

    @RequestMapping("/login6")
    public String login6(Model model){//返回freemark动态网页模板生成的网页内容
        model.addAttribute("duck", new Duck("LadyGaga0", 3));
        return "/index";
    }

    /**
     * 两个问题：
     * 1.如果方法抛异常了，怎么处理？
     * 2.如果涉及到敏感url，比如需要登录后才可以访问的url，怎么处理？
     */
}
