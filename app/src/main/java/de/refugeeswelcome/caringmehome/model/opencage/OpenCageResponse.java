package de.refugeeswelcome.caringmehome.model.opencage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by root1 on 04/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenCageResponse {

    List<OpenCageAnnotations> results;

    private Integer total_results;

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public List<OpenCageAnnotations> getResults() {
        return results;
    }

    public void setResults(List<OpenCageAnnotations> results) {
        this.results = results;
    }
}
