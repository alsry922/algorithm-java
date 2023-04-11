package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 정수 명령 처리 6
public class Exercise1 {
    public static int N; // 명령 수
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int input = Integer.parseInt(st.nextToken());
                pq.add(-input);
            } else {
                if (command.equals("pop")) {
                    System.out.println(-pq.poll());
                }
                if (command.equals("top")) {
                    System.out.println(-pq.peek());
                }
                if (command.equals("empty")) {
                    System.out.println(pq.isEmpty() ? 1 : 0);
                }
                if (command.equals("size")) {
                    System.out.println(pq.size());
                }
            }
        }
    }
}
