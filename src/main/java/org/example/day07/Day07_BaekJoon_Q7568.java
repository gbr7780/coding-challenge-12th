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
