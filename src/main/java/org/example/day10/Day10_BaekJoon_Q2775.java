package org.example.day10;

import java.io.*;

/**
 * description    : 백준 2775 - 부녀회장이 될테야
 * packageName    : org.example.day10
 * fileName        : Day10_BaekJoon_Q2775
 * author         : kimjongha
 * date           : 25. 5. 28.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 28.        kimjongha       최초 생성
 */
public class Day10_BaekJoon_Q2775 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수 입력
        int t = Integer.parseInt(br.readLine());

        int[][] intArr = new int[15][14];

        /**
         * 0층
         * 1호 : 1명
         * 2호 : 2명
         * 3호 : 3명
         *
         * 1층
         * 1호 : 1명(아래층 1호 -> 1)
         * 2호 : 1 + 2 = 3명
         * 3호 : 1 + 2 + 3 = 6명
         *
         * 2층
         * 1호 : 1명(아래층 1호 -> 1)
         * 2호 : 1 + 3 = 4명
         * 3호 : 1 + 3 + 6 = 10명
         *
         * 점화식 - dp[k][n] = dp[k-1][1] + dp[k-1][2] + ... + dp[k-1][n]
         */

        for (int i = 0; i < 15; i++) {
            // 누적합
            int temp = 0;

            for (int j = 0; j < 14; j++) {

                // 0층은 값 그대로 채우기
                if (i == 0) {
                    intArr[i][j] = j+1; // 배열에 인덱스는 0으로 시작하고 각 층의 호수는 1호 시작
                    continue;
                }

                // 점화식
                temp += intArr[i-1][j];
                intArr[i][j] = temp;

            }
        }

        // 결과값 출력
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(intArr[k][n-1] + "\n");
        }

        bw.flush();
        bw.close();

    }


}
