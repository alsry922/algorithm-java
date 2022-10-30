package BaekJoon;

import java.io.*;
import java.util.*;
class Vertex {
  int x;
  int y;
  Vertex(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
public class Baek1012 {
  static int m; // 행
  static int n; // 열
  static int cabbageCnt; // 배추 갯수
  static int[][] grid; // 배추 밭
  static boolean[][] visited; // 방문 정보
  static Queue<Vertex> queue = new LinkedList<>(); // bfs에 사용할 큐
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine()); //    테스트 케이스
    StringTokenizer st;
    while(t > 0) {
      st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      cabbageCnt = Integer.parseInt(st.nextToken());
      grid = new int[m][n];
      visited = new boolean[m][n];

      /*배추 밭 초기화*/
      for (int i = 0; i < cabbageCnt; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        grid[x][y] = 1;
      }
      bfs(m,n);

      t--; // 테스트 케이스 하나 줄어듬
    }
  }
  /*
  * m * n 배추 밭 탐색하면서 bfs를 진행하고 필요한 배추흰지렁이의 갯수를 파악하는 함수
  * @param int m: 배추 밭의 행
  * @param int n; 배투 밭의 열
  * */
  public static void bfs(int m, int n) {
    int answer = 0; // 배추흰지렁이 마리 수
    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
          /*배추가 심어져 있고 방문한 적이 없는 경우 bfs 진행. bfs가 끝나는 경우
          인접한 지역의 배추를 다 탐색한 경우이므로 answer를 하나 올림*/
        if(grid[x][y] == 1 && !visited[x][y]) {
          visited[x][y] = true;
          queue.add(new Vertex(x,y));

          while (!queue.isEmpty()) {
            Vertex currVtx = queue.poll();
            int[] dx = new int[] {-1, 1, 0, 0};
            int[] dy = new int[] {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
              int nextX = currVtx.x + dx[i]; // 다음 x좌표
              int nextY = currVtx.y + dy[i]; // 다음 y좌표
              if (canGo(nextX, nextY)) {
                visited[nextX][nextY] = true;
                queue.add(new Vertex(nextX, nextY));
              }
            }
          }
          answer++;
        }
      }
    }
    System.out.println(answer);
  }
  /*
  * x, y 로 갈 수 있는지 여부를 판단하는 함수
  * @param int x: 배추 밭의 x 좌표(행)
  * @param int y: 배추 밭의 y 좌표(열)
  * @return boolean: 갈 수 있는 경우 true 아닌 경우 false*/
  public static boolean canGo(int x, int y) {
    return isInRange(x, y) && grid[x][y] == 1 && !visited[x][y];
  }
  /*
  * x, y가 배추 밭의 범위 안에 있는지 여부를 판단하는 함수
  * @param int x: 배추 밭의 x 좌표(행)
  * @param int y: 배추 밭의 y 좌표(열)
  * @return boolean: 범위 안에 있는 경우 true 아닌 경우 false*/
  public static boolean isInRange(int x, int y) {
    return 0 <= x && x < m && 0 <= y && y < n;
  }
}
