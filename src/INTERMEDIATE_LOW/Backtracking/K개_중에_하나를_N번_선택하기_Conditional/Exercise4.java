package INTERMEDIATE_LOW.Backtracking.K개_중에_하나를_N번_선택하기_Conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//방향에 맟춰 최대로 움직이기
public class Exercise4 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N; //격자 크기
    public static int[][] grid;
    public static int[][] direction;
    public static boolean[][] visited;
    public static int[] dx = {0, -1, -1, 0, 1, 1,  1,  0, -1};
    public static int[] dy = {0,  0,  1, 1, 1, 0, -1, -1, -1};
    public static int answer = 0;
    public static ArrayList<Pair> select = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        direction = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                direction[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        visited[startX][startY] = true;

        for (int i = 1; i <= N; i++) {
            int nx = startX + dx[direction[startX][startY]] * i;
            int ny = startY + dy[direction[startX][startY]] * i;
            if (canMove(nx, ny, grid[startX][startY])) {
                visited[nx][ny] = true;
                findMaxDist(new Pair(nx, ny));
                visited[nx][ny] = false;
            }
        }

        System.out.println(answer);
    }

    private static void findMaxDist(Pair pair) {
        int cx = pair.x;
        int cy = pair.y;
        boolean moved = false;
        for (int i = 1; i < N; i++) {
            int nx = cx + dx[direction[cx][cy]] * i;
            int ny = cy + dy[direction[cx][cy]] * i;
            if (canMove(nx, ny, grid[cx][cy])) {
                moved = true;
                visited[nx][ny] = true;
                findMaxDist(new Pair(nx, ny));
                visited[nx][ny] = false;
            }
        }
        if (!moved) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j])
                        cnt++;
                }
            }
            answer = Math.max(answer, cnt-1);
        }
    }

    private static boolean canMove(int nx, int ny, int curN) {
        return inRange(nx, ny) && grid[nx][ny] > curN && !visited[nx][ny];
    }

    private static boolean inRange(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
