# 코딩테스트 챌린지 12기_입문반 Day4

## 📌 문제
백준 5635 - [생일](https://www.acmicpc.net/problem/5635)

## 📌 문제 탐색하기
### 문제 접근 방법
단어를 입력받아 조건에 맞춰 정렬하는 문제.. 

비교할 조건이 3개(년/월/일) 있으므로 Person클래스를 선언해서

객체 생성하고 sort()를 통해 Comparator를 구현하여 비교하여 정렬



## 📌 코드 설계하기
1. Person클래스 선언
2. 학생의 수(n) Input
3. n만큼 반복문을 통해 학생 정보를 입력받아 객체 생성
4. 객체 배열을 선언하여 객체 담기
5. sort()함수를 통해 Comparator구현하여 정렬
6. 결과값 비교

## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
package org.example.day04;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * description    : 백준 5635 - 생일
 * packageName    : org.example.day04
 * fileName        : Day04_BaekJoon_Q5635
 * author         : kimjongha
 * date           : 25. 5. 22.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 22.        kimjongha       최초 생성
 */
public class Day04_BaekJoon_Q5635 {

    // 입력 정보를 담을 Person클래스 생성
    public static class Person {
        private String name;
        private int year;
        private int month;
        private int day;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 학생의 수 입력받음
        int n = Integer.parseInt(br.readLine());
        // 객체를 담을 배열 생성
        Person[] people = new Person[n];

        // 학생의 정보를 입력받아 객체를 생성하고 배열에 삽입
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            people[i] = new Person(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        // 정렬을 위해 Comparator 구현
        Arrays.sort(people,(a,b) -> {
            // 연도 비교
            if (a.year != b.year) {
                return a.year - b.year;
            }
            // 월 비교
            else if (a.month != b.month) {
                return a.month - b.month;
            }
            // 일 비교
            else {
                return a.day - b.day;
            }
        });

        // 결과값 출력
        bw.write(people[people.length-1].name + "\n" + people[0].name);
        bw.flush();
        bw.close();

    }


}

