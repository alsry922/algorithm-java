package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeMap;
// treemap 기본
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise1 {
    public static int n; // 명령의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        StringBuffer sb = new StringBuffer();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("print_list")) {
                if (treeMap.isEmpty()) {
                    sb.append("None");
                } else {
                    Iterator<Map.Entry<Integer, Integer>> it = treeMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, Integer> node = it.next();
                        sb.append(treeMap.get(node.getKey())).append(" ");
                    }
                }
                sb.append("\n");
            } else {
                int key = Integer.parseInt(st.nextToken());

                if (command.equals("find")) {
                    if (!treeMap.containsKey(key)) {
                        sb.append("None").append("\n");
                    } else {
                        sb.append(treeMap.get(key)).append("\n");
                    }
                }

                if (command.equals("remove")) {
                    if (!treeMap.containsKey(key)) {
                        continue;
                    }
                    treeMap.remove(key);
                }

                if (command.equals("add")) {
                    int value = Integer.parseInt(st.nextToken());
                    treeMap.put(key, value);
                }
            }
        }
        System.out.println(sb);
    }
}
