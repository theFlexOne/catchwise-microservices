package com.flexone.fishservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FishRequest {

    private String family;
    private String species;
    private String genus;
    private String description;
    private String identification;

}
