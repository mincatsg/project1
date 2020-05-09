package frank.config;

import frank.model.Duck;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Configuration
public class ControllerInterceptor {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Duck handle(){
        return new Duck("异常鸭子", 123);
    }
}
