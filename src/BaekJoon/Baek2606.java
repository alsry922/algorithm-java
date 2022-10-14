package BaekJoon;
// 2606 바이러스
import java.util.*;
import java.io.*;

public class Baek2606 {
  static final int MAX_COMPUTER = 100;    // 최대 컴퓨터 갯수
  static int computer;
  static int edges;
  static ArrayList<Integer>[] graph = new ArrayList[MAX_COMPUTER+1];    // 인접리스트
  static boolean[] visited = new boolean[MAX_COMPUTER+1];    // 방문 정점 표시
  static Queue<Integer> queue = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    computer = Integer.parseInt(br.readLine());
    for (int i = 1; i <= computer; i++) {
      graph[i] = new ArrayList<>();
    }
    /*인접리스트 초기화*/
    edges = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int i = 0; i < edges; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph[start].add(end);
      graph[end].add(start);
    }
    /*1번 컴퓨터 방문 시작으로 bfs 탐색 시작*/
    visited[1] = true;
    queue.add(1);
    int answer = 0;
    while(!queue.isEmpty()) {
      int currVtx = queue.poll();
      /*현재 정점과 인접한 정점을 모두 탐색*/
      for (int i = 0; i < graph[currVtx].size(); i++) {
        int nextVtx = graph[currVtx].get(i);
        if (!visited[nextVtx]) {
          visited[nextVtx] = true;
          queue.add(nextVtx);
          answer++;
        }
      }
    }
    System.out.println(answer);
  }
}
