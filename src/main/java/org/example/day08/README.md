# 코딩테스트 챌린지 12기_입문반 Day8

## 📌 문제
백준 2578 - [빙고](https://www.acmicpc.net/problem/2578)

## 📌 문제 탐색하기
### 문제 접근 방법
입력 받은 숫자를 이차원 배열 5x5 저장

핵심은 지우기 / 빙고 라인 찾기 인데

지우기는 사회자가 입력한 숫자를 이차원 배열에서 이중for문을 통해 찾아서 해당 인덱스를 0으로처리

빙고라인 찾기는 행, 열, 대각선(좌에서우), 대각선(우에서좌) 이렇게 4개가 존재하기에 각각 해당하는 조건을 생성하기

마지막 빙고 부른 횟수는 반복문에 카운트를 통해 빙고라인3개 이상인 시점에 출력



## 📌 코드 설계하기
1. 이차원 배열 5x5 생성하여 숫자 저장
2. 사회자가 부른 숫자를 이중for문 생성
3. 빙고판에 숫자를 찾아서 지우는 findNum() 함수 생성
4. 빙고인지 확인하기 위한 countBingoLines() 함수 생성
5. 빙고라인이 3개 이상일때 이중for문에 반복 횟수를 출력

## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
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

