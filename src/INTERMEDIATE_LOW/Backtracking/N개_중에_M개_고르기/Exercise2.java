package INTERMEDIATE_LOW.Backtracking.N개_중에_M개_고르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// xor 결과 최대 만들기
public class Exercise2 {
    public static int N, M; // 숫자 갯수, 뽑을 갯수
    public static int[] nums;
    public static List<Integer> pick = new ArrayList<>();
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        simulation(N, M);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void simulation(int N, int M) {
        findCombination(0, 0);
    }

    public static void findCombination(int n, int m) {
        if (n == N) {
            if (m == M) {
                int result = 0;
                for (int num : pick) {
                    result ^= num;
                }
                answer = Math.max(answer, result);
            }
            return;
        }

        pick.add(nums[n]);
        findCombination(n + 1, m + 1);
        pick.remove(pick.size() - 1);
        findCombination(n + 1, m);
    }
}
