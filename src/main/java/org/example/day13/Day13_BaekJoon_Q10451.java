package org.example.day13;

import java.io.*;
import java.util.StringTokenizer;

/**
 * description    : 백준 10451 - 순열 사이클
 * packageName    : org.example.day13
 * fileName        : Day13_BaekJoon_Q10451
 * author         : kimjongha
 * date           : 25. 5. 31.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 31.        kimjongha       최초 생성
 */
public class Day13_BaekJoon_Q10451 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int count = 0;
            int N = Integer.parseInt(br.readLine());
            int arr[] = new int[N+1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 주어진 숫자를 배열에 삽입
            for (int j = 1; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // 방문 확인을 위한 visited배열 생성
            boolean visited[] = new boolean[N+1];

            // 모든 숫자에 대해 탐색
            for (int a = 1; a <= N; a++) {

                if (!visited[a]) {
                    int next = a;

                    // 사이클 따라 방문 표시
                    while (!visited[next]) {
                        visited[next] = true;
                        next = arr[next];   // 다음 이동
                    }
                    count++;

                }

            }

            System.out.println(count);


        }


    }

}
