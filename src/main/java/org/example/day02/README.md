# 코딩테스트 챌린지 12기_입문반 Day2

## 📌 문제
백준 10814 - [나이순 정렬](https://www.acmicpc.net/problem/2309)

## 📌 문제 탐색하기
### 문제 접근 방법
이차원 배열을 통해 이름과 나이를 저장하기

담은 데이터를 나이순으로 정렬 해야하는데 자바에서 Arrays.sort() compare메소드를 통해 나이를 정렬한다.

사실, 이차원 배열 말고 자바에 클래스 객체를 선언하여 정수형은 나이, 이름은 문자열 필드를 선언하여 객체에 담는 방법도 효율적인것 같다.

## 📌 코드 설계하기
1. n 입력받기
2. 이차원 배열을 선언하고 반복문을 통해 이차원 배열에 나이와 이름 저장
3. Arrays.Sort() compare를 통해 정렬
4. 결과값 출력

## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
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
