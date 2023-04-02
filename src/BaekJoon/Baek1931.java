package BaekJoon;
//회의실 배정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1931 {
    public static int n;
    public static int[] start; // 시작 시간 배열
    public static int[] end; // 종료 시간 배열
    public static int[][] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        time = new int[n][2];

        /*
        start = new int[n];
        end = new int[n];
        */

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            /*
                start[i] = Integer.parseInt(st.nextToken());
                end[i] = Integer.parseInt(st.nextToken());
            */
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (time1, time2) -> {
            if (time1[1] == time2[1]) {
                return time1[0] - time2[0];
            }
            return time1[1] - time2[1];
        });

        /*quickSort(0, n-1);*/


        int answer = 0;
        int beforeEndTime = 0;

        for (int i = 0; i < n; i++) {
            if (beforeEndTime <= time[i][0]) {
                beforeEndTime = time[i][1];
                answer++;
            }
        }

        /*
        for (int i = 1; i < n; i++) {
            if (beforeEndTime <= start[i]) {
                beforeEndTime = end[i];
                answer++;
            }
        }
        */
        System.out.println(answer);
    }

    /*퀵 정렬*/
    private static void quickSort(int low, int high) {
        if (low < high) {
            int pos = partition(low, high);

            quickSort(low, pos - 1);
            quickSort(pos + 1, high);
        }
    }

    /*정해진 피봇을 기준으로 작은 수는 왼쪽으로
     * 큰 수는 오른쪽으로 정렬*/
    private static int partition(int low, int high) {
        int pivot = end[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (end[j] < pivot) {
                i++;
                swap(i, j);
            }
        }

        i++;
        swap(i, high);
        return i;
    }

    /*i위치와 j위치의 값을 스왑*/
    private static void swap(int i, int j) {
        int endTemp = end[i];
        int startTemp = start[i];

        end[i] = end[j];
        start[i] = start[j];
        end[j] = endTemp;
        start[j] = startTemp;
    }
}
