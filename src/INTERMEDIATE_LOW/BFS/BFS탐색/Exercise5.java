package INTERMEDIATE_LOW.BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//빙하
public class Exercise5 {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N, M; //행, 열
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<Pos> bfsQ = new LinkedList<>();
    public static int lastMeltCnt, time;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];

        inputGrid();

        while (glacierExists()) {
            melt();
            time++;
        }
        System.out.println(time + " " + lastMeltCnt);
    }

    private static boolean glacierExists() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void melt() {
        initVisited();
        lastMeltCnt = 0;
        bfsQ.add(new Pos(0, 0));
        visited[0][0] = true;

        BFS();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1 &&
                        waterExistsInNeighbor(i, j)) {
                    grid[i][j] = 0;
                    lastMeltCnt++;
                }
            }
        }
    }

    private static boolean waterExistsInNeighbor(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (visited[nx][ny]) {
                return true;
            }
        }
        return false;
    }

    private static void BFS() {
        while (!bfsQ.isEmpty()) {
            Pos curr = bfsQ.poll();
            int cx = curr.x;
            int cy = curr.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    bfsQ.add(new Pos(nx, ny));
                }
            }
        }
    }

    private static boolean canGo(int nx, int ny) {
        return isInRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 0;
    }

    private static boolean isInRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }


    private static void initVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void inputGrid() throws IOException {
        for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
