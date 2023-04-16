package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//곱셈
public class Baek1629 {
    public static long A,B,C; //밑, 지수, 나누는 수
    public static Map<Long, Long> remains = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        remains.put(0L, 1 % C);
        remains.put(1L, A % C);

        long answer = simulate(A, B, C);
        System.out.println(answer);
    }

    //a의 b제곱을 c로 나눈 나머지를 구한다.
    private static long simulate(long a, long b, long c) {
        if (b == 0) {
            return remains.get(0L);
        }
        if (b == 1) {
            return remains.get(1L);
        }
        if (remains.containsKey(b)) {
            return remains.get(b);
        }

        long remain;
        if (b % 2 == 0) {
            remain = (simulate(a, b / 2, c) * simulate(a, b / 2, c)) % c;
        } else {
            remain = (simulate(a, b / 2, c) * simulate(a, b / 2, c) % c) * remains.get(1L) % c;
        }
        remains.put(b, remain);
        return remains.get(b);
    }
}
