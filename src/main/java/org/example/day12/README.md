# 코딩테스트 챌린지 12기_입문반 Day12

## 📌 문제
백준 1463 - [1로 만들기](https://www.acmicpc.net/problem/1463)

## 📌 문제 탐색하기
### 문제 접근 방법
정수 X가 주어졌을때 아래 연산을 통해 1을 만드는 최소 연산 횟수를 구하기
- X가 3으로 나누어 떨어지면 3으로 나눔
- X가 2으로 나누어 떨어지면 2으로 나눔
- 1을 뺌


점화식은 이전값+1
- dp[i] = dp[i-1] +1;
- if i % 2 == 0 → dp[i] = min(dp[i], dp[i/2] + 1)
- if i % 3 == 0 → dp[i] = min(dp[i], dp[i/3] + 1)



## 📌 코드 설계하기
0. 점화식 수립
1. X 입력 받기
2. dp배열 선언 및 초기인덱스 삽입
3. 반복문을 통해 문제에서 제시한 조건 및 점화식
4. 결과값 출력



## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
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
