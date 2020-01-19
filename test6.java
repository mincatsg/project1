public class test6 {
    //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    public boolean isPalindrome(int x) {
        String str = ""+ x;
        String str1 = "";
        for(int i = str.length() - 1;i >= 0; i--){
            str1 += str.charAt(i);
        }

        return str1.equals(str);
    }
}
