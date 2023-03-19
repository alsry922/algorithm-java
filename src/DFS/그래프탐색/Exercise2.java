package DFS.그래프탐색;

import java.util.*;
import java.io.*;

public class Exercise2 {
  public static int N, M; //행, 열
  public static int[][] grid;
  public static boolean[][] visited;
  public static int[] dx = {1, 0};
  public static int[] dy = {0, 1};
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
    escape(1, 1);
    System.out.println(visited[N][M] ? 1 : 0);
  }

  private static void escape(int x, int y) {
    for (int i = 0; i < 2; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];
      if (canGo(nextX, nextY)) {
        visited[nextX][nextY] = true;
        escape(nextX, nextY);
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
