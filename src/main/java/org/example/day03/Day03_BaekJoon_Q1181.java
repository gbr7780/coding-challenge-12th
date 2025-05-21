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
