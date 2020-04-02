import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String targe = in.next();
        int x = in.nextInt();
        int count = 0;
        int len = 2 * x ;
        for(int i = 0; i < targe.length() - len; i++){
            String rr = targe.substring(i, x + i);
            for(int j = i + x + 1; j < targe.length(); j++){
                if(rr.charAt(0) == targe.charAt(j) && j + x < targe.length()){
                    String qq = targe.substring(j, j + x);
                    if(qq.equals(rr)){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
