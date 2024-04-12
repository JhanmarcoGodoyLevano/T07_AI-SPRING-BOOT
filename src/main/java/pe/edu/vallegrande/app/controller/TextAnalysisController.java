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
public class TextAnalysisController {

    @GetMapping(value = "/analyze-text", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> analyzeText() {
        // API Key proporcionada por IBM Watson
        String apiKey = "YJaDwuQIFcWqE9eDM3sV_wvV7SoF7efcZZrcCvyYFLe5";
        // URL de la API de IBM Watson Natural Language Understanding
        String url = "https://api.us-east.natural-language-understanding.watson.cloud.ibm.com/instances/c36e7ec0-b19c-4f02-ab6a-fab0a132757f/v1/analyze?version=2019-07-12";
        
        // Configuración de cabeceras para la solicitud HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("apikey", apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Texto que se analizará
        String text = "Mi gato está jugando con su amigo Sebastián.";
        // Objetivos para el análisis de sentimiento
        String[] targets = {"gato", "jugando", "Sebastián"};
        // Indicador para activar el análisis de emociones
        boolean emotion = true;

        // Construcción del cuerpo de la solicitud en formato JSON
        JSONObject requestBody = new JSONObject();
        requestBody.put("text", text);
        JSONObject features = new JSONObject();
        features.put("sentiment", new JSONObject().put("targets", targets));
        features.put("keywords", new JSONObject().put("emotion", emotion));
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
