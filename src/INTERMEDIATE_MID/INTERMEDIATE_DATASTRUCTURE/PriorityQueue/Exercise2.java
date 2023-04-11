package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 큰 숫자만 계속 고르기
public class Exercise2 {
    public static int N, M; //수 갯수, 작업 횟수
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(-Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            if (!pq.isEmpty()) {
                int max = pq.poll();
                pq.add(max + 1);
            }
        }

        System.out.println(-pq.peek());
    }
}
