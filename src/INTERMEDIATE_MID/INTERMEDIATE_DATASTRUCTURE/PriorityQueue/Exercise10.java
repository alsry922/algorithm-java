package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//배열 추출 2
public class Exercise10 {
    static class Pair implements Comparable<Pair>{
        int abs, origin;

        public Pair(int abs, int origin) {
            this.abs = abs;
            this.origin = origin;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.abs == pair.abs) {
                return this.origin - pair.origin;
            }
            return this.abs - pair.abs;
        }
    }
    public static int N; // 연산의 갯수
    public static PriorityQueue<Pair> pairs = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pairs.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pairs.poll().origin);
                }
            } else {
                pairs.add(new Pair(Math.abs(input), input));
            }
        }
    }
}
