package frank.ioc;

public class DuckFactory {


    public Duck create(){
        return new Duck("duck5");
    }

    public static Duck create2(){
        return new Duck("duck6");
    }
}
