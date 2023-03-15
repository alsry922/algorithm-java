package BaekJoon;

import java.io.*;
import java.util.*;


public class Baek11723 {
    public static final int X = 20;
    public static int[] S = new int[X+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb =  new StringBuffer();
        int M = Integer.parseInt(br.readLine()); //반복 횟수

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int element;

            switch (command) {
                case "add":
                    element = Integer.parseInt(st.nextToken());
                    add(element);
                    break;
                case "remove":
                    element = Integer.parseInt(st.nextToken());
                    remove(element);
                    break;
                case "check":
                    element = Integer.parseInt(st.nextToken());
                    sb.append(check(element)).append("\n");
                    break;
                case "toggle":
                    element = Integer.parseInt(st.nextToken());
                    toggle(element);
                    break;
                case "all":
                    all();
                    break;
                case "empty":
                    empty();
                    break;
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static boolean hasElement(int x) {
        return S[x] != 0;
    }

    public static void add(int x) {
        if (!hasElement(x)) {
            S[x] = x;
        }
    }

    public static void remove(int x) {
        if (hasElement(x)) {
            S[x] = 0;
        }
    }

    public static int check(int x) {
        if (!hasElement(x)) {
            return 0;
        }
        return 1;
    }

    public static void toggle(int x) {
        if (!hasElement(x)) {
            S[x] = x;
        } else {
            S[x] = 0;
        }
    }

    public static void all() {
        for (int i = 1; i < X + 1; i++) {
            S[i] = i;
        }
    }

    public static void empty() {
        for (int i = 1; i < X + 1; i++) {
            S[i] = 0;
        }
    }
}
