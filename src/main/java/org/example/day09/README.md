# 코딩테스트 챌린지 12기_입문반 Day9

## 📌 문제
백준 2748 - [피보나치 수2](https://www.acmicpc.net/problem/2748)

## 📌 문제 탐색하기
### 문제 접근 방법
시간복잡도를 고려했을때 재귀를 사용하면 O(2^n) 시간초과 발생하여 DP로 접근

DP(동적 계획법) 핵심은 이미 계산한 값을 배열에 저장해서 재사용함 (메모이제이션)

상태 정의 - dp[i]

점화식 - dp[i] = dp[i-1] + dp[i-2]

초기값 - dp[0] = 0, dp[1] = 1



## 📌 코드 설계하기
0. 점화식 선언
1. n을 입력 받음
2. long 배열 선언. int 범위 때문에 long타입으로 사용
3. 반복문을 통해 배열안에 피보나수를 계산하여 저장
4. 결과값 출력

## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
package org.example.day09;

import java.io.*;

/**
 * description    : 백준 2748 - 피보나치 수2
 * packageName    : org.example.day09
 * fileName        : Day09_BaekJoon_Q2748
 * author         : kimjongha
 * date           : 25. 5. 27.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 27.        kimjongha       최초 생성
 */
public class Day09_BaekJoon_Q2748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n을 입력 받음
        int n = Integer.parseInt(br.readLine());

        // 2. 배열 선언. 문제에서 n을 90까지 입력 가능하기에 long타입으로 선언
        long[] arr = new long[n+1];

        // 3. 배열안에 피보나치 수를 계산하여 저장
        for (int i = 0; i <= n; i++) {
            // 0,1은 배열 저장
            if (i == 0 || i == 1) {
                arr[i] = i;
                continue;
            }
            // (점화식) - 배열에서 이전에 저장된 피보나치 값을 불러와 계산하여 저장
            arr[i] = arr[i-1] + arr[i-2];
        }

        // 4. 결과값 출력
        bw.write(String.valueOf(arr[n]));
        bw.flush();
        bw.close();


    }

}

