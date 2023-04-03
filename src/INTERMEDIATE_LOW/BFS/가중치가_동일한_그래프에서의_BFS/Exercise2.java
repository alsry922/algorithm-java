package INTERMEDIATE_LOW.BFS.가중치가_동일한_그래프에서의_BFS;
// 나이트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public static int n; // grid size
    public static boolean[][] visited;
    public static int[] x = new int[2];
    public static int[] y = new int[2];
    public static int[][] step;
    public static Queue<Vertex> bfsQ = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1][n + 1];
        step = new int[n + 1][n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Vertex startV = new Vertex(x[0], y[0]);
        Vertex endV = new Vertex(x[1], y[1]);

        visited[startV.x][startV.y] = true;
        bfsQ.add(startV);
        bfs();

        System.out.println(visited[endV.x][endV.y] ? step[endV.x][endV.y] : -1);

    }

    public static void bfs() {
        int[] dx = {-2, -2, -1, -1,  1, 1,  2, 2};
        int[] dy = {-1,  1, -2,  2, -2, 2, -1, 1};

        while (!bfsQ.isEmpty()) {
            Vertex currV = bfsQ.poll();

            int currX = currV.x;
            int currY = currV.y;

            for (int i = 0; i < 8; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];
                if (canGo(nextX, nextY)) {
                    visited[nextX][nextY] = true;
                    step[nextX][nextY] = step[currX][currY] + 1;
                    bfsQ.add(new Vertex(nextX, nextY));
                }
            }
        }

    }

    public static boolean canGo(int x, int y) {
        return isInRange(x, y) && !visited[x][y];
    }

    private static boolean isInRange(int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }
}