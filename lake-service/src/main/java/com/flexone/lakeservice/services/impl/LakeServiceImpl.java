package com.flexone.lakeservice.services.impl;

import com.flexone.lakeservice.services.LakeService;
import com.flexone.lakeservice.domain.Lake;
import com.flexone.lakeservice.repositories.LakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LakeServiceImpl implements LakeService {

    final LakeRepository lakeRepository;
    final WebClient.Builder webClientBuilder;


    @Override
    public List<Lake> getAllLakes() {
        return (List<Lake>) lakeRepository.findAll();
    }

    @Override
    public Lake createLake(Lake lake) {
        return lakeRepository.save(lake);
    }

    @Override
    public Lake addFishToLake(Long lakeId, Long fishId) {
        Lake lake = lakeRepository.findById(lakeId).orElseThrow();
        String isValidFishId = webClientBuilder.build().get()
                .uri("http://fish-service/api/fish/" + fishId)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        if (isValidFishId != null) {
            lake.getFishIds().add(fishId);
            lakeRepository.save(lake);
        } else {
            throw new IllegalArgumentException("Invalid fish id");
        }

        return lake;
    }

}
