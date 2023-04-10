package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
// 문제 추천 시스템 1
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Problem implements Comparable<Problem> {
    int number;
    int difficulty;

    public Problem(int number, int difficulty) {
        this.number = number;
        this.difficulty = difficulty;
    }

    @Override
    public int compareTo(Problem problem) {
        if (this.difficulty == problem.difficulty) {
            return this.number - problem.number;
        }
        return this.difficulty - problem.difficulty;
    }
}
public class Exercise11 {
    public static int n, m; //문제 갯수, 명령어 입력 횟수
    public static TreeSet<Problem> problems = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            problems.add(new Problem(number, difficulty));
        }
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("ad")) {
                int number = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                problems.add(new Problem(number, difficulty));
            }
            if (command.equals("sv")) {
                int number = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                problems.remove(new Problem(number, difficulty));
            }
            if (command.equals("rc")) {
                int flag = Integer.parseInt(st.nextToken());
                if (flag == 1) {
                    System.out.println(problems.last().number);
                }
                if (flag == -1) {
                    System.out.println(problems.first().number);
                }
            }
        }
    }
}
