package com.flexone.lakeservice.repositories;

import com.flexone.lakeservice.domain.Lake;
import org.springframework.data.repository.CrudRepository;

public interface LakeRepository extends CrudRepository<Lake, Long> {
}
