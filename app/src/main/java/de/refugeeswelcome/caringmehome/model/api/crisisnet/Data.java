package de.refugeeswelcome.caringmehome.model.api.crisisnet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by root1 on 05/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private String license;
    private String fromUrl;
    private String summary;
    private String content;
    private String lifespan;
    private String contentEnglish;
    private List<Tag> tags;
    private List<String> entities;

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getFromUrl() {
        return fromUrl;
    }

    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLifespan() {
        return lifespan;
    }

    public void setLifespan(String lifespan) {
        this.lifespan = lifespan;
    }

    public String getContentEnglish() {
        return contentEnglish;
    }

    public void setContentEnglish(String contentEnglish) {
        this.contentEnglish = contentEnglish;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<String> getEntities() {
        return entities;
    }

    public void setEntities(List<String> entities) {
        this.entities = entities;
    }
}
