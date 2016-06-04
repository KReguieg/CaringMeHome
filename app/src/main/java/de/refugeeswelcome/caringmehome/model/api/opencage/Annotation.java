package de.refugeeswelcome.caringmehome.model.api.opencage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by root1 on 04/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Annotation {

    private Geometry geometry;

    private String formatted;

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }
}
