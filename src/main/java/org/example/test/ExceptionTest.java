package org.example.test;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        System.out.println(numbers[3]); // ArrayIndexOutOfBoundsException
//        car.drive(); // NullPointerException

//        Integer.parseInt(scanner.nextLine()); // NumberFormatException

//        System.out.println("hihi");
        // 익셉션 -> 발생 -> 프로그램이 종료

        // 익셉션 핸들링 -> 예외 처리

        // try catch

        try {

            int[] numbers = {1,2,3};
            System.out.println(numbers[2]); // ArrayIndexOutOfBoundsException

            Car car = new Car(); // null 비어있다.
            car.drive(); // NullPointerException

            Integer.parseInt(scanner.nextLine()); // NumberFormatException

        } catch(Exception e) { // 모든 예외를 일괄처리
            System.out.println("무슨 문제가 발생했습니다.");
        }

        // 예외 종류를 선별해서 처리
//        catch(ArrayIndexOutOfBoundsException e) {
//            System.out.println("배열의 인덱스를 다시 확인해주세요.");
//        } catch (NullPointerException e) {
//            System.out.println("Car 객체를 다시 확인해주세요.");
//        } catch (NumberFormatException e) {
//            System.out.println("숫자를 입력해주셔야 합니다.");
//        }

        System.out.println("hihi");
    }
}

class Car {

    public void drive() {
        System.out.println("drive");
    }

}
