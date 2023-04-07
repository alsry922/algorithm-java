package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeMap;
//비율 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Exercise2 {
    public static int n; //문자열 갯수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = n;
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

        while (n-- > 0) {
            String input = br.readLine();
            if (!treeMap.containsKey(input)) {
                treeMap.put(input, 1);
            } else {
                treeMap.put(input, treeMap.get(input) + 1);
            }
        }

        StringBuffer sb = new StringBuffer();
        Iterator<Map.Entry<String, Integer>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> node = iterator.next();
            String str = node.getKey();
            int freq = node.getValue();
            double percent = (double)freq / m * 100;
            double rate = (double)(Math.round(percent * 10000))/10000;
            sb.append(str).append(" ").append(String.format("%.4f", rate));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
