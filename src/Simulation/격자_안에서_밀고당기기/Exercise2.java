package Simulation.격자_안에서_밀고당기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2 {
    public static int N, T;
    public static int[] left, right, bottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        left = new int[N];
        right = new int[N];
        bottom = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bottom[i] = Integer.parseInt(st.nextToken());
        }

        while (T-- > 0) {
            int temp = left[N-1];
            for (int i = N-2; i >= 0; i--) {
                left[i + 1] = left[i];
            }
            left[0] = bottom[N-1];

            int temp2 = right[N-1];
            for (int i = N - 2; i >= 0; i--) {
                right[i+1] = right[i];
            }
            right[0] = temp;

            for (int i = N - 2; i >= 0; i--) {
                bottom[i+1] = bottom[i];
            }
            bottom[0] = temp2;

        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < N; i++) {
            sb.append(left[i]).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < N; i++) {
            sb.append(right[i]).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < N; i++) {
            sb.append(bottom[i]).append(" ");
        }
        sb.append("\n");

        System.out.println(sb);
    }
}

