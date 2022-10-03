package Backtracking.순열만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise1 {
  static int n;    // 1~n까지의 수
  static int[] nums;
  static boolean[] visited;
  static ArrayList<Integer> answer = new ArrayList<>();
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    nums = new int[n];
    visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i+1;
    }
    choose(0);
    System.out.println(sb);
  }
  /*현재 위치에서 1~n 까지의 수 중 아직 선택되지 않은 수를 선택하는 함수*/
  public static void choose(int pos) {
    if (pos == n) {
      saveAnswer();
      return;
    }
    for (int i = 0; i < n; i++) {
      if (visited[i]) continue;

      visited[i] = true;
      answer.add(nums[i]);
      choose(pos+1);
      visited[i] = false;
      answer.remove(answer.size()-1);
    }
  }
  public static void saveAnswer() {
    for (Integer integer : answer) {
      sb.append(integer).append(" ");
    }
    sb.append("\n");
  }
}
