import java.util.*;

public class Main {

  public static HashMap<String, Integer> wordMap;
  public static boolean[] visited;
  public static int[] step;
  public static void main(String[] args) {
    String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    String begin = "hit";
    String target = "cog";
    visited = new boolean[words.length + 1];
    step = new int[words.length + 1];
    wordMap = new HashMap<>(words.length + 1);
    wordMap.put(begin, 0);

    for (int i = 0; i < words.length; i++) {
      wordMap.put(words[i], i+1);
    }

    Queue<String> queue = new LinkedList<>();
    queue.add(begin);
    visited[0] = true;

    while (!queue.isEmpty()) {
      String currWord = queue.poll();
      for (int i = 0; i < words.length; i++) {
        int idx = wordMap.get(words[i]);
        if(!visited[idx] && canTransit(currWord, words[i])) {
          visited[idx] = true;
          step[idx] = step[wordMap.get(currWord)] + 1;
          queue.add(words[i]);
          if (words[i].equals(target)) break;
        }
      }
    }
    System.out.println(step[wordMap.get(target)]);
  }

  public static boolean canTransit(String currWord, String nextWord) {
    int differentNum = 0;
    for (int i = 0; i < currWord.length(); i++) {
      if (currWord.charAt(i) != nextWord.charAt(i))
        differentNum++;
    }
    return differentNum <= 1;
  }

}