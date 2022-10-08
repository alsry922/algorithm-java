package BFS.BFS탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
  int x;
  int y;

  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class Exercise1 {
  static int m, n;    // 행, 열
  static int grid[][];    // 격자
  static boolean visited[][];    // 방문 체크
  static Queue<Pair> queue = new LinkedList<>();    // 방문한 노드를 담아두는 큐

  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    grid = new int[m][n];
    visited = new boolean[m][n];
    /*격자 초기화*/
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < n; j++) {
        grid[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    visited[0][0] = true;
    queue.add(new Pair(0, 0));
    bfs();
    System.out.println(visited[m - 1][n - 1] ? 1 : 0);
  }

  public static void bfs() {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    while (!queue.isEmpty()) {
      Pair curV = queue.poll();   // 현재 정점
      /*인접한 모든 정점 확인*/
      for (int i = 0; i < 4; i++) {
        int nextX = curV.x + dx[i];
        int nextY = curV.y + dy[i];
        if (canGo(nextX, nextY)) {
          visited[nextX][nextY] = true;
          queue.add(new Pair(nextX, nextY));
        }
      }
    }
  }

  public static boolean canGo(int nextX, int nextY) {
    return isRange(nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 1;
  }

  public static boolean isRange(int x, int y) {
    return 0 <= x && x < m && 0 <= y && y < n;
  }
}