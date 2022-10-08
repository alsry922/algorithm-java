package BaekJoon;

import java.io.*;
import java.util.*;
// 10866 덱
public class Baek10866 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder answer = new StringBuilder();
    StringTokenizer st;
    Deque<Integer> deque = new LinkedList<>();    // 수를 담을 덱
    int N = Integer.parseInt(br.readLine());    // 입력 횟수

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      /*명령어 별로 처리*/
      while (st.hasMoreTokens()) {
        String command = st.nextToken();
        if (command.startsWith("push_front")) {
          deque.addFirst(Integer.parseInt(st.nextToken()));
        } else if (command.startsWith("push_back")) {
          deque.addLast(Integer.parseInt(st.nextToken()));
        } else if (command.startsWith("pop_front")) {
          if (deque.isEmpty()) {
            answer.append(-1).append("\n");
          } else {
            answer.append(deque.removeFirst()).append("\n");
          }
        } else if (command.startsWith("pop_back")) {
          if (deque.isEmpty()) {
            answer.append(-1).append("\n");
          } else {
            answer.append(deque.removeLast()).append("\n");
          }
        } else if (command.startsWith("size")) {
          answer.append(deque.size()).append("\n");
        } else if (command.startsWith("empty")) {
          if (deque.isEmpty()) {
            answer.append(1).append("\n");
          } else {
            answer.append(0).append("\n");
          }
        } else if (command.startsWith("front")) {
          if (deque.isEmpty()) {
            answer.append(-1).append("\n");
          } else {
            answer.append(deque.getFirst()).append("\n");
          }
        } else if (command.startsWith("back")) {
          if (deque.isEmpty()) {
            answer.append(-1).append("\n");
          } else {
            answer.append(deque.getLast()).append("\n");
          }
        }
      }
    }
    System.out.println(answer);
  }
}
