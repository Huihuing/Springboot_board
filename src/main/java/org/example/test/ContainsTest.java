package org.example.test;

public class ContainsTest {
    public static void main(String[] args) {
        String title = "자바 공부하는 중이에요";
        String keyword = "자바";

        if (title.contains(keyword)) {
            System.out.println("문자열에 '" + keyword + "'가 포함되어 있습니다.");
        } else {
            System.out.println("문자열에 '" + keyword + "'가 포함되어 있지 않습니다.");
        }
    }
}
