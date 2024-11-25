package INTERMEDIATE_LOW.Simulation.격자_안에서_단일_객체를_이동;

import java.io.*;
import java.util.*;

public class Exercise3 {
    public static int[][] grid;
    public static int rowSize;
    public static int colSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] gridSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        rowSize = gridSize[0];
        colSize = gridSize[1];
        grid = new int[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = 0;

        //사각형 범위에서 하나씩 뺀 값 중 최댓값을 구한다.
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (isInRange(i, j, i+1, j+1)) {
                    int[] seq = new int[4];
                    int index = 0;
                    for (int row = i; row <= i+1; row++) {
                        for (int col = j; col <= j+1; col++) {
                            seq[index] = grid[row][col];
                            index++;
                        }
                    }
                    int sum = Arrays.stream(seq).sum();
                    int max = Arrays.stream(seq).map(value -> sum-value).max().orElse(0);
                    answer = Math.max(answer, max);
                }
            }
        }

        //가로 직사각형 범위에서 최댓값을 구한다.
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (isInRange(i, j, i, j+2)) {
                    int[] seq = new int[3];
                    int index = 0;
                    for (int col = j; col <= j+2; col++) {
                        seq[index] = grid[i][col];
                        index++;
                    }
                    int sum = Arrays.stream(seq).sum();
                    answer = Math.max(answer, sum);
                }
            }
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (isInRange(i, j, i+2, j)) {
                    int[] seq = new int[3];
                    int index = 0;
                    for (int row = i; row <= i+2; row++) {
                        seq[index] = grid[row][j];
                        index++;
                    }
                    int sum = Arrays.stream(seq).sum();
                    answer = Math.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
    }

    public static boolean isInRange(int x, int y, int nx, int ny) {
        return 0 <= x && nx < rowSize && 0 <= y && ny < colSize;
    }
}
