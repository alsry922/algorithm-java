package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
    public static int gridSize, happySeqSize;
    public static int[][] grid;
    public static int[] seq;

    public static void main(String[] args) throws IOException {
        //gridSize 입력받기, 반복되어야 하는 횟수 입력받기
        //grid 입력받기
        //현재 좌표 위치부터 반복되어야하는 횟수만큼의 위치까지 탐색 후 행복한 수열이면 카운트
        //현재 좌표 위치에서 반복되어야하는 횟수만큼의 위치까지 탐색이 불가능한 경우(size 범위 초과) 다음 행 혹은 열로 이동
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        gridSize = Integer.parseInt(st.nextToken());
        happySeqSize = Integer.parseInt(st.nextToken());

        grid = new int[gridSize][gridSize];
        seq = new int[gridSize];

        int answer = 0;

        for (int i = 0; i <= gridSize-1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= gridSize-1; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int row = 0; row <= gridSize-1; row++) {
            for (int col = 0; col <= gridSize-1; col++) {
                seq[col] = grid[row][col];
            }
            if (isHappySequence()) {
                answer++;
            }
        }

        for (int col = 0; col <= gridSize - 1; col++) {
            for (int row = 0; row <= gridSize-1; row++) {
                seq[row] = grid[row][col];
            }
            if (isHappySequence()) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isHappySequence() {
        int consecutiveCount = 1, maxConsecutiveCount = 1;
        //행복한 수열인지 판단
        //배열 비교시 뒤부터 보는게 편한 것 같다.
        for (int i = 1; i <= gridSize-1; i++) {
            if (seq[i-1] == seq[i]) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }
            maxConsecutiveCount = Math.max(consecutiveCount, maxConsecutiveCount);
        }
        return maxConsecutiveCount >= happySeqSize;
    }
}
