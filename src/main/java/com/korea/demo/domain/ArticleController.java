package com.korea.demo.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korea.demo.base.CommonUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Scanner;

@Controller
// Model - Controller - View
public class ArticleController { // Model + Controller

    CommonUtil commonUtil = new CommonUtil();
    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();

    @RequestMapping("/search")
    @ResponseBody
    public ArrayList<Article> search(@RequestParam("find") String keyword) {
        // 검색어를 입력
        ArrayList<Article> searchedList = articleRepository.findArticleByKeyword(keyword);

        articleView.printArticleList(searchedList);
        return searchedList;
    }

    @RequestMapping("/searching")
    public String searching() {
        return "test2";
    }
    @RequestMapping("/detail")
    public String detail(@RequestParam("articleID") int inputId, Model model) {
        Article article = articleRepository.findArticleById(inputId);

        if (article == null) {
            return "없는 게시물입니다.";
        }
        article.increaseHit();
//        article.increaseHit();
//        return articleView.printArticleDetail(article);
//        return articleList;

//        객체를 -> json 문자열로 변환 -> jackson 라이브러리 사용
        model.addAttribute("article", article);
        return "detail";

    }

    @RequestMapping("/delete/{articleID}")
    public String delete(@RequestParam("articleID") int inputId) {

        Article article = articleRepository.findArticleById(inputId);

        if (article == null) {
            return "없는 게시물입니다.";
        }

        articleRepository.deleteArticle(article);
       return "redirect:/list";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestParam("articleID") int inputId, @RequestParam("newTitle") String newTitle, @RequestParam("newBody") String newBody) {
        Article article = articleRepository.findArticleById(inputId);

        if (article == null) {
            return "없는 게시물입니다.";
        }

        articleRepository.updateArticle(article, newTitle, newBody);
        return inputId + "번 게시물이 수정되었습니다.";
        // return "%d번 게시물이 수정되었습니다.". formatted(inputID); 이렇게 해도 됨.
    }

    @RequestMapping("/list")
    public String list(Model model) {
        ArrayList<Article> articleList = articleRepository.findAll();
        model.addAttribute("alist", articleList);
        return "list";
//      articleView.printArticleList(articleList); // 전체 출력 -> 전체 저장소 넘기기
    }

    @RequestMapping("/add")
//    @ResponseBody <- 있을 경우 리턴은 있는 그대로 "출력"함
    public String add(@RequestParam("title") String title, @RequestParam("body") String body) {
        articleRepository.saveArticle(title, body);
        return "redirect:/list"; // 브라우저의 주소가 /list로 바뀜
    }

    @RequestMapping("/adding")
    public String adding() {
        return "test";
    }

    @PostMapping("/update/{articleID}")
    public String updateForm(@PathVariable("articleID") int articleid, Model model)) {
        Article article = articleRepository.findArticlebyid(articleID);

        if (article == null) {
            throw new RuntimeException("없는 게시물입니다.");
        }

        model.addAttribute("article", article);
        return "redirect:/detail/%d".formatted(articleid);
    }
    @PostMapping("/update/{articleID}") {
    public String update(@)
    }
}
