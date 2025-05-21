# 코딩테스트 챌린지 12기_입문반 Day3

## 📌 문제
백준 1181 - [단어 정렬](https://www.acmicpc.net/problem/1181)

## 📌 문제 탐색하기
### 문제 접근 방법
단어를 입력받아 조건에 맞춰 정렬하는 문제..

정렬 조건에서 중복을 허용하지 않기 때문에 Set 자료구조 이용하여 단어를 입력받아 저장하고 정렬 조건을 위해 List로 변환하여 compareTo(), compare() 사용하기



## 📌 코드 설계하기
1. n 입력받기
2. 반복문을 통해 입력받은 단어를 Set 저장(중복 제거)
3. Set -> List 변환
4. 단어 길이순으로 정렬하기 위해 compare() 사용, 단어 길이가 같을때 compareTo() 이용하여 사전순으로 정렬

## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
package org.example.day03;

import java.io.*;
import java.util.*;

/**
 * description    : 백준 1181 - 단어 정렬
 * packageName    : org.example.day03
 * fileName        : Day03_BaekJoon_Q1181
 * author         : kimjongha
 * date           : 25. 5. 21.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 5. 21.        kimjongha       최초 생성
 */
public class Day03_BaekJoon_Q1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 단어 입력받는 개수
        int n = Integer.parseInt(br.readLine());

        // set은 중복 허용하지 않는 자료구조
        Set<String> set = new HashSet<>();

        // set에 단어 입력
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        // 정렬 하기 위해 List로 변환
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, (a,b) -> {
            // 길이가 같을때 사전순으로 정렬
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            // 길이가 짧은순으로 정렬
            else {
                return Integer.compare(a.length(),b.length());
            }
        });

        // 결과값 출력
        for (String word : list) {
            bw.write(word + "\n");
        }

        bw.flush();
        bw.close();

    }

}
