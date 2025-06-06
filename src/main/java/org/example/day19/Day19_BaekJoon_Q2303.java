package org.example.day19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * description    :
 * packageName    : org.example.day19
 * fileName        : Day19_BaekJoon_Q2303
 * author         : kimjongha
 * date           : 25. 6. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 6. 5.        kimjongha       최초 생성
 */
public class Day19_BaekJoon_Q2303 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] cards = new int[n][5];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int winner = 0;
        int maxScore = -1;

        for (int i = 0; i < n; i++) {
            int max = 0;
            // 5장 중 3장 뽑는 조합
            for (int a = 0; a < 5; a++) {
                for (int b = a + 1; b < 5; b++) {
                    for (int c = b + 1; c < 5; c++) {
                        int sum = cards[i][a] + cards[i][b] + cards[i][c];
                        int score = sum % 10;
                        if (score > max) {
                            max = score;
                        }
                    }
                }
            }
            if (max >= maxScore) {
                maxScore = max;
                winner = i + 1; // 사람 번호는 1부터 시작
            }
        }

        System.out.println(winner);




    }

}
