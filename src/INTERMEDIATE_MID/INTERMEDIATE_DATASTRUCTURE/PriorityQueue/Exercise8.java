package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//중앙값
public class Exercise8 {
    public static int T; //테스트 케이스 갯수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int m = Integer.parseInt(br.readLine()); // 수열의 원소 갯수
            int[] seq = new int[m+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= m; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
            }
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            PriorityQueue<Integer> maxPq = new PriorityQueue<>((x1, x2) -> x2 - x1);

            StringBuilder sb = new StringBuilder();
            int median = seq[1];
            sb.append(seq[1]).append(" ");
            for (int i = 2; i <= m; i++) {
                if (i % 2 == 1) {
                    int newCand;
                    if (maxPq.size() > minPq.size()) {
                        newCand = maxPq.poll();
                    }
                    else {
                        newCand = minPq.poll();
                    }
                    int[] nums = new int[]{seq[i], median, newCand};
                    Arrays.sort(nums);
                    maxPq.add(nums[0]);
                    median = nums[1];
                    minPq.add(nums[2]);
                    sb.append(median).append(" ");
                }
                else {
                    if (seq[i] > median) {
                        minPq.add(seq[i]);
                    }
                    else {
                        maxPq.add(seq[i]);
                    }
                }
            }
            System.out.println(sb);
        }
    }
}
