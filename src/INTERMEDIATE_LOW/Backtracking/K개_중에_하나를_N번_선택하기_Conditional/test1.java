package INTERMEDIATE_LOW.Backtracking.K개_중에_하나를_N번_선택하기_Conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최소 점프 횟수
public class test1 {
    public static int N;
    public static int[] nums;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        answer = N;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        findMinJump(0, 0);
        System.out.println(answer == N ? -1 : answer);
    }

    private static void findMinJump(int idx, int cnt) {
        if (idx >= N - 1) {
            answer = Math.min(answer, cnt);
            return;
        }
        if (cnt == N) {
            if (idx >= N - 1) {
                answer = Math.min(answer, cnt);
            }
            return;
        }

        for (int i = nums[idx]; i >= 0; i--) {
            findMinJump(idx+i, cnt+1);
        }
    }
}
