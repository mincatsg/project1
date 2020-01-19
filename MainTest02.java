package package1204;

import java.util.HashSet;
import java.util.Scanner;


public class MainTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            str = str.toUpperCase();
            String []arr = str.split(" ");
            for(int i = 0; i < arr.length; i++){
                hashSet.add(arr[i]);
            }
        }
        System.out.println(hashSet.size());
    }
}