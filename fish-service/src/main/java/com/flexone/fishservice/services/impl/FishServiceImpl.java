package com.flexone.fishservice.services.impl;

import com.flexone.fishservice.domain.Fish;
import com.flexone.fishservice.dto.FishRequest;
import com.flexone.fishservice.repositories.FishRepository;
import com.flexone.fishservice.services.FishService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FishServiceImpl implements FishService {

    final FishRepository fishRepository;


    @Override
    @SneakyThrows
    public Optional<Fish> getFishById(Long id) {
//        log.info("Waiting 10 seconds to simulate a slow service");
//        Thread.sleep(10000);
//        log.info("Done waiting");

        return fishRepository.findById(id);
    }

    @Override
    public List<Fish> getAllFish() {
        return (List<Fish>) fishRepository.findAll();
    }

    @Override
    public Fish addFish(FishRequest fishRequest) {
        Fish newFish = Fish.builder()
                .species(fishRequest.getSpecies())
                .description(fishRequest.getDescription())
                .identification(fishRequest.getIdentification())
                .build();

        return fishRepository.save(newFish);

    }
}
