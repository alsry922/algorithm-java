package Simulation.격자_안에서_완전탐색;

import java.io.*;
import java.util.*;


public class Exercise1 {
    static int gridSize;
    static int[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        gridSize = Integer.parseInt(st.nextToken());
        grid = new int[gridSize][gridSize];

        int answer = 0;

        for (int i = 0; i < gridSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                answer = Math.max(answer, getCoins(i, j));
            }
        }

        StringBuffer sb = new StringBuffer(String.valueOf(answer));
        System.out.println(sb);
    }

    public static int getCoins(int row, int col) {
        int count = 0;
        if (row+2 < gridSize && col+2 < gridSize) {
            for (int i = row; i <= row+2; i++) {
                for (int j = col; j <= col+2; j++) {
                    if (grid[i][j] == 1)
                        count++;
                }
            }
        }
        return count;
    }
}