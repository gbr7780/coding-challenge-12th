# 코딩테스트 챌린지 12기_입문반 Day18

## 📌 문제
백준 5567 - [결혼식](https://www.acmicpc.net/problem/2204)

## 📌 문제 탐색하기
### 문제 접근 방법
초대 조건

1. 상근이의 친구

2. 상근이의 친구의 친구

그래프를 구성하여 BFS(너비우선탐색)으로 구현하면 될것 같다. BFS 구현시 조건으로 상근이의 친구의 친구까지만 초대 카운트를 세우는 방향으로!



## 📌 코드 설계하기
1. 사람의 수, 리스트 길이 입력 받기

2. 그래프를 구현하기 위해 list 초기화 및 간선 연결

3. BFS 구현

4. 중복 방지 배열을 체크하면서 카운트 증가

5. 결과값 출력



## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
package org.example.day18;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * description    : 백준 5567 - 결혼식
 * packageName    : org.example.day18
 * fileName        : Day18_BaekJoon_Q5567
 * author         : kimjongha
 * date           : 25. 6. 5.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 6. 5.        kimjongha       최초 생성
 */
public class Day18_BaekJoon_Q5567 {

    // bfs 너비우선 탐색
    public static int bfs (List<Integer>[] graph, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        // 1(상근이)부터 탐색
        visited[1] = true;
        queue.offer(new int[]{1,0});

        // 초대 인원 카운트
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int person = current[0];
            int depth = current[1];

            // 초대 조건
            // 1. 상근이의 친구
            // 2. 상근이의 친구의 친구
            // 상근이의 친구의 친구까지만 초대조건이므로 2까지 허용
            if (depth >= 2) continue;

            for (int friend : graph[person]) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    queue.offer(new int[]{friend, depth+1});
                    count++;
                }
            }

        }



        return count;


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람의 수
        int n = Integer.parseInt(br.readLine());

        // 리스트 길이
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 연결
        for (int i = 0; i < m; i++) {
            String[] inputLine = br.readLine().split(" ");
            int a = Integer.parseInt(inputLine[0]);
            int b = Integer.parseInt(inputLine[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        // 중복 방문 방지를 위한 방문 체크 배열
        boolean visited[] = new boolean[n+1];

        System.out.print(bfs(graph,visited));

    }



}
