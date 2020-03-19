package frank.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

//Lombok包下边的注解
@Getter
@Setter
@ToString
public class User {

    private Integer id;
    private String name;
    private Date createTime;   //java.util.Date


}
