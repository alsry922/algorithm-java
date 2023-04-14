package INTERMEDIATE_LOW.BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 갈 수 있는 곳들
public class Exercise2 {
    static class Vertex {
        int x, y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int N, K; //격자 크기
    public static int[][] grid;
    public static boolean[][] visited;
    public static int answer;
    public static Queue<Vertex> bfsQ = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited[x-1][y-1] = true;
            bfsQ.add(new Vertex(x-1, y-1));
            answer++;
        }

        while (!bfsQ.isEmpty()) {
            Vertex currV = bfsQ.poll();
            int x = currV.x;
            int y = currV.y;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    answer++;
                    bfsQ.add(new Vertex(nx, ny));
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean canGo(int x, int y) {
        if (!isInRange(x, y)) {
            return false;
        }

        if (visited[x][y] || grid[x][y] == 1) {
            return false;
        }

        return true;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}

