package org.example.day17;

import java.io.*;
import java.util.Arrays;

/**
 * description    : 백준 2204 - 도비의 난독증 테스트
 * packageName    : org.example.day17
 * fileName        : Day17_BaekJoon_Q2204
 * author         : kimjongha
 * date           : 25. 6. 4.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 6. 4.        kimjongha       최초 생성
 */
public class Day17_BaekJoon_Q2204 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            // 테스트 케이스 수 입력 받기
            int n = Integer.parseInt(br.readLine());

            // 0일때 결과값 출력하고 반복문 탈출
            if (n == 0) {
                bw.flush();
                break;
            }

            // 초기화
            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
            }

            // 대소문자 구분없이 정렬
            Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
            bw.write(words[0] + "\n");
        }

        bw.close();

    }

}
