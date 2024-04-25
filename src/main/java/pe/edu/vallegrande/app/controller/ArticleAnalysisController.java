package pe.edu.vallegrande.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.app.model.ArticleRequest;
import pe.edu.vallegrande.app.service.ArticleService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ArticleAnalysisController {

    @Autowired
    private ArticleService articleService;

    private List<ArticleRequest> articleRequests = new ArrayList<>();
    private final AtomicLong idSequence = new AtomicLong();

    @PostMapping(value = "/analyze-article", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> analyzeArticle(@RequestBody ArticleRequest request) {
        request.setId(idSequence.incrementAndGet());
        articleRequests.add(request);
        return articleService.analyzeArticle(request);
    }

    @GetMapping("/analysis-request")
    public ResponseEntity<List<ArticleRequest>> getAllAnalysisRequests() {
        return new ResponseEntity<>(articleRequests, HttpStatus.OK);
    }
}
