package INTERMEDIATE_LOW.DFS.DFS탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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

    public static int N, M; //격자 행, 열
    public static int[][] grid;
    public static boolean[][] visited;

    public static final int DIR_NUM = 2;
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visited[0][0] = true;
        dfs(new Pair(0, 0));

        bw.append(visited[N-1][M-1] ? "1" : "0").append("\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(Pair curPos) {
        int cx = curPos.x;
        int cy = curPos.y;
        for (int i = 0; i < DIR_NUM; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if (canMove(nx, ny)) {
                visited[nx][ny] = true;
                dfs(new Pair(nx, ny));
            }
        }
    }

    public static boolean canMove(int x, int y) {
        return inRange(x, y) && grid[x][y] != 0 && !visited[x][y];
    }

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }
}
