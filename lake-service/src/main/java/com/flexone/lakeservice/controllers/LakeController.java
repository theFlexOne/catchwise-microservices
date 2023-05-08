package com.flexone.lakeservice.controllers;

import com.flexone.lakeservice.domain.Lake;
import com.flexone.lakeservice.services.LakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Lake addFishToLake(@PathVariable Long lakeId, @PathVariable Long fishId) {
        return lakeService.addFishToLake(lakeId, fishId);
    }
}
