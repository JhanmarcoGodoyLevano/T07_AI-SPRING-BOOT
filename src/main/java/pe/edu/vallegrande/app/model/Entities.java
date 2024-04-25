package pe.edu.vallegrande.app.model;

import java.util.List;

public class Entities {
    private List<String> types;
    private String relevance;

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }
}
