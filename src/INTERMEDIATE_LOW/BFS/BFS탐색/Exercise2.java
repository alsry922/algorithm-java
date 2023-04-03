package INTERMEDIATE_LOW.BFS.BFS탐색;
// 갈 수 있는 곳들

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Vertex {
    int x, y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Exercise2 {
    public static int n, k; //grid size, start vertex count
    public static int[][] grid;
    public static boolean[][] visited;
    public static ArrayList<Vertex> startVertex = new ArrayList<>();
    public static Queue<Vertex> queue = new LinkedList<>();
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];



        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            startVertex.add(new Vertex(start, end));
        }

        for (int i = 0; i < k; i++) {
            bfs(startVertex.get(i));
        }

        System.out.println(answer);

    }

    public static void bfs(Vertex startV) {
        if (visited[startV.x][startV.y]) {
            return;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[startV.x][startV.y] = true;
        answer++;
        queue.add(startV);

        while (!queue.isEmpty()) {
            Vertex currV = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = currV.x + dx[i];
                int nextY = currV.y + dy[i];
                if (canGO(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    answer++;
                    queue.add(new Vertex(nextX, nextY));
                }
            }
        }
    }

    private static boolean canGO(int x, int y) {
        return isInRange(x, y) && !visited[x][y] && grid[x][y] == 0;
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }
}

