package com.flexone.fishservice.services.impl;

import com.flexone.fishservice.domain.Fish;
import com.flexone.fishservice.dto.FishRequest;
import com.flexone.fishservice.repositories.FishRepository;
import com.flexone.fishservice.services.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FishServiceImpl implements FishService {

    final FishRepository fishRepository;


    @Override
    public Optional<Fish> getFishById(Long id) {
        return fishRepository.findById(id);
    }

    @Override
    public List<Fish> getAllFish() {
        return (List<Fish>) fishRepository.findAll();
    }

    @Override
    public Fish addFish(FishRequest fishRequest) {
        Fish newFish = Fish.builder()
                .name(fishRequest.getName())
                .description(fishRequest.getDescription())
                .identification(fishRequest.getIdentification())
                .build();

        return fishRepository.save(newFish);

    }
}
