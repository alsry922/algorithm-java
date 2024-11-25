package INTERMEDIATE_LOW.Backtracking.K개_중에_1개를_n번_선택하기_Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//K개 중에 1개를 n번 뽑기
public class Exercise1 {
    public static int k, n;
    public static List<Integer> combination = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        k = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        choose(n);
    }

    public static void choose(int n) {
        if (n == 0) {
            StringBuilder sb = new StringBuilder();
            combination.forEach(ele -> sb.append(ele).append(" "));
            System.out.println(sb);
            return;
        }
        for (int i = 1; i <= k; i++) {
            combination.add(i);
            choose(n - 1);
            combination.remove(combination.size() - 1);
        }
    }
}
