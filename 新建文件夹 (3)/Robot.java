import java.util.*;

public class Robot {
    public int countWays(int x, int y) {
       int[][] ans = new int[x][y];
        for(int i = 0; i < x; i++){
            ans[i][0] = 1;
        }
        for(int i = 0; i < y; i++){
            ans[0][i] = 1;
        }
        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1]; 
           }
        }
        return ans[x - 1][y - 1];
    }
}