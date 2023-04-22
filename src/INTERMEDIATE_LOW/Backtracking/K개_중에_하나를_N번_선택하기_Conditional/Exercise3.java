package INTERMEDIATE_LOW.Backtracking.K개_중에_하나를_N번_선택하기_Conditional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//가능한 수열 중 최솟값 구하기
public class Exercise3 {
    public static int N; //수열 길이
    public static int[] nums = {4, 5, 6};
    public static ArrayList<Integer> seq = new ArrayList<>();
    public static boolean findAnswer = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        findMinSeq(0);
    }

    private static void findMinSeq(int cnt) {
        if (findAnswer) {
            return;
        }

        if (cnt == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < seq.size(); i++) {
                sb.append(seq.get(i));
            }
            System.out.println(sb);
            findAnswer = true;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            seq.add(nums[i]);
            if (possible()) {
                findMinSeq(cnt+1);
            }
            seq.remove(seq.size() - 1);
        }
    }

    private static boolean possible() {
        int len = 1;
        while (true) {
            int end1 = seq.size() - 1, start1 = end1 - len + 1;
            int end2 = start1 - 1, start2 = end2 - len + 1;

            if (start2 < 0) {
                break;
            }

            if (isEqual(start1, end1, start2, end2, len)) {
                return false;
            }
            len++;
        }
        return true;
    }

    private static boolean isEqual(int start1, int end1, int start2, int end2, int len) {
        for (int i = 0; i < len; i++) {
            if (seq.get(start1 + i) != seq.get(start2 + i)) {
                return false;
            }
        }
        return true;
    }
}
