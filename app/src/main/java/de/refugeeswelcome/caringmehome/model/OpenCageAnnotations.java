package de.refugeeswelcome.caringmehome.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.refugeeswelcome.caringmehome.util.OpenCageGeocoder;

/**
 * Created by root1 on 04/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenCageAnnotations {

    private OpenCageGeometry geometry;

    private String formatted;

    public OpenCageGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(OpenCageGeometry geometry) {
        this.geometry = geometry;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }
}
