package Backtracking.순열만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise2 {
  static final int MAX_N = 8;    // 1~n 까지의 수
  static int n;
  static boolean[] picked = new boolean[MAX_N+1];    // pick 정보
  static ArrayList<Integer> answer = new ArrayList<>();    // 뽑은 수 들
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    /*1~n 까지의 수 중 뽑은 수를 제외하고 현재 위치에서 뽑을 수 있는 수를 뽑는 함수
    * 현재 위치를 매개변수로 전달 받는다.*/
    choose(0);
    System.out.println(sb);
  }
  public static void choose(int pos) {
    /*뽑는 횟수만큼 뽑았으면 뽑힌 수들 저장*/
    if (pos == n) {
      saveAnswer();
      return;
    }

    for (int i = n; i > 0; i--) {
      if (picked[i]) continue;

      picked[i] = true;
      answer.add(i);

      choose(pos+1);

      picked[i] = false;
      answer.remove(answer.size()-1);
    }
  }
  public static void saveAnswer() {
    for (Integer i : answer) {
      sb.append(i).append(" ");
    }
    sb.append("\n");
  }
}
