package INTERMEDIATE_LOW.Backtracking.N개_중에_M개_고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//단순한 동전 챙기기
public class Exercise3 {
    static class Tuple implements Comparable<Tuple> {
        int num;
        int x, y;

        public Tuple(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Tuple tuple) {
            return this.num - tuple.num;
        }
    }

    public static int N; //격자 크기
    public static int MIN_CNT = 3;
    public static ArrayList<Tuple> nums = new ArrayList<>();
    public static Tuple start;
    public static Tuple end;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = input.charAt(j);
                if (ch == '.') {
                    continue;
                }
                if (ch == 'S') {
                    start = new Tuple(0, i, j);
                } else if (ch == 'E') {
                    end = new Tuple(0, i, j);
                } else {
                    nums.add(new Tuple(ch - '0', i, j));
                }

            }
        }
        Collections.sort(nums);

        findMinDist(start, 0, 0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void findMinDist(Tuple curr, int idx, int cnt, int dist) {
        if (idx == nums.size()) {
            if (cnt >= MIN_CNT) {
                dist = dist + Math.abs(curr.x - end.x) + Math.abs(curr.y - end.y);
                answer = Math.min(answer, dist);
            }
            return;
        }

        Tuple nt = nums.get(idx);
        findMinDist(nt, idx + 1, cnt + 1, dist + Math.abs(curr.x - nt.x) + Math.abs(curr.y - nt.y));
        findMinDist(curr, idx + 1, cnt, dist);
    }
}