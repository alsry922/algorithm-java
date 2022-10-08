package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baek10845 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder answer = new StringBuilder();
    StringTokenizer st;
    ArrayList<Integer> list = new ArrayList<>();    // 수를 담을 리스트
    int N = Integer.parseInt(br.readLine());    // 입력 횟수

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      /*명령어 별로 처리*/
      while (st.hasMoreTokens()) {
        String command = st.nextToken();
        if (command.startsWith("push")) {
          list.add(Integer.parseInt(st.nextToken()));
        }
        else if (command.startsWith("pop")) {
          if (list.isEmpty()) {
            answer.append(-1).append("\n");
          }
          else {
            answer.append(list.remove(0)).append("\n");
          }
        }
        else if (command.startsWith("size")) {
          answer.append(list.size()).append("\n");
        }
        else if(command.startsWith("empty")) {
          if (list.isEmpty()) {
            answer.append(1).append("\n");
          }
          else {
            answer.append(0).append("\n");
          }
        }
        else if (command.startsWith("front")) {
          if (list.isEmpty()) {
            answer.append(-1).append("\n");
          } else {
            answer.append(list.get(0)).append("\n");
          }
        }
        else if (command.startsWith("back")) {
          if (list.isEmpty()) {
            answer.append(-1).append("\n");
          }
          else {
            answer.append(list.get(list.size()-1)).append("\n");
          }
        }
      }
    }
    System.out.println(answer);
  }
}
