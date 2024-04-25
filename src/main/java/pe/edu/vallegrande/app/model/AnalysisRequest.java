package pe.edu.vallegrande.app.model;

public class AnalysisRequest {
    private long id;
    private String text;
    private AnalysisFeatures features;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AnalysisFeatures getFeatures() {
        return features;
    }

    public void setFeatures(AnalysisFeatures features) {
        this.features = features;
    }
}
