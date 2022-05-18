package it.sevenbits.courses.testing.practice.web.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderRequestBody {

    private List<Long> foodIdList;

    /**
     * The basic constructor
     *
     * @param foodIdList - list of food id
     */
    @JsonCreator
    public OrderRequestBody(
            @JsonProperty("foodIdList") final List<Long> foodIdList
    ) {
        this.foodIdList = foodIdList;
    }


    public List<Long> getFoodIdList() {
        return foodIdList;
    }


}
