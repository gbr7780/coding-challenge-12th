# 코딩테스트 챌린지 12기_입문반 Day12

## 📌 문제
백준 10451 - [순열 사이클](https://www.acmicpc.net/problem/10451)

## 📌 문제 탐색하기
### 문제 접근 방법
입력으로 주어진 순열은 1부터 N까지의 순열이고 순열에서 사이클이 몇 개 있는지 찾는 문제

어떤 숫자를 기준으로 다음 숫자로 이동해가면서 맨 처음으로 돌아오게 되는게 사이클

이미 방문한 숫자를 다시 방문하면 처리한 사이클이고, 방문 여부를 체크하는 배열을 통해 전체 순열을 돌면서 방문하지 않은 수가 있으면 새로우 사이클 시작



## 📌 코드 설계하기
1. 테스트 케이스 개수 입력
2. 반복문을 통해 숫자를 배열에 저장하고 방문 체크 배열을 선언
3. 1부터 N까지 모든 숫자에 대해 사이클 탐색하는 반복문 생성
4. 방문하지 않은곳을 사이클 따라가며 방문 표시
5. 사이클이 종료되면 카운터 증가
6. 결과값 출력



## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
package org.example.day13;

import java.io.*;
import java.util.StringTokenizer;

/**
 * description    : 백준 10451 - 순열 사이클
 * packageName    : org.example.day13
 * fileName        : Day13_BaekJoon_Q10451
 * author         : kimjongha
 * date           : 25. 5. 31.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 31.        kimjongha       최초 생성
 */
public class Day13_BaekJoon_Q10451 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int count = 0;
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 주어진 숫자를 배열에 삽입
            for (int j = 1; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // 방문 확인을 위한 visited배열 생성
            boolean visited[] = new boolean[N+1];

            // 모든 숫자에 대해 탐색
            for (int a = 1; a <= N; a++) {

                if (!visited[a]) {
                    int next = a;

                    // 사이클 따라 방문 표시
                    while (!visited[next]) {
                        visited[next] = true;
                        next = arr[next];   // 다음 이동
                    }
                    count++;

                }

            }

            System.out.println(count);


        }


    }

}
