package frank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BlogConfig implements WebMvcConfigurer {


   /**
    * 根据url进行拦截,调用配置的拦截器进行处理
    * @param registry
    */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //除了/login.html, /login俩个url请求, 其他全部要拦截.
        //所有拦截器依次执行:
        // Interceptor.preHandle()--->controller.映射方法()--->interceptor.postHandle()
        registry.addInterceptor(new loginInterceptor())
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/plugins/editor/**")
                .excludePathPatterns("/")
                .excludePathPatterns("/a/**")
                .excludePathPatterns("/login");  //  /* 匹配一级路径 /a/1  /** 匹配多级路径
    }
}
