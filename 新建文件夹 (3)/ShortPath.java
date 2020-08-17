package InterviewTraining;

import java.util.LinkedList;
import java.util.Queue;

public class ShortPath {
//    在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
//
//    一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
//
//    相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
//    C_1 位于 (0, 0)（即，值为 grid[0][0]）
//    C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
//    如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
//    返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
public int shortestPathBinaryMatrix(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    // 当矩阵第一个元素为1或者最后一个元素为1时，直接返回-1
    if(grid[0][0]==1 || grid[grid.length-1][grid[0].length-1]==1) return -1;
    grid[0][0] = 1;
    // 创建队列用于保存每一格可以走的步
    Queue<int[]> q=new LinkedList<>();
    q.add(new int[]{0, 0});
    // 队列长度,c要和队列做对比,知道何时到达队列长度
    int len = q.size();
    int c = 0;  //把每一个for循环的出完才能加path + 1.
    // 定义八个方向
    int[][] dir = {{0, 1},{1, 0}, {1, 1}, {1,-1}, {0, -1}, {-1, 0},{-1, -1}, {-1, 1}};
    // 定义最短路径长度
    int path = 1;
    while(!q.isEmpty()){
        int[] data = q.poll();
        // x、y代表当前的坐标（x，y）
        int x = data[0];
        int y = data[1];
        // 如果走到最后一格，返回
        if(x == m - 1 && y == n - 1) return path;
        // 此处填充队列，将可走的步添加进队列
        for(int[] d : dir){
            // x1，y1代表当前坐标移动后的坐标（x1，y1）
            int x1 = x + d[0];
            int y1 = y + d[1];
            if(x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && grid[x1][y1] == 0){
                q.add(new int[]{x1, y1});
                grid[x1][y1] = 1;
            }
        }
        c++;
        if(c == len){
            c = 0;
            path++;
            len = q.size();
        }
    }
    return -1;

}

}
