package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//정원 입장은 선착순
public class Exercise11 {
    static class EnterPerson implements Comparable<EnterPerson> {
        int arrive, stay, number;

        public EnterPerson(int arrive, int stay, int number) {
            this.arrive = arrive;
            this.stay = stay;
            this.number = number;
        }

        public int compareTo(EnterPerson nextPerson) {
            if (this.arrive != nextPerson.arrive) {
                return this.arrive - nextPerson.arrive;
            }
            return this.number - nextPerson.number;
        }
    }

    static class WaitPerson implements Comparable<WaitPerson> {
        int arrive, stay, number;

        public WaitPerson(int arrive, int stay, int number) {
            this.arrive = arrive;
            this.stay = stay;
            this.number = number;
        }

        public int compareTo(WaitPerson waitPerson) {
            return this.number - waitPerson.number;
        }
    }

    public static int N; //사람 수
    public static EnterPerson[] people;
    public static PriorityQueue<WaitPerson> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        people = new EnterPerson[N+1];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int stay = Integer.parseInt(st.nextToken());
            people[i] = new EnterPerson(arrive, stay, i + 1);
        }
        people[N] = new EnterPerson(Integer.MAX_VALUE, 0, N + 1);

        Arrays.sort(people);

        int exitTime = 0;
        int answer = 0;
        for (int i = 0; i <= N; i++) {
            int arrive = people[i].arrive;
            int stay = people[i].stay;
            int number = people[i].number;

            while (arrive >= exitTime && !pq.isEmpty()) {
                WaitPerson nextWP = pq.poll();
                int waitPersonA = nextWP.arrive;
                int waitPersonS = nextWP.stay;

                answer = Math.max(answer, exitTime - waitPersonA);

                exitTime += waitPersonS;
            }

            if (arrive >= exitTime) {
                exitTime = arrive + stay;
            } else {
                pq.add(new WaitPerson(arrive, stay, number));
            }
        }
        System.out.println(answer);
    }
}
