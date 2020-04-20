package frank.scan;


import frank.ioc.Duck;
import frank.ioc.DuckShop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Conf {

    //也可以这样把对象注册到Bean容器
    //1.方法名是注册到容器中的对象名
    @Bean
    public Duck duck3(){
        return new Duck("duck33333");
    }

    //2.传入@Bean的参数为注册到容器中的对象名
    @Bean("duck4")
    public Duck duck44444444(){
        return new Duck("唐老鸭");
    }

    @Bean
    public DuckShop duckShop2(Duck duck5, Duck duck6){
        DuckShop duckShop = new DuckShop();
        duckShop.setName("比特卤鸭店");
        List<Duck> ducks = new ArrayList<>();
        System.out.printf("=====================duck5=%s, duck6=%s\n", duck5.getName(), duck6.getName());
        ducks.add(duck5);
        ducks.add(duck6);
        duckShop.setDucks(ducks);
        return duckShop;
    }

}
