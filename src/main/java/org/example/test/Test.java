package org.example.test;

public class Test {
    public static void main(String[] args) {

        // 반복문 제어 -> break
        // break -> 반복문 강제 종료
        // continue -> 다음 회차로 넘어감. 다음 반복문 처음으로 돌아감. continue 밑에 있는 코드는 실행되지 않음.

        for(int i = 1; i <= 10; i++) {
            if(i % 2 == 0) {
                continue;
            }
            System.out.println(i);
        }

        int rst = test();
        System.out.println(rst);
    }

    public static int test() {
        int rst = 0;

        for(int i = 0; i < 10; i++) {
            if(i == 5) {
//                rst = i;
//                break;
                return i; // 함수는 return을 하게되면 종료된다.
            }
            System.out.println("==>" + i);
        }

        return 0;
    }
}

