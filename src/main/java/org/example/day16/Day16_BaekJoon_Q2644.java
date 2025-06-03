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
