package INTERMEDIATE_LOW.Backtracking.순열만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//크기가 n인 순열
public class Exercise1 {
    public static int N; //가능한 수 범위
    public static boolean[] selected;
    public static ArrayList<Integer> permutation = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        selected = new boolean[N + 1];
        findPermutation(1);
    }

    private static void findPermutation(int currDigit) {
        if (currDigit == N + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < permutation.size(); i++) {
                sb.append(permutation.get(i)).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                permutation.add(i);
                findPermutation(currDigit + 1);
                selected[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
