package DFS.그래프탐색;

import java.util.*;
import java.io.*;

class Pair {
  int x;
  int y;
  public Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Exercise2 {
  static final int MAX_N = 100, MAX_M = 100;
  static int n, m;
  static int[][] grid = new int[MAX_N][MAX_M];
  static boolean[][] visited = new boolean[MAX_N][MAX_M];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    /* grid 초기화 */
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    /* (0,0) 방문 표시하고 dfs 시작 */
    visited[0][0] = true;
    dfs(new Pair(0,0));
    System.out.println(visited[n-1][m-1] ? 1 : 0);
  }

  public static void dfs(Pair curVtx) {
    int[] dx = new int[] {1, 0};
    int[] dy = new int[] {0, 1};
    /* 갈 수 있는 정점을 탐색 */
    for (int i = 0; i < 2; i++) {
      int nextX = curVtx.x + dx[i];
      int nextY = curVtx.y + dy[i];
      /* 갈 수 있는 경우 방문 표시하고 다음 정점부터 dfs 진행 */
      if (canGo(nextX, nextY)) {
        visited[nextX][nextY] = true;
        dfs(new Pair(nextX, nextY));
      }
    }
  }

  public static boolean canGo(int x, int y) {
    return isInRange(x, y) && !visited[x][y] && grid[x][y] == 1;
  }

  public static boolean isInRange(int x, int y) {
    return 0 <= x && x < n && 0 <= y && y < m;
  }
}
