package InterviewTraining;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Smallest_K {
//    最小的K个数
//    输入n个整数，找出其中最小的K个数
public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    ArrayList<Integer> ans = new ArrayList<>();
    if(k <= 0 || input.length == 0 || k > input.length){
        return ans;
    } 
    Arrays.sort(input);
    for(int i = 0; i < k; i++){
        ans.add(input[i]);
    }
    return ans;
  }
}
