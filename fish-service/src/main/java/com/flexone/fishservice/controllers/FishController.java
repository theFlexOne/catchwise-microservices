package com.flexone.fishservice.controllers;

import com.flexone.fishservice.domain.Fish;
import com.flexone.fishservice.dto.FishRequest;
import com.flexone.fishservice.services.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/fish")
@RequiredArgsConstructor
public class FishController {

    final FishService fishService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Fish> getAllFish() {
        return fishService.getAllFish();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Fish getFishById(@PathVariable Long id) {
        Optional<Fish> fish = fishService.getFishById(id);
        if (fish.isPresent()) {
            return fish.get();
        } else {
            throw new NoSuchElementException("Fish not found");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fish createFish(@RequestBody FishRequest fishRequest) {

        Fish fish = fishService.addFish(fishRequest);

        if (fish.getId() > 0) {
            return fish;
        } else {
            throw new NoSuchElementException("Fish not found");
        }

    }


}
