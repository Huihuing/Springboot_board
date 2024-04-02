package com.korea.demo.domain;

import java.util.ArrayList;

public class ArticleView {

    public void printArticleList(ArrayList<Article> targetList) {

        System.out.println("===================");
        for (int i = 0; i < targetList.size(); i++) {

            Article article = targetList.get(i);

            System.out.println("번호 : " + article.getId());
            System.out.printf("제목 : %s\n", article.getTitle());
            System.out.println("===================");
        }
    }

    public String printArticleDetail(Article article) {
        String result = "===================";
        result += "번호 : " + article.getId();
        result += "제목 : " + article.getTitle();
        result += "내용 : " + article.getBody();
        result += "등록날짜 : " + article.getRegDate();
        result += "조회수 : " + article.getHit();
        result += "===================";
        return result;
    }
}
