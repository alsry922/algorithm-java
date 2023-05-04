package INTERMEDIATE_LOW.Simulation.격자_안에서_터지고_덜어지는_경우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//2차원 폭발게임
public class Exercise6 {
    public static final int BLANK = -1;
    public static final int WILL_EXPLODE = 0;
    public static int N, M, K; //격자 크기, 반복되는 폭탄의 수, 수행 횟수
    public static int[][] grid;
    public static int[][] nextGrid;
    public static int[] arrColumn;
    public static int[] temp;
    public static int arrColumnLength;
    public static int tempLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        nextGrid = new int[N][N];
        arrColumn = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        simulate();
        for (int i = 0; i < K; i++) {
            rotate();
            simulate();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != BLANK) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void rotate() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nextGrid[i][j] = BLANK;
            }
        }

        for (int i = N-1; i >= 0; i--) {
            int currRow = N - 1;
            for (int j = N-1; j >= 0; j--) {
                if (grid[i][j] != BLANK) {
                    nextGrid[currRow--][N-1-i] = grid[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = nextGrid[i][j];
            }
        }
    }

    private static void simulate() {
        for (int col = 0; col < N; col++) {
            copyColumn(col);
            explode();
            copyResult(col);
        }
    }

    private static void copyResult(int col) {
        int resultIdx = arrColumnLength - 1;
        for (int i = N - 1; i >= 0; i--) {
            if (resultIdx >= 0) {
                grid[i][col] = arrColumn[resultIdx--];
            } else {
                grid[i][col] = BLANK;
            }
        }
    }

    private static void explode() {
        boolean didExplode;
        do {
            didExplode = false;
            for (int currIdx = 0; currIdx < arrColumnLength; currIdx++) {
                if (arrColumn[currIdx] == WILL_EXPLODE) continue;
                int endIdx = getEndIdxOfExplode(currIdx, arrColumn[currIdx]);
                if (endIdx - currIdx + 1 >= M) {
                    fillZero(currIdx, endIdx);
                    didExplode = true;
                }
            }
            moveToTemp();
            copyFromTemp();
        } while (didExplode);

    }

    private static void copyFromTemp() {
        arrColumnLength = tempLength;
        for (int i = 0; i < arrColumnLength; i++) {
            arrColumn[i] = temp[i];
        }
    }

    private static void moveToTemp() {
        tempLength = 0;
        for (int i = 0; i < arrColumnLength; i++) {
            if (arrColumn[i] != WILL_EXPLODE) {
                temp[tempLength++] = arrColumn[i];
            }
        }
    }

    private static void fillZero(int currIdx, int endIdx) {
        for (int i = currIdx; i <= endIdx; i++) {
            arrColumn[i] = 0;
        }
    }

    private static int getEndIdxOfExplode(int currIdx, int value) {
        int endIdx = currIdx;
        for (int i = currIdx + 1; i < arrColumnLength; i++) {
            if (arrColumn[i] == value) {
                endIdx++;
            } else {
                break;
            }
        }
        return endIdx;
    }

    private static void copyColumn(int col) {
        arrColumnLength = 0;
        for (int row = 0; row < N; row++) {
            if (grid[row][col] != BLANK) {
                arrColumn[arrColumnLength++] = grid[row][col];
            }
        }
    }
}
