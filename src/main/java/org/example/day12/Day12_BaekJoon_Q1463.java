package org.example.day12;

import java.io.*;

/**
 * description    : 백준 1463 - 1로 만들기
 * packageName    : org.example.day12
 * fileName        : Day12_BaekJoon_Q1463
 * author         : kimjongha
 * date           : 25. 5. 30.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 30.        kimjongha       최초 생성
 */
public class Day12_BaekJoon_Q1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X+1];
        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i-1]+1;  // 1을 빼는 경우

            // 2로 나눌때 비교하여 최솟값 갱신
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }

            // 3로 나눌때 비교하여 최솟값 갱신
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }
        System.out.print(dp[X]);
    }

}
