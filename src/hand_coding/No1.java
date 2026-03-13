package hand_coding;

import java.util.*;

public class No1 {

    public static String simplifyPath(String path) {
        String[] dirs = path.split("/");
        System.out.println(Arrays.toString(dirs));
        Queue<String> queue = new ArrayDeque<>();
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!queue.isEmpty()) queue.poll();
            } else if (!dir.equals("")) {
                queue.offer(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : queue) {
            sb.append("/").append(dir);
        }

        return sb.toString();
    }

    public static void main(String[] args)  throws Exception {
        // 테스트 케이스
        String[] testPaths = {
                "/home/user/../docs/./work/",  // 예상: "/home/docs/work"
                "/../",                        // 예상: "/"
                "//a//b/c/..//d/",             // 예상: "/a/b/d"
                "/a/./b/../../c/",             // 예상: "/c"
                "/home//foo/"                  // 예상: "/home/foo"
        };

        System.out.println("=== Path Normalization Test ===");
        for (String p : testPaths) {
            String result = simplifyPath(p);
            System.out.printf("Input : %s\n", p);
            System.out.printf("Result: %s\n\n", result);
        }
    }
}
