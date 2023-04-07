package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashSet;
// hashset 기본
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Exercise1 {
    public static int n; //명령 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            int value = Integer.parseInt(st.nextToken());
            if (command.equals("find")) {
                sb.append(hashSet.contains(value)).append("\n");
            }
            if (command.equals("remove")) {
                hashSet.remove(value);
            }
            if (command.equals("add")) {
                hashSet.add(value);
            }
        }
        System.out.println(sb);
    }
}
