package de.refugeeswelcome.caringmehome.model.api.crisisnet;

import java.util.List;

/**
 * Created by root1 on 05/06/16.
 */
public class Response {

    private int total;
    private List<Data> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
