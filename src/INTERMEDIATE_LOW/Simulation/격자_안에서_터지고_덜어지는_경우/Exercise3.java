package INTERMEDIATE_LOW.Simulation.격자_안에서_터지고_덜어지는_경우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1차원 폭발 게임
public class Exercise3 {
    public static int N, M, endOfBombs; //폭탄 갯수, 반복 수, 폭탄 마지막 인덱스
    public static int[] bombs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bombs = new int[N];
        for (int i = 0; i < N; i++) {
            bombs[i] = Integer.parseInt(br.readLine());
        }
        endOfBombs = N - 1;
        boolean didExplode;
        int currIdx;
        do {
            didExplode = false;
            currIdx = 0;
            while (currIdx <= endOfBombs) {
                int endIdx = getEndIdxOfExplosion(currIdx, bombs[currIdx]);
                if (endIdx - currIdx + 1 >= M) {
                    cutArray(currIdx, endIdx);
                    didExplode = true;
                } else {
                    currIdx = endIdx + 1;
                }
            }
        } while (didExplode);
        System.out.println(endOfBombs + 1);
        for (int i = 0; i <= endOfBombs; i++) {
            System.out.println(bombs[i]);
        }
    }

    private static void cutArray(int currIdx, int endIdx) {
        int cutLength = endIdx - currIdx + 1;
        for (int i = endIdx + 1; i <= endOfBombs; i++) {
            bombs[currIdx++] = bombs[i];
        }
        endOfBombs -= cutLength;
    }

    private static int getEndIdxOfExplosion(int currIdx, int bomb) {
        int endIdx = currIdx + 1;
        while (endIdx <= endOfBombs) {
            if (bombs[endIdx] == bomb) {
                endIdx += 1;
            } else {
                break;
            }
        }
        return endIdx - 1;
    }
}
