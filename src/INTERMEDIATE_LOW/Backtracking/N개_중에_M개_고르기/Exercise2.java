package INTERMEDIATE_LOW.Backtracking.N개_중에_M개_고르기;
// xor 결과 최대 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Exercise2 {
    public static int n, m; // 입력 갯수, 뽑을 갯수
    public static int answer = 0;
    public static int[] nums;
    public static ArrayList<Integer> selected = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        choose(1, 0);

        System.out.println(answer);
    }

    private static void choose(int currPos, int cnt) {
        if (currPos > n) {
            if (cnt == m) {
                answer = calculateAnswer();
            }
            return;
        }

        selected.add(nums[currPos]);
        choose(currPos + 1, cnt + 1);
        selected.remove(selected.size() - 1);
        choose(currPos + 1, cnt);
    }

    private static int calculateAnswer() {
        int result = 0;
        for (int i = 0; i < selected.size(); i++) {
            result ^= selected.get(i);
        }
        return Math.max(answer, result);
    }
}
