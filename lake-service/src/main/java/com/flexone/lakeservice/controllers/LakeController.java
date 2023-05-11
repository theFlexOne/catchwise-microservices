package com.flexone.lakeservice.controllers;

import com.flexone.lakeservice.domain.Lake;
import com.flexone.lakeservice.dto.LakeRequest;
import com.flexone.lakeservice.services.LakeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/lakes")
public class LakeController {

    final LakeService lakeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Lake> getAllLakes() {
        return lakeService.getAllLakes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lake createLake(@RequestBody Lake lake) {
        return lakeService.createLake(lake);
    }

    @PostMapping("/{lakeId}/fish/{fishId}")
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "addFishToLake", fallbackMethod = "addFishToLakeFallback")
    @TimeLimiter(name = "addFishToLake")
    @Retry(name = "addFishToLake")
    public CompletableFuture<Lake> addFishToLake(@PathVariable Long lakeId, @PathVariable Long fishId) {
        return CompletableFuture.supplyAsync(() -> lakeService.addFishToLake(lakeId, fishId));
    }

    public CompletableFuture<Lake> addFishToLakeFallback(Long lakeId, Long fishId, RuntimeException e) {
        return CompletableFuture.supplyAsync(() -> {
            Lake fallbackLake = new Lake();
            fallbackLake.setName("Fallback Lake");
            return fallbackLake;
        });
    }

}
