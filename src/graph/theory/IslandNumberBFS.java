package graph.theory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ClassName: IslandNumberBFS
 * Package: graph.theory
 * Description:
 *
 * @Author Zhe Deng
 * @Create 2025-06-16 04:16
 * @Version 1.0
 */
public class IslandNumberBFS {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 下右上左顺时针遍历

    public static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        Queue<Pair> queue = new LinkedList<>(); // 定义坐标队列，没有现成的Pair类，在下面自定义了
        queue.add(new Pair(x, y));
        visited[x][y] = true; // 遇到入队直接标记为已访问
        // 否则如果出队时才标记，会导致重复访问，比如下方节点会在右下顺序的时候被第二次访问入队

        while (!queue.isEmpty()) {
            int curX = queue.peek().x;
            int curY = queue.poll().y; // 当前横纵坐标

            for (int i = 0; i < 4; i++) {
                // 顺时针遍历新节点next，下面记录坐标
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];

                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                    continue; // 去除越界部分
                }

                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.add(new Pair(nextX, nextY));
                    visited[nextX][nextY] = true; // 逻辑同上
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 行数
        int n = sc.nextInt(); // 列数
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt(); // 输入网格数据
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans++; // 遇到新的岛屿块就计数+1
                    bfs(grid, visited, i, j); // 然后用BFS淹掉整块岛屿
                }
            }
        }

        System.out.println(ans); // 输出岛屿总数
    }

    // 自定义坐标Pair类
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
