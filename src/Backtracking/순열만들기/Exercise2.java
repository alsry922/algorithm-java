package Backtracking.순열만들기;
// 거꾸로 순열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Exercise2 {
    public static int n;
    public static boolean[] visited;
    public static ArrayList<Integer> permutation = new ArrayList<>();
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        choose(0);
        System.out.println(sb);
    }

    private static void choose(int currPos) {
        if (currPos >= n) {
            print();
        }

        for (int i = n; i >= 1; i--) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(i);
                choose(currPos + 1);
                visited[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    private static void print() {
        for (int i = 0; i < permutation.size(); i++) {
            sb.append(permutation.get(i)).append(" ");
        }
        sb.append("\n");
    }
}