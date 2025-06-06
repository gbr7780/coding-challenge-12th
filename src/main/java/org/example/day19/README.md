# 코딩테스트 챌린지 12기_입문반 Day19

## 📌 문제
백준 2303 - [숫자 게임](https://www.acmicpc.net/problem/2303)

## 📌 문제 탐색하기
### 문제 접근 방법
이 문제는 완전탐색(브루트포스)에 대한 문제이고 아래와 같이 접근하기
1.  모든 사람에 대해 5장의 카드 중 3장을 선택하는 모든 조합을 구하기
2. 각 조합마다 합의 일의 자리(즉, % 10)를 계산
3. 각 사람의 최고 점수를 저장한 뒤, 전체 사람 중 가장 높은 점수를 가진 사람의 번호 찾기



## 📌 코드 설계하기
1. 사람의 수 및 카드 입력 받기

2. 반복문을 통해 완전탐색(브루트포스)

3. 각 사람마다 최고 점수를 비교해 가장 높은 사람(동점일 땐 번호 큰 사람)을 선택



## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
package org.example.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : org.example.day19
 * fileName        : Day19_BaekJoon_Q2303
 * author         : kimjongha
 * date           : 25. 6. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 6. 5.        kimjongha       최초 생성
 */
public class Day19_BaekJoon_Q2303 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] cards = new int[n][5];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int winner = 0;
        int maxScore = -1;

        for (int i = 0; i < n; i++) {
            int max = 0;
            // 5장 중 3장 뽑는 조합
            for (int a = 0; a < 5; a++) {
                for (int b = a + 1; b < 5; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        int sum = cards[i][a] + cards[i][b] + cards[i][c];
                        int score = sum % 10;
                        if (score > max) {
                            max = score;
                        }
                    }
                }
            }
            if (max >= maxScore) {
                maxScore = max;
                winner = i + 1; // 사람 번호는 1부터 시작
            }
        }

        System.out.println(winner);




    }

}
