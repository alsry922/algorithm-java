package INTERMEDIATE_LOW.BFS.가중치가_동일한_그래프에서의_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 최소 경로로 탈출하기
public class Exercise1 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, M; //행, 열
    public static int[][] grid;
    public static int[][] step;
    public static boolean[][] visited;
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        visited = new boolean[N][M];
        step = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0][0] = true;
        bfsQ.add(new Pair(0, 0));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!bfsQ.isEmpty()) {
            Pair curr = bfsQ.poll();
            int cx = curr.x;
            int cy = curr.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    step[nx][ny] = step[cx][cy] + 1;
                    bfsQ.add(new Pair(nx, ny));
                }
            }
        }
        System.out.println(visited[N-1][M-1] ? step[N-1][M-1] : -1);
    }

    private static boolean canGo(int nx, int ny) {
        return isInRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 1;
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }
}
