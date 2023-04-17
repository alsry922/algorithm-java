package INTERMEDIATE_LOW.BFS.가중치가_동일한_그래프에서의_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//k개의 벽 없애기
public class Exercise4 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int DIR_NUM = 4;
    public static int N, K; //격자 크기, 없애야 할 벽의 갯수
    public static int[][] grid;
    public static boolean[][] visited;
    public static int[][] step;
    public static ArrayList<Pair> walls = new ArrayList<>();
    public static Pair startPos = new Pair(0, 0);
    public static Pair endPos = new Pair(0, 0);
    public static int elapsedTime = Integer.MAX_VALUE;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static Queue<Pair> bfsQ = new LinkedList<>();
    public static ArrayList<Pair> removedWalls = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        visited = new boolean[N][N];
        step = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    walls.add(new Pair(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        startPos.x = Integer.parseInt(st.nextToken())-1;
        startPos.y = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        endPos.x = Integer.parseInt(st.nextToken())-1;
        endPos.y = Integer.parseInt(st.nextToken())-1;

        removeWall(0, 0);
        System.out.println(elapsedTime == Integer.MAX_VALUE ? -1 : elapsedTime);
    }

    private static void removeWall(int idx, int cnt) {
        if (cnt > K) {
            return;
        }
        if (idx == walls.size()) {
            if (cnt == K) {
                int calc = calc();
                elapsedTime = Math.min(elapsedTime, calc);
            }
            return;
        }

        removedWalls.add(walls.get(idx));
        removeWall(idx + 1, cnt + 1);
        removedWalls.remove(removedWalls.size() - 1);
        removeWall(idx + 1, cnt);
    }

    private static int calc() {
        initVisited();
        initStep();
        for (int i = 0; i < removedWalls.size(); i++) {
            Pair removedWall = removedWalls.get(i);
            int x = removedWall.x;
            int y = removedWall.y;
            grid[x][y] = 0;

        }
        bfsQ.add(startPos);

        BFS();

        for (int i = 0; i < removedWalls.size(); i++) {
            Pair removedWall = removedWalls.get(i);
            int x = removedWall.x;
            int y = removedWall.y;
            grid[x][y] = 1;
        }

        if (!visited[endPos.x][endPos.y]) {
            return Integer.MAX_VALUE;
        }
        return step[endPos.x][endPos.y];
    }

    private static void initStep() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                step[i][j] = 0;
            }
        }
    }

    private static void BFS() {
        while (!bfsQ.isEmpty()) {
            Pair curr = bfsQ.poll();
            int cx = curr.x;
            int cy = curr.y;
            for (int dir = 0; dir < DIR_NUM; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if (canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    bfsQ.add(new Pair(nx, ny));
                    step[nx][ny] = step[cx][cy] + 1;
                }
            }
        }
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
}
