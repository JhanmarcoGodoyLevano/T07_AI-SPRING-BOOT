package pe.edu.vallegrande.app.model;

import java.util.List;

public class Concepts {
    private List<String> names;
    private String relevance;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getRelevance() {
        return relevance;
    }

    public void setRelevance(String relevance) {
        this.relevance = relevance;
    }
}
