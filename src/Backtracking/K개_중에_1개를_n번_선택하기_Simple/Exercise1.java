package Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exercise1 {
  public static int K; //뽑을 수의 범위
  public static int N; //완성되는 수의 자릿수
  public static ArrayList<Integer> answer = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    choose(1);

  }

  public static void choose(int currPos) {
    if (currPos == N+1) {
      printAnswer();
      return;
    }

    for (int i = 1; i <= K; i++) {
      answer.add(i);
      choose(currPos + 1);
      answer.remove(answer.size() - 1);
    }
  }

  public static void printAnswer() {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < answer.size(); i++) {
      sb.append(answer.get(i)).append(" ");
    }
    System.out.println(sb);
  }
}
