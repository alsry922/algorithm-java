package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashMap;
// 세 수의 합
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise6 {
    public static int n, k; //정수 갯수, 세 수의 합
    public static int[] nums;
    public static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int inputVal = Integer.parseInt(st.nextToken());
            nums[i] = inputVal;
            if (!map.containsKey(inputVal)) {
                map.put(inputVal, 1);
            } else {
                map.put(inputVal, map.get(inputVal) + 1);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], -1);
            } else {
                map.put(nums[i], map.get(nums[i]) - 1);
            }
            for (int j = 0; j < i; j++) {
                int target = k - nums[i] - nums[j];
                if (map.containsKey(target)) {
                    answer += map.get(target);
                }
            }
        }

        System.out.println(answer);

    }
}
