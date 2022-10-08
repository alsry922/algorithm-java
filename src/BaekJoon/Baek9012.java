package BaekJoon;

import java.io.*;
import java.util.*;
// 9012 스택
public class Baek9012 {
  static int T;    // 입력 횟수
  static String[] str;    // 괄호 문자열 배열
  static Stack<Character> stack = new Stack<>();
  static StringBuilder answer = new StringBuilder();
  /*
   * 괄호문자열 유효성 체크 결과에 따라 NO, 혹은 YES를 answer에 저장하는 함수
   * @parameter boolean isCheck: 괄호 유효성
   * */
  public static void saveAnswer(boolean isCheck) {
    if (isCheck) {
      answer.append("YES").append("\n");
    } else {
      answer.append("NO").append("\n");
    }
  }
  /*
   * 괄호 문자열을 순회하며 올바른 괄호 문자열인지 확인하는 함수
   * @parameter String parentheses: 괄호 문자열
   * @return boolean: 괄호 유효성이 체크되면 true를 아니면 false를 반환
   * */
  public static boolean isValid(String parentheses) {
    for (int i = 0; i < parentheses.length(); i++) {
      char parenthesis = parentheses.charAt(i);
      if (parenthesis == '(') {
        stack.push(parenthesis);
      } else {
        /*괄호 문자열을 다 돌지 않았는데 스택이 빈 경우 유효하지 않은 문자열*/
        if (stack.isEmpty()) {
          return false;
        }
        stack.pop();
      }
    }
    /* 괄호 문자열을 다 돌았는데 스택이 비었다면 유효한 문자열
     * 스택이 비어있지 않다면 유효하지 않은 문자열*/
    return stack.isEmpty();
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());
    str = new String[T];
    for (int i = 0; i < T; i++) {
      str[i] = br.readLine();
    }
    /*괄호 문자열들을 탐색하며 유효성 체크*/
    for (int i = 0; i < T; i++) {
      boolean isCheck = isValid(str[i]);
      saveAnswer(isCheck);
      /*하나의 괄호 문자열 탐색 후에는 스택 비우기*/
      stack.clear();
    }
    System.out.println(answer);
  }
}
