package de.refugeeswelcome.caringmehome.model.api.opencage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by root1 on 04/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    List<Annotation> results;

    private Integer total_results;

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    public List<Annotation> getResults() {
        return results;
    }

    public void setResults(List<Annotation> results) {
        this.results = results;
    }
}
