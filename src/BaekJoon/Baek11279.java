package BaekJoon;
// 최대 힙
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek11279 {
    public static ArrayList<Integer> list = new ArrayList<>(List.of(0));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int rep = Integer.parseInt(br.readLine());

        while (rep-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                sb.append(printMax()).append("\n");
            } else {
                list.add(input);
                if (list.size() - 1 > 1) {
                    bubbleUp(list.size()-1, 1);
                }
            }
        }

        System.out.println(sb);
    }

    private static void bubbleUp(int currIdx, int rootIdx) {
        int parentIdx = currIdx / 2;
        int largestIdx = parentIdx;

        if (parentIdx >= rootIdx && list.get(largestIdx) < list.get(currIdx)) {
            largestIdx = currIdx;
        }

        if (parentIdx != largestIdx) {
            int temp = list.get(largestIdx);
            list.set(largestIdx, list.get(parentIdx));
            list.set(parentIdx, temp);
            bubbleUp(parentIdx, rootIdx);
        }
    }

    private static int printMax() {
        if (list.size() - 1 < 1) {
            return 0;
        }

        int maxVal = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        bubbleDown(1, list.size() - 1);

        return maxVal;
    }

    private static void bubbleDown(int currIdx, int lastIdx) {
        int parentIdx = currIdx;
        int largestIdx = parentIdx;
        int leftIdx = currIdx * 2;
        int rightIdx = currIdx * 2 + 1;

        if (leftIdx <= lastIdx && list.get(leftIdx) > list.get(largestIdx)) {
            largestIdx = leftIdx;
        }

        if (rightIdx <= lastIdx && list.get(rightIdx) > list.get(largestIdx)) {
            largestIdx = rightIdx;
        }

        if (parentIdx != largestIdx) {
            int temp = list.get(largestIdx);
            list.set(largestIdx, list.get(parentIdx));
            list.set(parentIdx, temp);
            bubbleDown(largestIdx, lastIdx);
        }
    }
}
