# 코딩테스트 챌린지 12기_입문반 Day6

## 📌 문제
백준 2947 - [나무 조각](https://www.acmicpc.net/problem/2947)

## 📌 문제 탐색하기
### 문제 접근 방법
인접한 두 수를 비교하여 서로의 위치를 바꾸고 출력하는 조건을 파악하는것이 핵심

정렬 알고리즘 중 버블 정렬에 해당하여 직접 구현하기

버블 정렬에 핵심은 한번 전체 순회를 하면 가장 큰 수가 맨 뒤로 이동함

위치 변경이 일어날때 배열 전체 인덱스 출력하기



## 📌 코드 설계하기
1. 나무 조각 Input
2. 입력 받은 문자열 배열을 정수형 배열로 변경
3. 버블 정렬 구현
4. 결과값 출력
5. 정렬 완료후 반복문 종료

## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
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


