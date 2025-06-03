# 코딩테스트 챌린지 12기_입문반 Day16

## 📌 문제
백준 2644 - [촌수계산](https://www.acmicpc.net/problem/2644)

## 📌 문제 탐색하기
### 문제 접근 방법
지난 문제와 비슷하게 그래프의 거리를 구하는 문제이다 사람들 간의 부모- 자식 관계를 입력 받고, 두 사람 사이의 촌수(그래프 상의 거리) 구하기
1. 입력을 통해 그래프를 구현하고
2. 방문 확인을 위한 visited 배열 필요
3. 그래프의 거리를 구하기 위해선는 BFS 또는 DFS 알고리즘을 구현해야하는데 거리 계산(최단 거리를 찾는것)는 BFS(너비 우선 탐색)이 적합 하기에 BFS를 사용하기



## 📌 코드 설계하기
1. 입력 받기(전체 사람의 수 - n, 촌수 계산 번호 - start end, 관계대수 - m )
2. 그래프 초기화 및 간선 입력
3. BFS 구현하기
4. 반복문을 통해 방문하지 않은 번호이면 BFS 수행하고 depth+1
5. 목표 번호를 찾으면 depth 출력하고 종료



## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
package org.example.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * description    : 백준 2644 - 촌수계산
 * packageName    : org.example.day16
 * fileName        : Day16_BaekJoon_Q2644
 * author         : kimjongha
 * date           : 25. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 6. 3.        kimjongha       최초 생성
 */
public class Day16_BaekJoon_Q2644 {

    // BFS
    public static int bfs(int start, int end, List<Integer>[] graph, boolean[] visited) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;  // 중복 탐색 방지위해
        queue.add(new int[]{start, 0}); // 시작 번호와 깊이(촌수)를 큐에 삽입

        while (!queue.isEmpty()) {
            // 큐의 맨 앞에 번호를 꺼내기
            int[] cur = queue.poll();
            int now = cur[0];   // 다음 번호
            int depth = cur[1];     // 촌수

            // 목표 찾을때
            // BFS 특성상 처음 도달한 번호가 최단 경로
            if (now == end) return depth;

            // 현재 노드에 연결된 사람
            for (int next : graph[now]) {
                // 방문 하지 않은 번호면 큐에 삽입
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth+1});
                }

            }

        }

        // 도달할 수 없을때
        return -1;


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 사람의 수
        int n = Integer.parseInt(br.readLine());

        // 촌수 계산 번호
        String[] InputLine = br.readLine().split(" ");
        int start = Integer.parseInt(InputLine[0]);
        int end = Integer.parseInt(InputLine[1]);


        // 관계 대수
        int m = Integer.parseInt(br.readLine());

        // 그래프
        List<Integer>[] graph = new ArrayList[n+1];
        // 방문 여부 확인
        boolean[] visited = new boolean[n+1];


        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);

        }


        System.out.print(bfs(start,end,graph,visited));



    }

}
