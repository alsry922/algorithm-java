package DP1.조건에_맞게_선택적으로_전진하는_DP;

import java.io.*;
import java.util.*;

public class Exercise1 {
  static int n;
  static int[] seq;
  static int[] dp;

  public static void dpInit() {
    for (int i = 1; i < n+1; i++) {
      dp[i] = Integer.MIN_VALUE;
    }
    /*seq[0]=0 은 0번째 수는 말이 안 되지만 j번째 원소가 끝이자 마지막인 1개로 이루어진 수열인 경우를 맞춰줘야 하기 때문이다.
    * 밑에 이중 반복문에서 j를 살펴보면 알 수 있음.
    * dp[0]=0 은 애초에 0번째 수가 없으니 0번째 수를 마지막으로 하는 최장 부분 증가 수열의 길이는 0이다.*/
    dp[0] = 0;
    seq[0] = 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    seq = new int[n+1];
    dp = new int[n+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i < n+1; i++) {
      seq[i] = Integer.parseInt(st.nextToken());
    }
    /*dp[i] = i번째 수가 마지막일 때 최장 증가 부분 수열의 길이
    * 선택한 부분 수열에서 마지막 원소의 위치가 같다면, 이 부분 수열의 길이가 길수록 더 좋다.
    * i번째 수가 j번째 수보다 크면 j번째 수를 끝으로 하는 증가 부분 수열보다
    * +1 만큼 긴 i번째 수를 끝으로 하는 부분 증가 수열을 만들 수 있음*/
    dpInit();
    for (int i = 1; i < n+1; i++) {
      for (int j = 0; j < i; j++) {
        if (seq[i] > seq[j]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
        }
      }
    }
    int answer = 0;
    for (int i = 1; i < n+1; i++) {
      answer = Math.max(answer, dp[i]);
    }
    System.out.println(answer);
  }
}
