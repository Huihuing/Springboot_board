package com.korea.demo.domain;

import com.korea.demo.base.CommonUtil;

import java.util.ArrayList;

public class ArticleRepository {
    ArrayList<Article> articleList = new ArrayList<>();
    CommonUtil commonUtil = new CommonUtil();
    int latestArticleId = 4;

    public ArticleRepository() {
        makeTestData(); // 시작과 동시에 테스트 데이터 생성
    }

    public void makeTestData() {
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "냉무", 0, commonUtil.getCurrentDateTime());
        Article a2 = new Article(2, "자바 질문좀 할게요~", "냉무", 0, commonUtil.getCurrentDateTime());
        Article a3 = new Article(3, "정처기 따야되나요?", "냉무", 0, commonUtil.getCurrentDateTime());
        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);
    }

    public ArrayList<Article> findArticleByKeyword(String keyword) {
        ArrayList<Article> searchedList = new ArrayList<>();

        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);
            if (article.getTitle().contains(keyword)) {
                searchedList.add(article);
            }
        }

        return searchedList;
    }

    public Article findArticleById(int id) {

        for (int i = 0; i < articleList.size(); i++) {
            Article article = articleList.get(i);

            if (article.getId() == id) {
                return article;
            }
        }

        return null; // null -> 없다. 객체 타입에서만 사용 가능
    }

    public void deleteArticle(Article article) {
        articleList.remove(article);
    }

    public void updateArticle(Article article, String newTitle, String newBody) {
        article.setTitle(newTitle);
        article.setBody(newBody);
    }

    public ArrayList<Article> findAll() {
        return articleList;
    }

    public Article saveArticle(String title, String body) {

        Article article = new Article(latestArticleId, title, body, 0, commonUtil.getCurrentDateTime());
        articleList.add(article);
        latestArticleId++;

        return article;
    }
}
