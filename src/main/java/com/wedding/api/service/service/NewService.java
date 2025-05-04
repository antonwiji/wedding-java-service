package com.wedding.api.service.service;

import com.wedding.api.service.dto.news.NewsResDto;
import com.wedding.api.service.entity.NewsEntity;
import com.wedding.api.service.repository.NewsRepository;
import com.wedding.api.service.utils.GenerateResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NewService {

    @Autowired
    private NewsRepository newsRepository;

    public ResponseEntity<NewsResDto> getAllNews() {

        List<NewsEntity> getNewsData = newsRepository.findAll();

        if (getNewsData.isEmpty()) {
            return GenerateResponse.generate(null, HttpStatus.NOT_FOUND, "Error");
        }

        return GenerateResponse.generate(getNewsData, HttpStatus.OK, "Success");

    }

}
