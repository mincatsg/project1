public class upper { //字符串中大写字母转为小写
    public String toLowerCase(String str) {
        String newStr = "";
        for(int i = 0; i < str.length(); i++){ //大写字母 65 - 90 小写字母 97 - 122
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                newStr += (char)('a' - 'A' + str.charAt(i));
            }else{
                newStr += str.charAt(i);
            }
        }
        return newStr;
    }

}
