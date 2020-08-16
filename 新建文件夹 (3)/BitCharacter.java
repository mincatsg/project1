package InterviewTraining;

public class BitCharacter {
//    有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
//
//    现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
public boolean isOneBitCharacter(int[] bits) {
    int m = bits.length;
    if(bits[m - 1] != 0){
        return false;
    }
    for(int i = 0; i < m - 1; i++){
        if(bits[i] == 1){
            if(i + 1 < m - 1 && (bits[i + 1] == 0 || bits[i + 1] == 1)){
                i++;
            }
            else{
                return false;
            }
        }
    }
    return true;
}
}
