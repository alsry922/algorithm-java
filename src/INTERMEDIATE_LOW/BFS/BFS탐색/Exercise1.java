package INTERMEDIATE_LOW.BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Exercise1 {
    public static int N, M; //행, 열
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1][1] = true;
        queue.add(new Pair(1, 1));
        bfs(1, 1);
        System.out.println(visited[N][M] ? 1 : 0);
    }

    private static void bfs(int x, int y) {
        while (!queue.isEmpty()) {
            Pair currV = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currV.x + dx[i];
                int nextY = currV.y + dy[i];
                if (canGo(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }

    }

    private static boolean canGo(int x, int y) {
        return isInRange(x, y) && grid[x][y] != 0 && !visited[x][y];
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }
}