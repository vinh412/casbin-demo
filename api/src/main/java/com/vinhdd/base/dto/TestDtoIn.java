package com.vinhdd.base.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TestDtoIn {
    @JsonProperty("eTag")
    private String eTag;
}
