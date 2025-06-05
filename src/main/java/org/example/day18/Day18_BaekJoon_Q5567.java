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
