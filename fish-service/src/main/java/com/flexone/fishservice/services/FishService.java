package com.flexone.fishservice.services;

import com.flexone.fishservice.domain.Fish;
import com.flexone.fishservice.dto.FishRequest;

import java.util.List;
import java.util.Optional;

public interface FishService {

    Optional<Fish> getFishById(Long id);
    List<Fish> getAllFish();

    Fish addFish(FishRequest fishRequest);
}
