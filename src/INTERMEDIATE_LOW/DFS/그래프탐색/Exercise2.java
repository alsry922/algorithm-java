package INTERMEDIATE_LOW.DFS.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//두 방향 탈출 가능 여부 판별하기
public class Exercise2 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M; //행, 열
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[][] order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        order = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1][1] = true;
        dfs(1, 1);
        System.out.println(visited[N][M] ? 1 : 0);
    }

    private static void dfs(int x, int y) {
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(nx, ny)) {
                visited[nx][ny] = true;
                order[nx][ny] = order[x][y] + 1;
                dfs(nx, ny);
            }
        }
    }

    private static boolean canGo(int x, int y) {
        return isInRange(x, y) && !visited[x][y] && grid[x][y] == 1;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
}
