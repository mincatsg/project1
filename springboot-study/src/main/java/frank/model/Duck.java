package frank.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Duck {

    private String name;

    private Integer age;

    public Duck(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
