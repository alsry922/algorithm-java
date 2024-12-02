package INTERMEDIATE_LOW.BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        bfsQ.add(new Pair(0, 0));

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!bfsQ.isEmpty()) {
            Pair p = bfsQ.poll();
            int x = p.x, y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canMove(nx, ny)) {
                    visited[nx][ny] = true;
                    bfsQ.add(new Pair(nx, ny));
                }
            }
        }
        bw.write(visited[N - 1][M - 1] ? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean canMove(int x, int y) {
        if (!inRange(x, y)) return false;

        return grid[x][y] == 1 && !visited[x][y];
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
