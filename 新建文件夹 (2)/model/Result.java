package frank.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//Lombok包下边的注解
@Getter
@Setter
@ToString

//返回数据格式.
public class Result {

    private boolean success;
    private String code;
    private String message;
    private Object data;

}
