package lessonG2;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        for(String str : list){
            System.out.println(str);
            if("B".equalsIgnoreCase(str)){
                list.remove("B");
            }
        }
        System.out.println(list);
//        Iterator<String> it = list.iterator();
//        while(it.hasNext()){
//            String str = it.next();
//            if("B".equalsIgnoreCase(str))
//                it.remove();
//        }
    }

}
