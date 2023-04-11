package INTERMEDIATE_MID.INTERMEDIATE_DATASTRUCTURE.TreeSet;
//길이가 무한대인 수평선 트랙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Person13 implements Comparable<Person13> {
    int x, v;

    public Person13(int x, int v) {
        this.x = x;
        this.v = v;
    }

    public int compareTo(Person13 nextPerson) {
        return this.x - nextPerson.x;
    }
}

class EventT implements Comparable<EventT> {
    double currT;
    int x, v;

    public EventT(double currT, int x, int v) {
        this.currT = currT;
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(EventT e) {
        double diff = this.currT - e.currT;
        if (diff < 0) {
            return -1;
        } else if (diff == 0) {
            return this.x - e.x;
        } else {
            return 1;
        }
    }
}
public class Exercise13 {
    public static int N, T; //사람 수, 분
    public static int[] x;
    public static int[] v;
    public static TreeSet<Person13> people = new TreeSet<>();
    public static TreeSet<EventT> eventTS = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        x = new int[N];
        v = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            people.add(new Person13(x[i], v[i]));
        }

        /*앞에 사람을 따라잡는 경우*/
        for (int i = 0; i < N - 1; i++) {
            addEvent(x[i], v[i], x[i + 1], v[i + 1]);
        }

        while (!eventTS.isEmpty()) {
            EventT e = eventTS.first();
            double currT = e.currT;
            int x = e.x;
            int v = e.v;

            if (currT > T) {
                break;
            }

            people.remove(new Person13(x, v));
            eventTS.remove(e);

            Person13 nextPerson = people.higher(new Person13(x, v));
            if (people.lower(new Person13(nextPerson.x, nextPerson.v)) != null) {
                Person13 previousPerson = people.lower(new Person13(nextPerson.x, nextPerson.v));
                int px = previousPerson.x;
                int pv = previousPerson.v;
                removeEvent(px, pv, x, v);
                addEvent(previousPerson.x, previousPerson.v, nextPerson.x, nextPerson.v);
            }
        }
        System.out.println(people.size());

    }

    private static void removeEvent(int x1, int v1, int x2, int v2) {
        if (v1 <= v2) {
            return;
        }
        eventTS.remove(new EventT(1.0 * (x2 - x1) / (v1 - v2), x1, v1));
    }

    private static void addEvent(int x1, int v1, int x2, int v2) {
        if (v1 <= v2) {
            return;
        }
        eventTS.add(new EventT(1.0*(x2-x1)/(v1-v2), x1, v1));
    }
}