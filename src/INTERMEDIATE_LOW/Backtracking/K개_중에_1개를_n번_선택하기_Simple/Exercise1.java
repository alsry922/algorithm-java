package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//K개 중에 1개를 n번 뽑기
public class Exercise1 {
    public static int K, N; //K이하의 숫자, 숫자 하나를 N번 반복 선택
    public static ArrayList<Integer> selected = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        choose(1);
        System.out.println(sb);
    }

    private static void choose(int digit) {
        if (digit == N + 1) {
            print();
            return;
        }

        for (int i = 1; i <= K; i++) {
            selected.add(i);
            choose(digit + 1);
            selected.remove(selected.size() - 1);
        }
    }

    private static void print() {
        for (Integer select : selected) {
            sb.append(select).append(" ");
        }
        sb.append("\n");
    }
}
