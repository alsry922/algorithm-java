package INTERMEDIATE_LOW.Simulation.격자_안에서_터지고_덜어지는_경우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int N; //arr size
    public static int[] arr; //주어지는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int tempLeng = arr.length - (end - start + 1);
            int[] temp = new int[tempLeng];
            int tempIndex = 1;

            for (int index = 1; index < arr.length; index++) {
                if (index < start || index > end) {
                    temp[tempIndex++] = arr[index];
                }
            }
            arr = temp;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(arr.length - 1).append("\n");
        for (int i = 1; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
