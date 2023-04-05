package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.HashMap;
// 자주 등장한 top k 숫자

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    int freq, value;

    public Pair(int freq, int value) {
        this.freq = freq;
        this.value = value;
    }

    @Override
    public int compareTo(Pair b) {
        if (this.freq == b.freq) {
            return b.value - this.value;
        }
        return b.freq - this.freq;
    }
}

public class Exercise7 {
    public static int n, k; //수의 갯수, 등장한 횟수
    public static int[] nums;
    public static Map<Integer, Integer> hashmap = new HashMap<>();
    public static ArrayList<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (!hashmap.containsKey(nums[i])) {
                hashmap.put(nums[i], 1);
            } else {
                hashmap.put(nums[i], hashmap.get(nums[i]) + 1);
            }
        }

        for (Integer key : hashmap.keySet()) {
            list.add(new Pair(hashmap.get(key), key));
        }

        Collections.sort(list);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < k; i++) {
            sb.append(list.get(i).value).append(" ");
        }
        System.out.println(sb);
    }
}
