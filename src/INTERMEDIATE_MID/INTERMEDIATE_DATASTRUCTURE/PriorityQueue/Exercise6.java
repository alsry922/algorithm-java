package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//마지막으로 남은 숫자
public class Exercise6 {
    public static int N; // 수의 갯수
    public static int[] nums;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            nums[i] = input;
            pq.add(-nums[i]);
        }

        while (pq.size() >= 2) {
            int larger = -pq.poll();
            int smaller = -pq.poll();
            int diff = larger - smaller;
            if (diff != 0) {
                pq.add(-diff);
            }
        }
        System.out.println(pq.isEmpty() ? -1 : -pq.peek());
    }
}
