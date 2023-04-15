package INTERMEDIATE_LOW.BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//돌 잘 치우기
public class Exercise4 {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N, M, K; //격자 크기, 치울 돌 갯수, 시작점 수
    public static int[][] grid;
    public static boolean[][] visited;
    public static ArrayList<Pos> stones = new ArrayList<>();
    public static Pos[] start;
    public static Queue<Pos> bfsQ = new LinkedList<>();
    public static int MAX = -1;
    public static int cnt = 0;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        visited = new boolean[N][N];
        start = new Pos[K];

        inputGrid();
        inputStart();

        moveStone(0, 0);
        System.out.println(MAX);
    }

    private static void moveStone(int idx, int cnt) {
        if (idx == stones.size()) {
            if (cnt == M) {
                BFS();
            }
            return;
        }

        Pos stone = stones.get(idx);
        grid[stone.x][stone.y] = 0;
        moveStone(idx + 1, cnt + 1);
        grid[stone.x][stone.y] = 1;
        moveStone(idx + 1, cnt);
    }

    private static void BFS() {
        initVisited();
        cnt = 0;

        for (int i = 0; i < K; i++) {
            visited[start[i].x][start[i].y] = true;
            cnt++;
            bfsQ.add(new Pos(start[i].x, start[i].y));
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!bfsQ.isEmpty()) {
            Pos curr = bfsQ.poll();
            int cx = curr.x;
            int cy = curr.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    cnt++;
                    bfsQ.add(new Pos(nx, ny));
                }
            }
        }
        MAX = Math.max(MAX, cnt);
    }

    private static boolean canGo(int nx, int ny) {
        return isInRange(nx, ny) && !visited[nx][ny] && grid[nx][ny] == 0;
    }

    private static boolean isInRange(int nx, int ny) {

        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }

    private static void initVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static void inputGrid() throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    stones.add(new Pos(i, j));
                }
            }
        }
    }

    private static void inputStart() throws IOException {
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            start[i] = new Pos(x-1, y-1);
        }
    }
}
