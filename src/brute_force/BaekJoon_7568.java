package brute_force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_7568 {
    static class Person {
        int x;
        int y;
        int grade;

        Person(int x, int y, int grade) {
            this.x = x;
            this.y = y;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return x + " " + y + " 순위 : " + grade;
        }
    }

    static Person[] people;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        people = new Person[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), N);
        }

        for (int i = 0; i < people.length; i++) {
            for (int j = i + 1; j < people.length; j++) {
                Person p1 = people[i];
                Person p2 = people[j];

                if (p1.x > p2.x && p1.y > p2.y) {
                    p1.grade--;
                } else if (p1.x < p2.x && p1.y < p2.y){
                    p2.grade--;
                } else {
                    p1.grade--;
                    p2.grade--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Person p : people) {
            sb.append(p.grade).append(" ");
        }

        System.out.println(sb);
    }

}
