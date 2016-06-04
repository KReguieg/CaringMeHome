package de.refugeeswelcome.caringmehome.model.api.planetlabs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/**
 * Created by root1 on 04/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties {

    private Map<String, String> links;

    private double area;

    public Map<String, String> getLinks() {
        return links;
    }

    public void setLinks(Map<String, String> links) {
        this.links = links;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
