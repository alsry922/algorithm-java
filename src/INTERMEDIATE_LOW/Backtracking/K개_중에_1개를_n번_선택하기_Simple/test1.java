package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//알파벳과 사칙연산
public class test1 {
    public static final int ALPHABET_CNT = 6;
    public static String exp;
    public static String[] splits;
    public static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f'};
    public static Map<Character, Integer> map = new HashMap<>();
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        exp = br.readLine();
        matchAlphabet(0);
        System.out.println(answer);
    }

    private static void matchAlphabet(int cnt) {
        if (cnt == ALPHABET_CNT) {
            answer = Math.max(answer, calc());
            return;
        }

        for (int i = 1; i <= 4; i++) {
            map.put(alphabet[cnt], i);
            matchAlphabet(cnt + 1);
            map.remove(alphabet[cnt]);
        }
    }

    private static int calc() {
        int result = map.get(exp.charAt(0));
        if (exp.length() > 1) {
            for (int i = 1; i < exp.length(); i += 2) {
                if (inRange(i + 1)) {
                    char command = exp.charAt(i);
                    int num = map.get(exp.charAt(i+1));
                    if (command == '+') {
                        result = result + num;
                    }
                    if (command == '-') {
                        result = result - num;
                    }
                    if (command == '*') {
                        result = result * num;
                    }
                }
            }
        }
        return result;
    }

    private static boolean inRange(int ni) {
        return ni < exp.length();
    }
}
