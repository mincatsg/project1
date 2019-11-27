package StringTest;

public class MyString {
    public String str1;

    public MyString(String str1) {
        this.str1 = str1;
    }

    public boolean Equals(String str){
        if(str.length() == str1.length()){
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) != str1.charAt(i)){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }
    public int CompareTo(String str){
        int len1 = str.length();
        int len2 = str1.length();
        int i = 0;
        int j = 0;
        while((i < len1) && (j < len2)){
            if(str.charAt(i) > str1.charAt(j)){
                return str1.charAt(j) - str.charAt(i);
            }else if(str.charAt(i) < str1.charAt(j)){
                return str.charAt(i) - str1.charAt(j);
            }else{
                i++;
                j++;
            }
        }
        if(i == len1 && j == len2){
            return 0;
        }else if(i < len1){
            return -1;
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {
        MyString str = new MyString("hah");
        System.out.println("hah".compareTo("haha"));
        System.out.println(str.CompareTo("haha"));
        char [] arr = "haha".toCharArray();
        for(char x: arr){
            System.out.println(x);
        }
    }

}

