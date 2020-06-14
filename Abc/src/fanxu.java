import java.util.Scanner;

public class fanxu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("ÇëÊäÈë×Ö·û´® :");
	 Scanner in =new Scanner(System.in);
      String text=in.nextLine();
      System.out.println(text);
      System.out.println("×Ö·û´®¸öÊý:"+text.length());
         int x=text.length();
       System.out.println(x);
     for(int i=text.length()-1;i>=0;i--)
    	 System.out.print(text.charAt(i));
	}

}
