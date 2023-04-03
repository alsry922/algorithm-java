package INTERMEDIATE_LOW.Simulation.격자_안에서_단일_객체를_이동;
//떨어지는 1자 블록

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
    public static int n, m, k; //격자 크기, 블록 크기, 블록 시작 위치
    public static int[][] grid;
    public static int[] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new int[n + 1][n + 1];
        block = new int[m];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int blockRow = findBlockRow();

        for (int i = k; i <= k + m - 1; i++) {
            grid[blockRow][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


    public static int findBlockRow() {
        for (int i = 2; i <= n; i++) {
            for (int j = k; j <= k + m - 1; j++) {
                if (grid[i][j] == 1) {
                    return i-1;
                }
            }
        }
        return n;
    }
}