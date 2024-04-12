package pe.edu.vallegrande.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.json.JSONObject;

@RestController
public class ArticleAnalysisController {

    @GetMapping(value = "/analyze-article", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> analyzeArticle() {
        // API Key proporcionada por IBM Watson
        String apiKey = "YJaDwuQIFcWqE9eDM3sV_wvV7SoF7efcZZrcCvyYFLe5";
        // URL de la API de IBM Watson Natural Language Understanding
        String url = "https://api.us-east.natural-language-understanding.watson.cloud.ibm.com/instances/c36e7ec0-b19c-4f02-ab6a-fab0a132757f/v1/analyze?version=2019-07-12";
        
        // Configuración de cabeceras para la solicitud HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("apikey", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // URL del artículo de noticias que se analizará
        String articleUrl = "https://rpp.pe/cine/internacional/joker-folie-a-deux-estrena-trailer-oficial-con-joaquin-phoenix-y-lady-gaga-como-harley-quinn-noticia-1546686";
        // Características que se solicitarán en el análisis
        JSONObject features = new JSONObject();
        features.put("sentiment", new JSONObject());
        features.put("categories", new JSONObject());
        features.put("concepts", new JSONObject());
        features.put("entities", new JSONObject());
        features.put("keywords", new JSONObject());

        // Construcción del cuerpo de la solicitud en formato JSON
        JSONObject requestBody = new JSONObject();
        requestBody.put("url", articleUrl);
        requestBody.put("features", features);

        // Creación de la entidad de la solicitud HTTP con el cuerpo y las cabeceras
        HttpEntity<String> request = new HttpEntity<>(requestBody.toString(), headers);

        // Creación de una instancia de RestTemplate para hacer la solicitud POST a la API de IBM Watson
        RestTemplate restTemplate = new RestTemplate();
        // Realización de la solicitud y obtención de la respuesta
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        // Retorno de la respuesta obtenida al cliente
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
