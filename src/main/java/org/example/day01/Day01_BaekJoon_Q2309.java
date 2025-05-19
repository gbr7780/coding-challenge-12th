package org.example.day01;

import java.io.*;
import java.util.Arrays;

/**
 * description    : 백준 2309 - 일곱 난쟁이
 * packageName    : org.example.day01
 * fileName        : Day01_BaekJoon_Q2309
 * author         : kimjongha
 * date           : 25. 5. 19.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 19.        kimjongha       최초 생성
 */
public class Day01_BaekJoon_Q2309 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 초기화
        int[] intArr = new int[9];
        int sum = 0;

        // 9개의 정수 입력 받음
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(br.readLine());
            sum += intArr[i];
        }

        // 오름차순 정렬
        Arrays.sort(intArr);

        // 2개의 거짓 난쟁이 인덱스 저장
        int a = 0, b = 0;

        for (int i = 0; i < intArr.length-1; i++) {

            for (int j = i+1; j < intArr.length; j++) {

                // 7개의 숫자가 100일때
                if (sum - (intArr[i] + intArr[j]) == 100) {
                    a = i;
                    b = j;
                    break;
                }

            }
        }

        // 결과값 출력
        for (int i : intArr) {
            if (i != intArr[a] && i != intArr[b]) {
                bw.write( String.valueOf(i) + "\n");
            }
        }

        bw.flush();
        bw.close();


    }





}
