package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
//top k 숫자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise7 {
    public static int n, k;
    public static TreeSet<Integer> treeSet = new TreeSet<Integer>();
    public static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            treeSet.add(input);
        }

        StringBuffer sb = new StringBuffer();
        sb.append(treeSet.last()).append(" ");
        int currNum = treeSet.last();
        for (int i = 0; i < k-1; i++) {
            sb.append(treeSet.lower(currNum)).append(" ");
            currNum = treeSet.lower(currNum);
        }
        System.out.println(sb);
    }
}
