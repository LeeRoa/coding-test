package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BaekJoon_10814 {
    static class Person {
        int age;
        String name;

        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    static ArrayList<Person> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list, (s1, s2) -> s1.age - s2.age);

        for (Person p : list) {
            System.out.println(p.age + " " + p.name);
        }
    }

}
