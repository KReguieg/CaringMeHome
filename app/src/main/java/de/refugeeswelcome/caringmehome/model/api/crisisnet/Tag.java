package de.refugeeswelcome.caringmehome.model.api.crisisnet;

/**
 * Created by root1 on 05/06/16.
 */
public class Tag {
    private int confidence;
    private String name;

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
