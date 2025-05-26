package org.example.day08;

import java.io.*;

/**
 * description    : 백준 2578 - 빙고
 * packageName    : org.example.day08
 * fileName        : Day08_BaekJoon_Q2578
 * author         : kimjongha
 * date           : 25. 5. 26.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 26.        kimjongha       최초 생성
 */
public class Day08_BaekJoon_Q2578 {


    public static void findNum(int[][] board, int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                // 숫자를 찾으면 지우기
                if (board[i][j] == number) {
                    board[i][j] = 0;
                    return;
                }

            }
        }
    }


    public static int countBingoLines(int[][] board) {
        // 빙고에 해당하는 라인
        int count = 0;

        // 행
        for (int i = 0; i < 5; i++) {
            boolean bingo = true;

            // 전체 0이면 count +1
            for (int j = 0; j < 5; j++) {
                if (board[i][j] != 0) bingo = false;
            }

            if (bingo) count++;
        }

        // 열
        for (int i = 0; i < 5; i++) {
            boolean bingo = true;
            for (int j = 0; j < 5; j++) {
                if (board[j][i] != 0) bingo = false;
            }
            if (bingo) count++;
        }

        // 대각선 (좌에서 우)
        boolean diag1 = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != 0) diag1 = false;
        }
        if (diag1) count++;

        // 대각선 (우에서 좌)
        boolean diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] != 0) diag2 = false;
        }
        if (diag2) count++;

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 5x5 빙고판 생성
        int[][] board = new int[5][5];

        // 빙고판에 값 삽입
        for (int i = 0; i < 5; i++) {
            String[] inputLine = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(inputLine[j]);
            }
        }

        int count = 0;
        loop:
        for (int i = 0; i < 5; i++) {
            String[] inputLine = br.readLine().split(" ");

            for (int j = 0; j < 5; j++) {
                count++;
                findNum(board, Integer.parseInt(inputLine[j]));

                // 빙고 라인이 3개 이상이면 횟수 출력하고 반복문 탈출
                if (countBingoLines(board) > 2) {
                    bw.write(String.valueOf(count));
                    break loop;
                }
            }

        }

        bw.flush();
        bw.close();


    }



}
