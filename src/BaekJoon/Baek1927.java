package BaekJoon;
// 최소 힙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek1927 {
    public static ArrayList<Integer> list = new ArrayList<>(List.of(0));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int rep = Integer.parseInt(br.readLine());

        while (rep-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                sb.append(printMin()).append("\n");
            } else {
                list.add(input);
                    bubbleUp(list.size()-1, 1);
            }
        }
        System.out.println(sb);
    }

    private static void bubbleUp(int currIdx, int rootIdx) {
        if (list.size()-1 > 1) {
            int parentIdx = currIdx / 2;
            int smallestIdx = parentIdx;

            if (parentIdx >= rootIdx && list.get(parentIdx) > list.get(currIdx)) {
                smallestIdx = currIdx;
            }

            if (smallestIdx != parentIdx) {
                int temp = list.get(smallestIdx);
                list.set(smallestIdx, list.get(parentIdx));
                list.set(parentIdx, temp);
                bubbleUp(parentIdx, rootIdx);
            }
        }
    }

    public static int printMin() {
        if (list.size() - 1 < 1) {
            return 0;
        }

        int removeItem = list.get(1);
        list.set(1, list.get(list.size() - 1));
        list.set(list.size() - 1, removeItem);
        list.remove(list.size() - 1);

        bubbleDown(1, list.size() - 1);


        return removeItem;
    }

    public static void bubbleDown(int smallestIdx, int lastIdx) {
        int parentIdx = smallestIdx;
        int leftIdx = parentIdx * 2;
        int rightIdx = parentIdx * 2 + 1;

        if (leftIdx <= lastIdx && list.get(leftIdx) < list.get(smallestIdx)) {
            smallestIdx = leftIdx;
        }

        if (rightIdx <= lastIdx && list.get(rightIdx) < list.get(smallestIdx)) {
            smallestIdx = rightIdx;
        }

        // swap 후에 내려간 위치에서 다시 heapify 진행
        if (parentIdx != smallestIdx) {
            int temp = list.get(parentIdx);
            list.set(parentIdx, list.get(smallestIdx));
            list.set(smallestIdx, temp);
            bubbleDown(smallestIdx, lastIdx);
        }

    }
}
