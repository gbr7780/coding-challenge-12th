# 코딩테스트 챌린지 12기_입문반 Day14

## 📌 문제
백준 17204 - [죽음의 게임](https://www.acmicpc.net/problem/17204)

## 📌 문제 탐색하기
### 문제 접근 방법
어제 풀었던 문제와 비슷하게 각 학생은 하나의 친구 번호를 가르키고, A가 시작해서 B에게 몇 단계만에 도달할 수 있는지 찾는 문제

case 1. 방문하지 않은 학생을 만나면 이동횟수를 증가하고 visited배열에서 체크하고 다음 사람으로 이동

case 2. 현재 위치가 목표 번호이면 성공 -> 이동횟수 출력하고 종료

case 3. 이미 방문한 곳이면 실패 -> -1 출력



## 📌 코드 설계하기
1. 사람수 및 목표 번호 입력 받기

2. 반복문을 통해 정수형 배열에 각 사람이 다음에 누굴 지목하는지 배열에 저장 ex) next[0] = 3 -> 0번은 3번을 지목

3. 탐색하기 위해 visited 배열을 생성

4. 반복문을 통해 위의 case1,2,3을 조건으로 구현

5. 결과값 출력



## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
package org.example.day14;

import java.io.*;

/**
 * description    : 백준 17204 - 죽음의 게임
 * packageName    : org.example.day14
 * fileName        : Day14_BaekJoon_Q17204
 * author         : kimjongha
 * date           : 25. 6. 1.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 6. 1.        kimjongha       최초 생성
 */
public class Day14_BaekJoon_Q17204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] input = br.readLine().split(" ");
        // 총 인원 수
        int n = Integer.parseInt(input[0]);
        // 도달해야 할 번호
        int k = Integer.parseInt(input[1]);

        // 학생이 가리키는 다음 사람
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
           next[i] = Integer.parseInt(br.readLine());
        }

        // 같은 사람을 중복으로 방문하지 않기 위해
        boolean[] visited = new boolean[n];
        // 이동한 횟수
        int count = 0;
        // 현재 위치
        int current = 0;    // 0부터 시작

        while (true) {

            // 목표 번호이면 결과값 출력하고 종료
            if (current == k) {
                System.out.println(count);
                return;
            }

            // 이미 방문한 곳
            if (visited[current]) {
                System.out.println(-1);
                return;
            }

            // 방문 안했을때
            visited[current] = true;
            current = next[current];
            count++;
        }



    }
}
