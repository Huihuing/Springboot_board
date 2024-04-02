package com.korea.demo.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korea.demo.base.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
// Model - Controller - View
public class ArticleController { // Model + Controller

    CommonUtil commonUtil = new CommonUtil();
    ArticleRepository articleRepository = new ArticleRepository();

    @RequestMapping("/search")
    @ResponseBody
    public ArrayList<Article> search(@RequestParam(value="keyword", defaultValue = "") String keyword) {
        // 검색어를 입력
        ArrayList<Article> searchedList = articleRepository.findArticleByKeyword(keyword);
        return searchedList;
    }

    @RequestMapping("/searching")
    public String searching() {
        return "test2";
    }


    @RequestMapping("/detail/{articleID}")
    public String detail(@RequestParam("articleID") int articleID, Model model) {

        Article article = articleRepository.findArticleById(articleID);

        if (article == null) {
            return "없는 게시물입니다.";
        }

        article.increaseHit();
//      객체를 -> json 문자열로 변환 -> jackson 라이브러리 사용
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

    @GetMapping("/update/{articleID}")
    public String updateForm(@PathVariable("articleID") int articleID, Model model) {
        Article article = articleRepository.findArticleById(articleID);

        if (article == null) {
            throw new RuntimeException("없는 게시물입니다.");
        }

        model.addAttribute("article", article);
        return "updateForm";
        // return "%d번 게시물이 수정되었습니다.". formatted(inputID); 이렇게 해도 됨.
    }
    @PostMapping("/update/{articleID}")
    public String update(@PathVariable("articleID") int articleID, @RequestParam("title") String title, @RequestParam("body") String body) {
        Article article = articleRepository.findArticleById(articleID);

        if (article == null) {
            throw new RuntimeException("없는 게시물입니다.");
        }

        articleRepository.updateArticle(article, title, body);

        return "redirect:/detail/%d".formatted(articleID);
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
}
