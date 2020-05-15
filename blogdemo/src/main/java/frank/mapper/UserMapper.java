package frank.mapper;

import frank.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    //单个参数时,mybatis的xml中配置parameterType就可以,如果多个参数,需要使用@Param
    User login(@Param("username") String username, @Param("password") String password);  //用Param注解的名字 在xml中查找条件名字就是注解名称
}