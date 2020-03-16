package frank.demo;

public class ServletDemo {

    public static void main(String[] args) {
        //模拟tomcat处理http请求,调用servlet对象的service
        //对于一个对象的方法调用,从下往上开始查找方法.
        new ArticleListServlet().service("get");
    }
    private static class HttpServlet{

        public void service(String method){
            if("get".equalsIgnoreCase(method)){
                doGet();
            }else{
                doPost();
            }
        }

        public void doGet(){
            System.out.println("httpServlet do get");
        }

        public void doPost() {
            System.out.println("httpServlet do post");
        }
    }

    private static class ArticleListServlet extends HttpServlet{

        @Override
        public void doGet(){
            System.out.println("ArticleListServlet do get");
        }

        @Override
        public void doPost(){
            System.out.println("ArticleListServlet do get");
        }
    }
}
