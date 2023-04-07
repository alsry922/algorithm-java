package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashSet;
//자리 바꾸기2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exercise5 {
    public static int N, K; //사람 수, 분
    public static int[] seats; //해당 자리에 앉은 사람
    public static int[] a;
    public static int[] b;
    public static HashSet<Integer>[] hashSets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        seats = new int[N + 1];
        hashSets = new HashSet[N+1];
        for (int i = 1; i <= N; i++) {
            seats[i] = i;
            hashSets[i] = new HashSet<>();
            hashSets[i].add(i);
        }
        a = new int[K];
        b = new int[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        for (int minute = 0; minute < 3 * K; minute++) {
            int index = minute % K;
            hashSets[seats[a[index]]].add(b[index]);
            hashSets[seats[b[index]]].add(a[index]);
            int temp = seats[a[index]];
            seats[a[index]] = seats[b[index]];
            seats[b[index]] = temp;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= N; i++) {
            sb.append(hashSets[i].size()).append("\n");
        }
        System.out.println(sb);
    }
}
