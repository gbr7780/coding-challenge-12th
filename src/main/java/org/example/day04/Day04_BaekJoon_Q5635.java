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
