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
