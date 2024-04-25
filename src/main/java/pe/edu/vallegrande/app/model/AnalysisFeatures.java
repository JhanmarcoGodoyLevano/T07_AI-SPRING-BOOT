package pe.edu.vallegrande.app.model;

public class AnalysisFeatures {
    private Sentiment sentiment;
    private Keywords keywords;

    public Sentiment getSentiment() {
        return sentiment;
    }

    public void setSentiment(Sentiment sentiment) {
        this.sentiment = sentiment;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }
}
