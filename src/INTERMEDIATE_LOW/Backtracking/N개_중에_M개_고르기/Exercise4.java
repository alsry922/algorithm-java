package INTERMEDIATE_LOW.Backtracking.N개_중에_M개_고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2n개 중에 n개의 숫자를 적절하게 고르기
public class Exercise4 {
    public static int N;
    public static int[] nums;
    public static boolean[] select;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[2*N];
        select = new boolean[2 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        findMinSubtract(0, 0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void findMinSubtract(int idx, int cnt, int sum) {
        if (cnt == N) {
            int bSum = 0;
            for (int i = 0; i < 2*N; i++) {
                if (!select[i]) {
                    bSum += nums[i];
                }
            }
            int result = Math.abs(sum - bSum);
            answer = Math.min(answer, result);
            return;
        }
        if (idx == 2 * N) {
            return;
        }

        select[idx] = true;
        findMinSubtract(idx + 1, cnt + 1, sum + nums[idx]);
        select[idx] = false;
        findMinSubtract(idx + 1, cnt, sum);
    }
}
