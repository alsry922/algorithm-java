package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//k번째로 작은 쌍의 합
public class Exercise9 {
    static class Pair implements Comparable<Pair> {
        int sum, aIdx, bIdx;

        public Pair(int aIdx, int bIdx, int sum) {
            this.sum = sum;
            this.aIdx = aIdx;
            this.bIdx = bIdx;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.sum != pair.sum) {
                return this.sum - pair.sum;
            } else if (this.aIdx != pair.aIdx) {
                return this.aIdx - pair.aIdx;
            } else {
                return this.bIdx - pair.bIdx;
            }
        }
    }

    public static int N, M, K; //수열1의 갯수, 수열2의 갯수, k번째 쌍
    public static int[] seqA;
    public static int[] seqB;
    public static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        seqA = new int[N];
        seqB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seqA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            seqB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(seqA);
        Arrays.sort(seqB);
        findMinPair();
    }

    private static void findMinPair() {
        for (int i = 0; i < N; i++) {
            pq.add(new Pair(i, 0, seqA[i] + seqB[0]));
        }

        while (K-- > 1) {
            Pair currMin = pq.poll();
            int aIdx = currMin.aIdx;
            int bIdx = currMin.bIdx;

            bIdx++;
            if (bIdx < M) {
                pq.add(new Pair(aIdx, bIdx, seqA[aIdx] + seqB[bIdx]));
            }
        }
        System.out.println(pq.peek().sum);
    }
}
