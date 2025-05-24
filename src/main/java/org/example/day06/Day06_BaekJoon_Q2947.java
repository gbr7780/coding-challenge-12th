package org.example.day06;

import java.io.*;
import java.util.Arrays;

/**
 * description    : 백준 2947 - 나무 조각
 * packageName    : org.example.day06
 * fileName        : Day06_BaekJoon_Q2947
 * author         : kimjongha
 * date           : 25. 5. 24.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 24.        kimjongha       최초 생성
 */
public class Day06_BaekJoon_Q2947 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputLine = br.readLine().split(" ");
        int [] intArr = new int[inputLine.length];

        // 정수형 변환
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(inputLine[i]);
        }

        int temp = 0;
        // 버블정렬 구현
        while (true) {
            
            for (int i = 0; i < intArr.length-1; i++) {
                // 인접한 두수 비교
                if (intArr[i] > intArr[i+1]) {
                    temp = intArr[i];
                    intArr[i] = intArr[i+1];
                    intArr[i+1] = temp;
                    bw.write(intArr[0] + " " + intArr[1] + " " + intArr[2] + " " + intArr[3] + " " + intArr[4] + "\n");
                }
            }
            // 완전히 정렬되면 반복문 종료
            if (Arrays.equals(intArr, new int[]{1,2,3,4,5})) break;
        }

        bw.flush();
        bw.close();
    }

}
