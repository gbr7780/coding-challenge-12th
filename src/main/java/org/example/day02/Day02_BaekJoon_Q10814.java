package org.example.day02;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * description    : 백준 10814 - 나이순 정렬
 * packageName    : org.example.day02
 * fileName        : Day02_BaekJoon_Q10814
 * author         : kimjongha
 * date           : 25. 5. 20.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 20.        kimjongha       최초 생성
 */
public class Day02_BaekJoon_Q10814 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input 입력 받음
        int n = Integer.parseInt(br.readLine());
        String[][] strArr = new String[n][2];

        // 이차원 배열에 나이와 이름 담기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            strArr[i][0] = st.nextToken();
            strArr[i][1] = st.nextToken();
        }

        // 2차원 배열 정렬.. 나이를 정수형으로 변환하여 비교후 오름차순 정렬
        Arrays.sort(strArr, (a,b) -> Integer.compare(Integer.parseInt(a[0]), Integer.parseInt(b[0])));

        // 결과값 출력
        for (int i = 0; i < n; i++) {
            bw.write(strArr[i][0] + " " + strArr[i][1] + "\n");
        }

        bw.flush();
        bw.close();


    }

}
