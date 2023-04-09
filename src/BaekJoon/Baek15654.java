package BaekJoon;
// N과 M (5)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek15654 {
    public static int n, m;
    public static boolean[] visit = new boolean[10001];
    public static int[] nums;
    public static ArrayList<Integer> combi = new ArrayList<>();
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
        Arrays.sort(nums);
        combination(0);
    }

    private static void combination(int cnt) {
        if (cnt == m) {
            StringBuffer sb = new StringBuffer();
            for (Integer num : combi) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[nums[i]]) {
                combi.add(nums[i]);
                visit[nums[i]] = true;
                combination(cnt + 1);
                combi.remove(combi.size() - 1);
                visit[nums[i]] = false;

            }
        }
    }
}
