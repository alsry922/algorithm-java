package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//앞에서부터 삭제하기 2
public class Exercise7 {
    public static int N; // 수의 갯수
    public static int[] nums;
    public static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int input = Integer.parseInt(st.nextToken());
            nums[i] = input;
        }

        minHeap.add(nums[N]);
        int sum = nums[N];
        double max = Double.MIN_VALUE;
        for (int i = N-1; i >= 2; i--) {
            minHeap.add(nums[i]);
            sum += nums[i];
            int min = minHeap.peek();
            double average = 1.0 * (sum - min) / (N - i);
            max = Math.max(max, average);
        }
        System.out.printf("%.2f", max);
    }
}
