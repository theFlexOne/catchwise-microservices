package com.flexone.fishservice.repositories;

import com.flexone.fishservice.domain.Fish;
import org.springframework.data.repository.CrudRepository;

public interface FishRepository extends CrudRepository<Fish, Long> {
}
