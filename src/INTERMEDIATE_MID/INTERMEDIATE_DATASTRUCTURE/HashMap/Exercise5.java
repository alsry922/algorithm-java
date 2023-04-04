package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashMap;
// 두 수의 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise5 {
    public static int n, k; // 정수 갯수, 두 수의 합
    public static long[] nums;
    public static Map<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new long[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int inputVal = Integer.parseInt(st.nextToken());
            nums[i] = inputVal;
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            long diff = k - nums[i];

            if (map.containsKey(diff)) {
                answer += map.get(diff);
            }

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        System.out.println(answer);
    }
}
