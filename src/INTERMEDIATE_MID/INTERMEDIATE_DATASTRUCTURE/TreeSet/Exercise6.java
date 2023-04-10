package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
// 가까운 숫자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise6 {
    public static int n; //주어지는 수 갯수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            treeSet.add(input);
            if (treeSet.lower(input) != null) {
                dist = Math.min(dist, Math.abs(treeSet.lower(input) - input));
            }
            if (treeSet.higher(input) != null) {
                dist = Math.min(dist, Math.abs(treeSet.higher(input) - input));
            }

            System.out.println(dist);
        }
    }
}
