package BaekJoon;
//토마토

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek7576 {
    public static int m, n; //행, 열
    public static int[][] grid;
    public static Queue<Vertex> bfsQ = new LinkedList<>();
    public static int answer = 0;

    static class Vertex {
        int x, y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 열
        m = Integer.parseInt(st.nextToken()); // 행

        grid = new int[m + 1][n + 1];

        /*익은 토마토 전부 큐에 넣기*/
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    bfsQ.add(new Vertex(i, j));
                }
            }
        }

        bfs();

        int result = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i][j] == 0) {
                    answer = -1;

                } else {
                    result = Math.max(result, grid[i][j]);
                }
            }
        }
        System.out.println(answer == -1 ? answer : result-1);
    }

    private static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        /*큐가 빌 때까지 탐색 가능한 위치 탐색*/
        while (!bfsQ.isEmpty()) {
            Vertex currV = bfsQ.poll();
            int currX = currV.x;
            int currY = currV.y;
            for (int i = 0; i < 4; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if (canGo(nextX, nextY)) {
                    grid[nextX][nextY] = grid[currX][currY] + 1;
                    bfsQ.add(new Vertex(nextX, nextY));
                }
            }
        }
    }

    /*해당 위치가 탐색 가능한지 판별*/
    private static boolean canGo(int x, int y) {
        return isInRange(x, y) && grid[x][y] == 0;
    }
    /*해당 위치가 격자 범위 안에 있는지 판별*/
    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= m && y >= 1 && y <= n;
    }


}
