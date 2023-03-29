package DFS.그래프탐색;
// 마을 구분하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Exercise3 {
    public static int n; //grid size;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int village;
    public static int peopleCnt;
    public static ArrayList<Integer> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        n = Integer.parseInt(br.readLine());

        grid = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    peopleCnt = 1;
                    dfs(new Pair(i, j));
                    village++;
                    people.add(peopleCnt);
                    peopleCnt = 0;
                }
            }
        }

        Collections.sort(people);
        sb.append(village).append("\n");
        for (Integer ele : people) {
            sb.append(ele).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(Pair currV) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nextX = currV.x + dx[i];
            int nextY = currV.y + dy[i];
            if (canGo(nextX, nextY)) {
                visited[nextX][nextY] = true;
                peopleCnt++;
                dfs(new Pair(nextX, nextY));
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return isInRange(x,y) && !visited[x][y] && grid[x][y] == 1;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }
}
