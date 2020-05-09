package frank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MVCConfig implements WebMvcConfigurer {
    /**
     * 根据url进行拦截，调用配置的拦截器进行处理
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 除了/login.html，/user/login两个url请求，其他全部要被拦截
        // 所有的拦截器依次执行：
        // interceptor.preHandle()--->controller.映射方法()--->interceptor.postHandle()
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/error");
    }
}
