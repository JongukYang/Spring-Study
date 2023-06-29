///////////////////////////////////////////////////////////////////////////////////////////// Test
//기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
//아래 표준 입출력 예제 필요시 참고하세요.
//표준 입력 예제
//int a = sc.nextInt();                 // int 변수 1개 입력받는 예제
//double b = sc.nextDouble();           // double 변수 1개 입력받는 예제
//long AB = sc.nextLong();              // long 변수 1개 입력받는 예제
//String str = sc.next();               // 문자열 1개 입력받는 예제
//char c = str.charAt(0);               // 입력받은 문자열에서 char 변수 1개 가져오는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
//표준 출력 예제
//int a = 0;
//double b = 1.0;
//long AB = 12345678901234567L;
//String str = "ABCDEFG";
//char c = 'b';
//System.out.println(a);                // int 변수 1개 출력하는 예제
//System.out.println(b);                // double 변수 1개 출력하는 예제
//System.out.println(AB);               // long 변수 1개 출력하는 예제
//System.out.println(str);              // 문자열 1개 출력하는 예제
//System.out.println(c);                // char 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;
import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
*/
// N 명의 사람이 좌우 일렬로 서 있음
// 각 사람들은 특정한 거리의 사람에게 편지 보냄
// 특정한 사람이 보낼 거리의 위치에 사람이 없을수도 있음
// 서로 감사 편지를 주고 받은 사람들의 쌍의 개수 구하기
// 양의 정수인 경우 오른쪽, 음이면 왼쪽으로 전달하는 것
public class Solution1
{
    public static void main(String args[]) throws Exception
    {

//        System.setIn(new java.io.FileInputStream("/Users/jongukyang/GitHub-LocalRepo/Spring-Study/untitled/src/Sample_input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		*/
        Scanner sc = new Scanner(System.in);

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++)
        {
            /////////////////////////////////////////////////////////////////////////////////////////////
		    int N = sc.nextInt();
            int[] people = new int[N];

            for (int i = 0; i < people.length; i++) {
                people[i] = sc.nextInt();
            }

            int answer = 0;
            int idx = 0;
            boolean[] visited = new boolean[N];
            while (idx != people.length) {
                if (visited[idx]) {
                    idx++;
                    continue;
                }

                // 인덱스
                int n = idx + people[idx];

                // 양수면
                if (people[idx] > 0) {
                    // 배열의 범위를 벗어나면
                    if (n > people.length-1) {
                        visited[idx] = true;
                        continue;
                    } else {
                        if (people[idx] == people[n]*-1) {
                            visited[idx] = true;
                            visited[n] = true;
                            answer++;
                        }
                    }
                }
                // 음수면
                else {
                    if (n < 0) {
                        visited[idx] = true;
                        continue;
                    } else {
                        if (people[idx] == people[n]*-1) {
                            visited[idx] = true;
                            visited[n] = true;
                            answer++;
                        }
                    }
                }
                idx++;
            }

            /////////////////////////////////////////////////////////////////////////////////////////////

            // 표준출력(화면)으로 답안을 출력합니다.
            System.out.println("#" + test_case + " " + answer);
        }

        sc.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
    }
}


//제한 조건
//
//실행시간 : 50개의 테스트 케이스를 합쳐서 C/C++의 경우 1초, JAVA의 경우 1초, Python 2초
//
//메 모 리 : Heap, Global, Stack 등을 모두 합해 최대 256MB까지 사용 가능 (단, 스택은 최대 1MB까지 사용 가능)
//
//제출 횟수 제한
//
//제한 없음
//
//채점
//
//Accept : 정상적으로 제출되었다는 의미 (컴파일 에러 등 없다는 의미이며 점수는 공개하지 않음)
//
//Fail : 컴파일, 런타임 에러 등으로 0점
//
//평가
//
//sample_input은 편의를 위해 제공하며, 실제 채점은 별도의 평가용 input으로 이루어진다.
//
//
//
//
//
//
//N명의 사람들이 좌우 일렬로 서 있다
//
//
//
//
//각 사람들은 특정한 거리의 사람에게 감사하는 마음을 담아 편지 한 통을 보냈다.
//
//
//주어진 거리가 양의 정수인 경우 오른쪽, 음의 정수인 경우 왼쪽을 의미한다.
//
//이 때 서로 감사 편지를 주고 받은 사람들의 쌍의 개수를 계산하라.
//
//특정한 사람이 보낸 거리의 위치에 사람이 없을 수도 있다는 것에 주의하라.
//
//
//
//예를 들어, N = 3이고 왼쪽 사람부터, 편지를 보낸 거리가 2, 1, -2라고 하자.
//
//제일 왼쪽 사람과 제일 오른쪽 사람이 서로 편지를 주고받았으며,
//
//이것이 유일한 쌍임을 알 수 있다.
//
//따라서 이 경우 답은 1이다.
//
//
//
//[제약사항]
//
//
//
//편지의 개수 N은 1 이상 200 이하이다. (1 ≤ N ≤ 200)
//
//각 사람이 편지를 보낸 거리의 절댓값은 200 이하이다.
//
//
//
//[입력]
//
//가장 첫 줄에는 테스트 케이스의 총 수가 주어진다.
//
//그 다음 줄부터 각 테스트 케이스가 주어지며, 각 테스트 케이스는 2 줄로 구성된다.
//
//각 테스트 케이스의 첫 줄에는 N이 주어진다.
//
//다음 줄에 N명의 사람이 편지를 보낸 거리가 제일 왼쪽 사람부터 순서대로 주어진다.
//
//
//
//[출력]
//
//출력의 각 줄은 ‘#x’로 시작하고, 공백을 한 칸 둔 다음 서로 편지를 주고 받은 쌍의 수를 출력한다. 단, x는 테스트 케이스의 번호이다.
//
//
//
//[입력 예]
//
//3                       // 테스트 케이스의 수
//
//2                       // N = 2, 테스트 케이스 #1
//
//1 -1
//
//3                       // N = 3, 테스트 케이스 #2
//
//2 1 -2
//
//5                       // N = 5, 테스트 케이스 #3
//
//-4 1 -1 3 1
//
//
//
//[출력 예]
//
//#1 1
//
//#2 1
//
//#3 1
//
//


