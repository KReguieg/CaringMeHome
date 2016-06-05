package de.refugeeswelcome.caringmehome.model.api.crisisnet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by root1 on 05/06/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Geo {
    private AddressComponents addressComponents;
    private List<Integer> coords;
}
