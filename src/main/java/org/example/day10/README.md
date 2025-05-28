# 코딩테스트 챌린지 12기_입문반 Day9

## 📌 문제
백준 2775 - [부녀회장이 될테야](https://www.acmicpc.net/problem/2775)

## 📌 문제 탐색하기
### 문제 접근 방법
문제의 구조를 파악해보면 아파트 0층부터 있고 각 층에는 i호부터 14호까지 살고있다.

0층 i호에는 i명이 살고 위 층은 아래층의 1호부터 i호까지 사람의 수를 합만큼 살고있음

즉, 0층을 제외하고 위 층은 호수는 규칙적인걸 파악할 수 있고 해당 규칙을 점화식으로 나타내면 아래와 같다.

점화식 - dp[k][n] = dp[k-1][1] + dp[k-1][2] + ... + dp[k-1][n]


## 📌 코드 설계하기
0. 점화식 수립
1. 테스트 케이스 수 입력
2. 이차원 배열 15x14 선언
3. 이중 for문을 통해 각 층의 호수에 사람 수를 이차원 배열에 삽입
4. 결과값 출력

## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
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
