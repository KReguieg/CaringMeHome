package de.refugeeswelcome.caringmehome.model.api.planetlabs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import de.refugeeswelcome.caringmehome.util.GeocoderAPI;

/**
 * Created by root1 on 04/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

    private String type;
    private String id;

    private Properties properties;

    private Geometry geometry;



    private String published;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
