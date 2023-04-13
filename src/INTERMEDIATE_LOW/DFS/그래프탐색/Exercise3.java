package INTERMEDIATE_LOW.DFS.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;

// 마을 구분하기
public class Exercise3 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N; //격자 크기
    public static int[][] grid;
    public static boolean[][] visited;
    public static int people = 1;
    public static ArrayList<Integer> villages = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(i, j);
                    villages.add(people);
                    people = 1;
                }
            }
        }

        Collections.sort(villages);
        System.out.println(villages.size());
        for (int i = 0; i < villages.size(); i++) {
            System.out.println(villages.get(i));
        }
    }

    private static void dfs(int x, int y) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                people++;
                dfs(nx, ny);
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return isInRange(x, y) && !visited[x][y] && grid[x][y] == 1;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }
}
