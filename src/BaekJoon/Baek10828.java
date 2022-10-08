package BaekJoon;

import java.io.*;
import java.util.*;
// 10828 스택
public class Baek10828 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder answer = new StringBuilder();
    StringTokenizer st;
    Stack<Integer> stack = new Stack<>();
    int N = Integer.parseInt(br.readLine());    // 입력 횟수

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      /*명령어 별로 처리*/
      while (st.hasMoreTokens()) {
        String command = st.nextToken();
        if (command.startsWith("push")) {
          stack.push(Integer.parseInt(st.nextToken()));
        }
        else if (command.startsWith("pop")) {
          if (stack.empty()) {
            answer.append(-1).append("\n");
          }
          else {
            answer.append(stack.pop()).append("\n");
          }
        }
        else if (command.startsWith("size")) {
          answer.append(stack.size()).append("\n");
        }
        else if(command.startsWith("empty")) {
          if (stack.empty()) {
            answer.append(1).append("\n");
          }
          else {
            answer.append(0).append("\n");
          }
        }
        else if (command.startsWith("top")) {
          if (stack.empty()) {
            answer.append(-1).append("\n");
          } else {
            answer.append(stack.peek()).append("\n");
          }
        }
      }
    }
    System.out.println(answer);
  }
}
