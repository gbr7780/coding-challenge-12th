# 코딩테스트 챌린지 12기_입문반 Day7

## 📌 문제
백준 7568 - [덩치](https://www.acmicpc.net/problem/7568)

## 📌 문제 탐색하기
### 문제 접근 방법
단순히 정렬이 아니라 몸무게와 키를 비교하여 자기보다 큰 사람의 수를 세는것!

모든 사람을 비교해야 하므로 이중 for문 사용

키와 몸무게를 담을 객체 생성



## 📌 코드 설계하기
1. Person클래스에 키 / 몸무게 / 순위등 필드 생성
2. n(사람의 수) 입력
3. 객체을 생성하여 객체 배열에 삽입
4. 이중 for문을 통해 모든 사람과 비교
5. 결과값 출력

## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
package org.example.day07;

import java.io.*;

/**
 * description    : 백준 7568 - 덩치
 * packageName    : org.example.day07
 * fileName        : Day07_BaekJoon_Q7568
 * author         : kimjongha
 * date           : 25. 5. 25.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 25.        kimjongha       최초 생성
 */
public class Day07_BaekJoon_Q7568 {

    // 키,몸무게,순위 정보를 담을 Person 클래스 생성
    public static class Person {
        // 몸무게
        private int weight;
        // 키
        private int height;
        // 순위 -> 1로 초기화
        private int rank = 1;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사람의 수 입력
        int n = Integer.parseInt(br.readLine());
        // 객체배열 생성
        Person[] people = new Person[n];

        // 사람별 몸무게 키를 입력받아 객체생성하고 배열에 저장
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            people[i] = new Person(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
        }

        // 모든 사람을 비교하기 위해 이중for문
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // 자기 자신은 비교 제외
                if (i == j) continue;

                // 키와 몸무게 둘다 커야 덩치가 큰 사람
                if (people[i].height < people[j].height && people[i].weight < people[j].weight) {
                    people[i].rank++;
                }
            }
        }

        // 결과값 출력
        for (int i = 0; i < n; i++) {
            bw.write(people[i].rank + " ");
        }
        
        bw.flush();
        bw.close();

    }

}
