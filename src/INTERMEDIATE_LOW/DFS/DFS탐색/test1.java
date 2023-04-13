package INTERMEDIATE_LOW.DFS.DFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//뿌요뿌요
public class test1 {
    public static int N; //격자 크기
    public static int[][] grid;
    public static boolean[][] visited;
    public static int blockSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxBlockSize = 0;
        int bombBlock = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    blockSize = 1;
                    dfs(i, j);
                    if (blockSize >= 4) {
                        bombBlock++;
                    }
                    maxBlockSize = Math.max(maxBlockSize, blockSize);
                }
            }
        }

        System.out.println(bombBlock + " " + maxBlockSize);
    }

    private static void dfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (canGo(x, y, nx, ny)) {
                visited[nx][ny] = true;
                blockSize++;
                dfs(nx, ny);
            }
        }
    }

    private static boolean canGo(int x, int y, int nx, int ny) {
        if (!isInRange(nx, ny)) {
            return false;
        }

        if (grid[x][y] != grid[nx][ny] || visited[nx][ny]) {
            return false;
        }

        return true;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
