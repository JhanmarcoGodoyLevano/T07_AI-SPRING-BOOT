package pe.edu.vallegrande.app.model;

public class ArticleRequest {
    private long id;
    private String url;
    private ArticleFeatures features = new ArticleFeatures();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArticleFeatures getFeatures() {
        return features;
    }

    public void setFeatures(ArticleFeatures features) {
        this.features = features;
    }
}
