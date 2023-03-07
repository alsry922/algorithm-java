package Simulation.격자_안에서_밀고당기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int beltSize, time;
    public static int[] topBelt, bottomBelt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        beltSize = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        topBelt = new int[beltSize];
        bottomBelt = new int[beltSize];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= beltSize - 1; i++) {
            topBelt[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <= beltSize - 1; i++) {
            bottomBelt[i] = Integer.parseInt(st.nextToken());
        }

        while (time > 0) {
            int topTemp = topBelt[beltSize-1];
            int bottomTemp = bottomBelt[beltSize-1];
            for (int i = beltSize-2; i >= 0; i--) {
                topBelt[i+1] = topBelt[i];
                bottomBelt[i+1] = bottomBelt[i];
            }

            topBelt[0] = bottomTemp;
            bottomBelt[0] = topTemp;
            time--;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <= beltSize - 1; i++) {
            stringBuffer.append(topBelt[i]).append(" ");
        }
        stringBuffer.append("\n");
        for (int i = 0; i <= beltSize - 1; i++) {
            stringBuffer.append(bottomBelt[i]).append(" ");
        }
        System.out.println(stringBuffer);
    }
}
