package pe.edu.vallegrande.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.app.model.AnalysisRequest;
import pe.edu.vallegrande.app.service.AnalysisService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TextAnalysisController {

    @Autowired
    private AnalysisService analysisService;

    private final AtomicLong counter = new AtomicLong();
    private final List<AnalysisRequest> analysisRequests = new ArrayList<>();

    @PostMapping(value = "/analyze-text", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> analyzeText(@RequestBody AnalysisRequest request) {
        long id = counter.incrementAndGet();
        request.setId(id);
        analysisRequests.add(request);
        return analysisService.analyzeText(request);
    }

    @GetMapping("/analysi-requests")
    public ResponseEntity<List<AnalysisRequest>> getAllAnalysisRequests() {
        return new ResponseEntity<>(analysisRequests, HttpStatus.OK);
    }
}
