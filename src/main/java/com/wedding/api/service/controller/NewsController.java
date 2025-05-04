package com.wedding.api.service.controller;

import com.wedding.api.service.dto.news.NewsResDto;
import com.wedding.api.service.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NewsController {

    @Autowired
    private NewService newService;

    @GetMapping("/news")
    public ResponseEntity<NewsResDto> getNewsData() {
        return newService.getAllNews();
    }

}