//.문제2
//제한 조건
//
//실행시간 : 50개의 테스트 케이스를 합쳐서 C/C++의 경우 3초, JAVA의 경우 3초, Python 6초
//
//메 모 리 : Heap, Global, Stack 등을 모두 합해 최대 256MB까지 사용 가능 (단, 스택은 최대 1MB까지 사용 가능)
//
//제출 횟수 제한
//
//제한 없음
//
//채점
//
//Accept : Sample_input으로 채점시 정상적으로 제출되었다는 의미
//
//            (단순히 컴파일 에러 등 없다는 의미이며 점수는 공개하지 않음)
//
//Fail : 컴파일, 런타임 에러 등으로 0점
//
//평가
//
//Sample_input은 편의를 위해 제공하며, 실제 채점은 별도의 평가용 input으로 이루어진다.
//
//
//
//
//
//
//수직선(x축)의 좌표 0인 곳과 좌표 D인 곳에 각각 폭죽 발사 장치가 있다.
//
//좌표 0인 곳의 발사 장치는 오른쪽으로, 좌표 D인 곳의 발사 장치는 왼쪽으로 폭죽을 발사한다. 두 폭죽은 동시에 같은 속도로 발사된다.
//
//폭죽의 속도는 1초에 거리 1을 이동하는 속도이다.
//
//두 발사 장치의 사이에는 N개의 시간 지연 장치가 있다.
//
//각 시간 지연 장치에 폭죽이 들어가면 해당 장치의 지연만큼 장치 안에서 잡혀 있다가 다시 이동한다.
//
//
//
//각 지연 장치는 (위치, 지연)의 쌍으로 주어진다. 두 폭죽이 만나면 폭발한다. 폭죽이 폭발하는 위치를 계산하라. 폭죽이 시간 지연 장치의 위치에서 폭발할 수도 있음에 주의하라.
//
//
//
//예를 들어 D = 100이고 3개의 지연 장치가 있다고 하자.
//
//장치들의 위치는 좌표 2, 4, 6인 곳이고 지연은 모두 2로 동일하다고 하자. 이 경우 좌표 0에서 발사된 폭죽은 정확히 2초에 왼쪽 첫 지연 장치에 도착하고, 2초 후인 4초에 지연 장치를 떠난다.
//
//4초와 5초 사이에는 좌표 2와 3 사이에 있고, 정확히 5초에 좌표 3에 있다.
//
//이와 같이 따져 보면 세번째 지연 장치를 떠나는 시점은 정확히 12초이다.
//
//(12초와 13초 사이에는 좌표 6과 7인 점 사이에 있고 13초에 좌표 7인 점에 도착한다.)
//
//12초에 오른쪽에서 발사된 폭죽은 좌표 88인 위치에 있다.
//
//따라서, 두 폭죽은 좌표 47인 점에서 만난다.
//
//
//
//[제약사항]
//
//
//
//D는 10 이상 10,000 이하의 짝수이다.
//
//지연장치의 개수 N은 1 이상 500 이하이다.
//
//각 지연장치의 좌표는 2 이상 D-2 이하의 짝수이다.
//
//각 지연장치의 지연은 2 이상 200 이하의 짝수이다.
//
//지연 장치의 위치가 겹치는 경우는 없다.
//
//두 폭죽이 만나는 위치의 좌표가 정수가 아닌 경우는 주어지지 않는다.
//
//
//
//[입력]
//
//가장 첫 줄에는 테스트 케이스의 총 수가 주어진다.
//
//그 다음 줄부터 각 테스트 케이스가 주어지며, 각 테스트 케이스는 N+1 줄로 구성된다. 각 테스트 케이스의 첫 줄에는 N과 D가 주어진다. 다음 N개의 줄에 지연장치의 정보가 좌표와 지연의 두 정수로 주어진다. 지연장치들은 좌표 값이 증가하는 순서로 주어진다.
//
//
//
//[출력]
//
//출력의 각 줄은 ‘#x’로 시작하고, 공백을 한 칸 둔 다음 두 폭죽이 만나는 위치의 좌표를 정수로 출력한다. 단, x는 테스트 케이스의 번호이다.
//
//
//
//[입력 예]
//
//3                    // 테스트 케이스의 수
//
//1 10                 // N = 1, D = 10 테스트 케이스 #1
//
//8 2
//
//3 100                // N = 3, D = 100 테스트 케이스 #2
//
//2 2
//
//4 2
//
//6 2
//
//3 100                // N = 3, D = 100 테스트 케이스 #3
//
//2 2
//
//50 2
//
//98 4
//
//
//
//[출력 예]
//
//#1 6
//
//#2 47
//
//#3 50