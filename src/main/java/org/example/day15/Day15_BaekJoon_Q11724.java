package org.example.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * description    : 백준 11724 - 연결 요소의 개수
 * packageName    : org.example.day15
 * fileName        : Day15_BaekJoon_Q11724
 * author         : kimjongha
 * date           : 25. 6. 2.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * —————————————————————————————
 * 25. 6. 2.        kimjongha       최초 생성
 */
public class Day15_BaekJoon_Q11724 {

    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        // 정점 수
        int n = Integer.parseInt(input[0]);
        // 간선 수
        int m = Integer.parseInt(input[1]);

        // 노드가 1부터 시작이므로
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);

        }

        int count = 0;

        // 모든 정점에 대해 DFS 수행
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);

    }

    static void dfs (int node) {
        visited[node] = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }

    }



}
