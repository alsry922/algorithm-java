package INTERMEDIATE_LOW.BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//K번 최댓값으로 이동하기
public class Exercise3 {
    static class Vertex {
        int val;
        int x, y;

        public Vertex(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        public boolean equals(Vertex nv) {
            return this.val == nv.val &&
                    this.x == nv.x &&
                    this.y == nv.y;
        }
    }

    public static int N, K; //격자 크기, 반복 횟수
    public static int[][] grid;
    public static boolean[][] visited;
    public static Queue<Vertex> bfsQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //격자 초기화
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        Vertex startV = new Vertex(grid[startX][startY], startX, startY);
        Vertex nextMaxV = new Vertex(-1, 101, 101);

        bfsQ.add(startV);
        visited[startX][startY] = true;

        while (K-- > 0) {
            while (!bfsQ.isEmpty()) {
                Vertex currV = bfsQ.poll();
                int x = currV.x;
                int y = currV.y;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (canGo(nx, ny, startX, startY)) {
                        visited[nx][ny] = true;
                        if (nextMaxV.val < grid[nx][ny]) {
                            nextMaxV = new Vertex(grid[nx][ny], nx, ny);
                        } else if (nextMaxV.val == grid[nx][ny]) {
                            if (nextMaxV.x > nx) {
                                nextMaxV = new Vertex(grid[nx][ny], nx, ny);
                            } else if (nextMaxV.x == nx && nextMaxV.y > ny) {
                                nextMaxV = new Vertex(grid[nx][ny], nx, ny);
                            }
                        }
                        bfsQ.add(new Vertex(grid[nx][ny], nx, ny));
                    }
                }
            }
            if (nextMaxV.val == -1) {
                break;
            }
            initVisited();
            startV = new Vertex(nextMaxV.val, nextMaxV.x, nextMaxV.y);
            startX = startV.x;
            startY = startV.y;
            nextMaxV = new Vertex(-1, 101, 101);
            visited[startV.x][startV.y] = true;
            bfsQ.add(startV);
        }
        System.out.println(startV.x + " " + startV.y);
    }

    private static void initVisited() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                visited[i][j] = false;
            }
        }
    }

    private static boolean canGo(int nx, int ny, int startX, int startY) {
        if (!isInRange(nx, ny)) {
            return false;
        }

        if (visited[nx][ny] || grid[nx][ny] >= grid[startX][startY]) {
            return false;
        }

        return true;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= N;
    }
}
