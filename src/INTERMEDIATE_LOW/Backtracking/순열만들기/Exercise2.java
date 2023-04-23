package INTERMEDIATE_LOW.Backtracking.순열만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// 거꾸로 순열

public class Exercise2 {
    public static int N; //가능한 수의 범위
    public static boolean[] selected;
    public static ArrayList<Integer> permutation = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        selected = new boolean[N + 1];

        getPermutation(0);
    }

    private static void getPermutation(int cnt) {
        if (cnt == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < permutation.size(); i++) {
                sb.append(permutation.get(i)).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = N; i >= 1; i--) {
            if (!selected[i]) {
                selected[i] = true;
                permutation.add(i);
                getPermutation(cnt + 1);
                selected[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}