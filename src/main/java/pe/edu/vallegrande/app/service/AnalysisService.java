package pe.edu.vallegrande.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.edu.vallegrande.app.model.AnalysisRequest;

@Service
public class AnalysisService {

    @Value("${ibm.watson.nlu.api-key}")
    private String apiKey;

    @Value("${ibm.watson.nlu.api-url}")
    private String apiUrl;

    public ResponseEntity<String> analyzeText(AnalysisRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("apikey", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<AnalysisRequest> requestBody = new HttpEntity<>(request, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestBody, String.class);

        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
