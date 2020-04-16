package frank.ioc;

import java.util.List;


public class DuckShop {

    private String name;

    private List<Duck> ducks;


    public String getName() {
        return name;
    }

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }

    @Override
    public String toString() {
        return "DuckShop{" +
                "name='" + name + '\'' +
                ", ducks=" + ducks +
                '}';
    }
}
