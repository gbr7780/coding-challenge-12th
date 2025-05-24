package org.example.day05;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

/**
 * description    : 백준 25305 - 커트라인
 * packageName    : org.example.day05
 * fileName        : Day05_BaekJoon_Q25305
 * author         : kimjongha
 * date           : 25. 5. 23.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 23.        kimjongha       최초 생성
 */
public class Day05_BaekJoon_Q25305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 응시자수(n)과 상 받는 사람의 수(k)를 입력
        String[] inputLine = br.readLine().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        int k = Integer.parseInt(inputLine[1]);

        // 학생의 점수 입력
        Integer [] xArr = new Integer[n];
        String[] inputX = br.readLine().split(" ");

        // 배열에 점수 저장
        for (int i = 0; i < n; i++) {
            xArr[i] = Integer.parseInt(inputX[i]);
        }

        // 점수 내림차순 정렬
        Arrays.sort(xArr, Collections.reverseOrder());

        // 결과값 출력
        bw.write(String.valueOf(xArr[k-1]));
        bw.flush();
        bw.close();

    }

}
