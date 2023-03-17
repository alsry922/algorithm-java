package Backtracking.순열만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise1 {
    public static int N;
    public static ArrayList<Integer> permutation = new ArrayList<>();
    public static boolean[] visited;
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        makePermutaion(1);
        System.out.println(sb);
    }

    public static void makePermutaion(int digit) {
        if (digit == N + 1) {
            printPermutaion();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }

            permutation.add(i);
            visited[i] = true;
            makePermutaion(digit + 1);
            permutation.remove(permutation.size() - 1);
            visited[i] = false;
        }
    }

    private static void printPermutaion() {
        for (Integer num : permutation) {
            sb.append(num).append(" ");
        }
        sb.append("\n");
    }


}
