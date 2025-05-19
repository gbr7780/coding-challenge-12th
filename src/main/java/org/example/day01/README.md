# 코딩테스트 챌린지 12기_새싹반 Day1

## 📌 문제
백준 2309 - [일곱 난쟁이](https://www.acmicpc.net/problem/2309)

## 📌 문제 탐색하기
문제를 탐색했을때, 고민해야할 부분은
1. 합이 100인 일곱 난쟁이 구하기
2. 일곱 난쟁이 정렬하기



합이 100인 일곱 난쟁이를 구해야할 때 생각하는 방법으로
1. 브루트 포스 기법을 사용하여 7개의 정수를 찾거나
2. 아홉 난쟁이중에서 2개의 거짓 난쟁이를 제거하여 합이 100인 일곱 난쟁이를 찾기

## 📌 코드 설계하기
1. 아홉개 정수 입력 받기
2. 배열 오름차순으로 정렬
3. 이중 반복문을 통해 아홉개 정수 합에서 i 인덱스와 j 인덱스 값을 빼서 100인 숫자 찾기
4. 결과값 출력

## 📌 시도 회차 수정 사항 (Optional)
없음

## 📌 풀이 코드
```java
public class Day01_BaekJoon_Q2309 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 초기화
        int[] intArr = new int[9];
        int sum = 0;

        // 9개의 정수 입력 받음
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(br.readLine());
            sum += intArr[i];
        }

        // 오름차순 정렬
        Arrays.sort(intArr);

        // 2개의 거짓 난쟁이 인덱스 저장
        int a = 0, b = 0;

        for (int i = 0; i < intArr.length-1; i++) {

            for (int j = i+1; j < intArr.length; j++) {

                // 7개의 숫자가 100일때
                if (sum - (intArr[i] + intArr[j]) == 100) {
                    a = i;
                    b = j;
                    break;
                }

            }
        }

        // 결과값 출력
        for (int i : intArr) {
            if (i != intArr[a] && i != intArr[b]) {
                bw.write( String.valueOf(i) + "\n");
            }
        }

        bw.flush();
        bw.close();


    }





}