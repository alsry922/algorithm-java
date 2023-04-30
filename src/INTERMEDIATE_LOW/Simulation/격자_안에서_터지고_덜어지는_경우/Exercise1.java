package INTERMEDIATE_LOW.Simulation.격자_안에서_터지고_덜어지는_경우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//1차원 젠가
public class Exercise1 {
    public static int N; //블록 갯수
    public static int[] arr;
    public static int[][] removeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        removeSize = new int[2][2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            removeSize[i][0] = start;
            removeSize[i][1] = end;
        }

        for (int i = 0; i < 2; i++) {
            int start = removeSize[i][0];
            int end = removeSize[i][1];
            int[] temp = new int[arr.length - (end - start + 1)];
            int idx = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j >= start && j <= end) {
                    continue;
                }
                temp[idx++] = arr[j];
            }
            arr = temp;
        }

        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
