package INTERMEDIATE_LOW.BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//네 방향 탈출 가능 여부 판별하기
public class Exercise1 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M; //행 열
    public static int[][] grid; //격자
    public static boolean[][] visited;
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        bfsQ.add(new Pair(0, 0));

        while (!bfsQ.isEmpty()) {
            Pair currV = bfsQ.poll();
            int x = currV.x;
            int y = currV.y;

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    bfsQ.add(new Pair(nx, ny));
                }
            }
        }
        System.out.println(visited[N - 1][M - 1] ? 1 : 0);
    }

    private static boolean canGo(int x, int y) {
        return isInRange(x, y) && !visited[x][y] && grid[x][y] == 1;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}