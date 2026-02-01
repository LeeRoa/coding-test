package step02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BaekJoon_4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            char[] inputArr = str.toCharArray();

            Deque<Character> stack = new ArrayDeque<>();

            boolean result = true;
            for (char word : inputArr) {
                if (word == '[' || word == '(') {
                    stack.push(word);
                }

                if (!stack.isEmpty()) {
                    if (word == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else if (word == ']' && stack.peek() != '[') {
                        result = false;
                        break;
                    }

                    if (word == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (word == ')' && stack.peek() != '(') {
                        result = false;
                        break;
                    }
                } else {
                    if (word == ']' || word == ')') {
                        result = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                result = false;
            }

            System.out.println(result ? "yes" : "no");
        }
    }
}
